package construrraptor.accesoadatos;

import java.util.*;
import java.sql.*;
import construrraptor.entidadesdenegocio.*;
import java.time.LocalDate;

public class CarritoCompraDAL {

    static String ObtenerCampos() {
        return "r.Id_carrito_compra";
    }

    private static String ObtenerSelect(CarritoCompras pCarrito) {
        String sql;
        sql = "SELECT ";
        if (pCarrito.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.SQLSERVER) {
            sql += "Top " + pCarrito.getTop_aux();
        }
        sql += (ObtenerCampos() + "FROM carrito_compra r");
        return sql;
    }

    private static String AgregarOrderBy(CarritoCompras pCarrito) {
        String sql = " ORDER BY Id_carrito_compra DESC";
        if (pCarrito.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.MYSQL) {
            sql += " LIMIT " + pCarrito.getTop_aux() + " ";
        }
        return sql;
    }

    public static int crear(CarritoCompras pCarrito) throws Exception {
        int result = 0;
        String sql;
        try (Connection con = ComunDB.obtenerConexion();) {
            sql = "INSERT INTO carrito_compra VALUES(?,?,?,?,?)";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)) {
                ps.setInt(1, pCarrito.getId_carrito_compra());
                ps.setInt(1, pCarrito.getId_usuario());
                ps.setInt(3, pCarrito.getId_producto());
                ps.setInt(4, pCarrito.getCantidad());
                ps.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
                result = ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.err.println("Error en el: ´PreparedStatement ps = ComunDB.createPreparedStatement(con, sql´: " + e);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println("Error en el ´INSERT INTO carrito_compra VALUES(?,?,?,?,?)´: " + e);
        }
        return result;
    }

    public static int Modificar(CarritoCompras pCarrito) throws Exception {
        int result = 0;
        String sql;
        try (Connection con = ComunDB.obtenerConexion();) {
            sql = "UPDATE carrito_compra where Id_carrito_compra=?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)) {
                ps.setInt(1, pCarrito.getId_carrito_compra());
                result = ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
            }
            con.close();
        } catch (Exception e) {
            System.err.println("Error en el 'UPDATE carrito_compra where Id_carrito_compra=?´: " + e);
        }
        return result;
    }

    public static int Eliminar(CarritoCompras pCarrito) throws Exception {
        int result = 0;
        String sql;
        try (Connection con = ComunDB.obtenerConexion();) {
            sql = "DELETE FROM carrito_compra WHERE Id_carrito_compra=?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)) {
                ps.setInt(1, pCarrito.getId_carrito_compra());
                result = ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.err.print("Error en el ´PreparedStatement ps = ComunDB.createPreparedStatement´: " + e);
            }
            con.close();
        } catch (Exception e) {
            System.err.print("Error en el ´DELETE FROM carrito_compra WHERE Id_carrito_compra=?´: " + e);
        }
        return result;
    }

    static int AsignarFatosResulSet(CarritoCompras pCarrito, ResultSet pResultSet, int pIndex) throws Exception {
        pIndex++;
        pCarrito.setId_carrito_compra(pResultSet.getInt(pIndex));
        pIndex++;
        pCarrito.setId_usuario(pResultSet.getInt(pIndex));
        pIndex++;
        pCarrito.setId_producto(pResultSet.getInt(pIndex));
        pIndex++;
        pCarrito.setId_carrito_compra(pResultSet.getInt(pIndex));
        pIndex++;
        pCarrito.setCantidad(pResultSet.getInt(pIndex));
        pIndex++;
        pCarrito.setFecha_creacion(pResultSet.getDate(pIndex).toLocalDate());

        return pIndex;
    }

    private static void ObtenerDatos(PreparedStatement pPS, ArrayList<CarritoCompras> pCarrito) {
        try (ResultSet rs = ComunDB.obtenerResultSet(pPS);) {

            while (rs.next()) {
                CarritoCompras carrito = new CarritoCompras();
                AsignarFatosResulSet(carrito, rs, 0);
                pCarrito.add(carrito);
            }

        } catch (Exception e) {
            System.err.println("Error en ´ResultSet rs = ComunDB.obtenerResultSet(pPS);´: " + e);
        }
    }

    public static CarritoCompras ObtenerPorId(CarritoCompras pCarrito) throws Exception {
        CarritoCompras carrito = new CarritoCompras();
        ArrayList<CarritoCompras> Carrito = new ArrayList();
        try (Connection con = ComunDB.obtenerConexion();) {
            String sql = ObtenerSelect(pCarrito);
            sql += "WHERE r.Id_carrito_compra=?,?,?,?,?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)) {
                ps.setInt(1, pCarrito.getId_carrito_compra());
                ps.setInt(2, pCarrito.getId_usuario());
                ps.setInt(3, pCarrito.getId_producto());
                ps.setInt(4, pCarrito.getCantidad());
                // No se como se hace para las fechas ;(
                ObtenerDatos(ps, Carrito);
                ps.close();
            } catch (Exception e) {
                System.err.println("Error el el ´PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)´: " + e);

            }
            con.close();
        } catch (Exception e) {
            System.err.println("Error en el ´WHERE r.Id_carrito_compra=?,?,?,?,?´: " + e);
        }
        return carrito;
    }

    public static CarritoCompras obtenerPorId(CarritoCompras pCarrito) throws Exception {
        CarritoCompras Carrito = new CarritoCompras();
        ArrayList<CarritoCompras> Carritos = new ArrayList();
        try (Connection con = ComunDB.obtenerConexion();) {
            String sql = ObtenerSelect(pCarrito);
            sql += "WHERE r.Id_carrito_compra=?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql);) {
                ps.setInt(1, pCarrito.getId_carrito_compra());
                ObtenerDatos(ps, Carritos);
                ps.close();
            } catch (Exception e) {
                System.err.println("Error en el ´PreparedStatement ps = ComunDB.createPreparedStatement(con, sql);´: " + e);
            }
            con.close();
            if (Carritos.size() > 0) {
                Carrito = Carritos.get(0);
            }
        } catch (Exception e) {
            System.err.println("Error en el ´WHERE r.Id_carrito_compra=?´: " + e);
        }
        return Carrito;
    }

    public static ArrayList<CarritoCompras> ObtenerTodos() throws Exception {
        ArrayList<CarritoCompras> Carrito;
        Carrito = new ArrayList<>();
        try (Connection con = ComunDB.obtenerConexion();) {
            String sql = ObtenerSelect(new CarritoCompras());
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)) {
                ObtenerDatos(ps, Carrito);
                ps.close();
            } catch (Exception e) {
                System.err.println("Error en el ´PreparedStatement ps = ComunDB.createPreparedStatement(con, sql´: " + e);
            }
            con.close();
        } catch (Exception e) {
            System.err.println("Error en el ´String sql = ObtenerSelect(new CarritoCompras());´. " + e);
        }
        return Carrito;
    }

    static void QuerySelect(CarritoCompras pCarrito, ComunDB.UtilQuery pUtilQuery) throws SQLException {
        PreparedStatement ps = pUtilQuery.getStatement();
        if (pCarrito.getId_carrito_compra() > 0) {
            pUtilQuery.AgregarWhereAnd("r.Id_carrito_compras");
            if (ps != null) {
                ps.setInt(pUtilQuery.getNumWhere(), pCarrito.getId_carrito_compra());
            }
        }

        if (pCarrito.getId_usuario() > 0) {
            pUtilQuery.AgregarWhereAnd("r.Id_usuario");
            if (ps != null) {
                ps.setInt(pUtilQuery.getNumWhere(), pCarrito.getId_usuario());
            }
        }
    }

    public static ArrayList<CarritoCompras> Buscar(CarritoCompras pCarrito) throws Exception {
        ArrayList<CarritoCompras> Carrito = new ArrayList<>();
        try (Connection con = ComunDB.obtenerConexion();) {
            String sql = ObtenerSelect(pCarrito);
            ComunDB comun = new ComunDB();
            ComunDB.UtilQuery utilQuery = comun.new UtilQuery(sql, null, 0);
            QuerySelect(pCarrito, utilQuery);
            sql = utilQuery.getSQL();
            sql += AgregarOrderBy(pCarrito);
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql);) {
                utilQuery.setStatement(ps);
                utilQuery.setSQL(null);
                utilQuery.setNumWhere(0);
                QuerySelect(pCarrito, utilQuery);
                ObtenerDatos(ps, Carrito);
                ps.close();
            } catch (Exception e) {
                System.err.println("Error en el ´PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)´: " + e);
            }
            con.close();
        } catch (Exception e) {
            System.err.println("Error en el ´Connection con = ComunDB.obtenerConexion();´: " + e);
        }
        return Carrito;
    }
}