package construrraptor.accesoadatos;

import java.util.*;
import java.sql.*;
import construrraptor.entidadesdenegocio.DetalleDeCarritoDeCompras;

public class DetalleDeCarritoDeComprasDAL {

    static String ObtenerCampos() {
        return "r.Id_detalle_carrito";
    }

    private static String ObtenerSelect(DetalleDeCarritoDeCompras pDetalle) {
        String sql;
        sql = "SELECT ";
        if (pDetalle.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.SQLSERVER) {
            sql += "Top " + pDetalle.getTop_aux();
        }
        sql += (ObtenerCampos() + "FROM detalle_carrito");
        return sql;
    }

    private static String AgregarOrderBy(DetalleDeCarritoDeCompras pDetalle) {
        String sql = " ORDER BY Id_detalle_carrito DESC";
        if (pDetalle.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.MYSQL) {
            sql += " LIMIT " + pDetalle.getTop_aux() + " ";
        }
        return sql;
    }

    public static int crear(DetalleDeCarritoDeCompras pDetalle) throws Exception {
        int result = 0;
        String sql;
        try (Connection con = ComunDB.obtenerConexion();) {
            sql = "INSERT INTO detalle_carrito VALUES(?,?,?,?,?,?)";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)) {
                ps.setInt(1, pDetalle.getId_detalle_compra());
                ps.setInt(2, pDetalle.getId_producto());
                ps.setInt(3, pDetalle.getCantidad());
                ps.setFloat(4, pDetalle.getPrecio_unitario());
                ps.setFloat(5, pDetalle.getSubtotal());
                ps.setInt(6, pDetalle.getId_compra());
                ps.close();
            } catch (Exception e) {
                System.err.println("Error en el: ´PreparedStatement ps = ComunDB.createPreparedStatement(con, sql´: " + e);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println("Error en el ´INSERT INTO detalle_carrito VALUES(?,?,?,?,?,?))´: " + e);
        }
        return result;
    }

    public static int Modificar(DetalleDeCarritoDeCompras pDetalle) throws Exception {
        int result = 0;
        String sql;
        try (Connection con = ComunDB.obtenerConexion();) {
            sql = "UPDATE carrito_compra where Id_detalle_compra=?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)) {
                ps.setInt(1, pDetalle.getId_detalle_compra());
                result = ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
            }
            con.close();
        } catch (Exception e) {
            System.err.println("Error en el 'UPDATE detalle_carrito where Id_detalle_compra=?´: " + e);
        }
        return result;
    }

    public static int Eliminar(DetalleDeCarritoDeCompras pDetalle) throws Exception {
        int result = 0;
        String sql;
        try (Connection con = ComunDB.obtenerConexion();) {
            sql = "DELETE FROM carrito_compra WHERE Id_detalle_compra=?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)) {
                ps.setInt(1, pDetalle.getId_detalle_compra());
                result = ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.err.print("Error en el ´PreparedStatement ps = ComunDB.createPreparedStatement´: " + e);
            }
            con.close();
        } catch (Exception e) {
            System.err.print("Error en el ´DELETE FROM detalle_carrito WHERE Id_detalle_compra=?´: " + e);
        }
        return result;
    }

    static int AsignarFatosResulSet(DetalleDeCarritoDeCompras pDetalle, ResultSet pResultSet, int pIndex) throws Exception {
        pIndex++;
        pDetalle.setId_detalle_compra(pResultSet.getInt(pIndex));
        pIndex++;
        pDetalle.setId_producto(pResultSet.getInt(pIndex));
        pIndex++;
        pDetalle.setCantidad(pResultSet.getInt(pIndex));
        pIndex++;
        pDetalle.setPrecio_unitario(pResultSet.getFloat(pIndex));
        pIndex++;
        pDetalle.setSubtotal(pResultSet.getFloat(pIndex));
        pIndex++;
        pDetalle.setId_compra(pResultSet.getInt(pIndex));

        return pIndex;
    }

    private static void ObtenerDatos(PreparedStatement pPS, ArrayList<DetalleDeCarritoDeCompras> pDetalle) {
        try (ResultSet rs = ComunDB.obtenerResultSet(pPS);) {

            while (rs.next()) {
                DetalleDeCarritoDeCompras detalle = new DetalleDeCarritoDeCompras();
                AsignarFatosResulSet(detalle, rs, 0);
                pDetalle.add(detalle);
            }

        } catch (Exception e) {
            System.err.println("Error en ´ResultSet rs = ComunDB.obtenerResultSet(pPS);´: " + e);
        }
    }

    public static DetalleDeCarritoDeCompras ObtenerPorId(DetalleDeCarritoDeCompras pDetalle) throws Exception {
        DetalleDeCarritoDeCompras carrito = new DetalleDeCarritoDeCompras();
        ArrayList<DetalleDeCarritoDeCompras> Carrito = new ArrayList();
        try (Connection con = ComunDB.obtenerConexion();) {
            String sql = ObtenerSelect(pDetalle);
            sql += "WHERE r.Id_detalle_compra=?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)) {
                ps.setInt(1, pDetalle.getId_detalle_compra());
                ps.setInt(2, pDetalle.getId_producto());
                ps.setInt(3, pDetalle.getCantidad());
                ps.setFloat(4, pDetalle.getPrecio_unitario());
                ps.setFloat(5, pDetalle.getSubtotal());
                ps.setInt(6, pDetalle.getId_compra());
                ps.close();
            } catch (Exception e) {
                System.err.println("Error el el ´PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)´: " + e);

            }
            con.close();
        } catch (Exception e) {
            System.err.println("Error en el ´WHERE r.Id_detalle_compra=?´: " + e);
        }
        return carrito;
    }

    public static ArrayList<DetalleDeCarritoDeCompras> ObtenerTodos() throws Exception {
        ArrayList<DetalleDeCarritoDeCompras> detalle;
        detalle = new ArrayList<>();
        try (Connection con = ComunDB.obtenerConexion();) {
            String sql = ObtenerSelect(new DetalleDeCarritoDeCompras());
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)) {
                ObtenerDatos(ps, detalle);
                ps.close();
            } catch (Exception e) {
                System.err.println("Error en el ´PreparedStatement ps = ComunDB.createPreparedStatement(con, sql´: " + e);
            }
            con.close();
        } catch (Exception e) {
            System.err.println("Error en el ´String sql = ObtenerSelect(new CarritoCompras());´. " + e);
        }
        return detalle;
    }

    static void QuerySelect(DetalleDeCarritoDeCompras pDetalle, ComunDB.UtilQuery pUtilQuery) throws SQLException {
        PreparedStatement ps = pUtilQuery.getStatement();
        if (pDetalle.getId_detalle_compra() > 0) {
            pUtilQuery.AgregarWhereAnd("r.Id_detalle_compra");
            if (ps != null) {
                ps.setInt(pUtilQuery.getNumWhere(), pDetalle.getId_detalle_compra());
            }
        }
    }

    public static ArrayList<DetalleDeCarritoDeCompras> Buscar(DetalleDeCarritoDeCompras pCarrito) throws Exception {
        ArrayList<DetalleDeCarritoDeCompras> Carrito = new ArrayList<>();
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
