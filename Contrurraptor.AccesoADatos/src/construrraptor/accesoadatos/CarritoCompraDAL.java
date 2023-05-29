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
            sql += "WHERE r.Id_carrito_compra=?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)) {
ps.setInt();
            } catch (Exception e) {
                System.err.println("Error el el ´PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)´: " + e);
                
            }
        } catch (Exception e) {
            System.err.println("Error en el ´WHERE r.Id_carrito_compra=?´: " + e);
        }
        
    }
}

//    // Metodo para obtener por Id un registro de la tabla de Rol 
//    public static CarritoCompras obtenerPorId(CarritoCompras pCarrito) throws Exception {
//        CarritoCompras Carrito = new CarritoCompras();
//        ArrayList<CarritoCompras> roles = new ArrayList();
//        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
//            String sql = obtenerSelect(pCarrito); // Obtener la consulta SELECT de la tabla Rol
//            sql += " WHERE r.Id=?"; // Concatenar a la consulta SELECT de la tabla Rol el WHERE 
//            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
//                ps.setInt(1, pCarrito.getId_carrito_compra()); // Agregar el parametro a la consulta donde estan el simbolo ? #1 
//                obtenerDatos(ps, roles); // Llenar el ArrayList de Rol con las fila que devolvera la consulta SELECT a la tabla de Rol
//                ps.close(); // Cerrar el PreparedStatement
//            } catch (SQLException ex) {
//                throw ex;  // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
//            }
//            conn.close();  // Cerrar la conexion a la base de datos
//        } catch (SQLException ex) {
//            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
//        }
//        if (roles.size() > 0) { // Verificar si el ArrayList de Rol trae mas de un registro en tal caso solo debe de traer uno
//            Carrito = roles.get(0); // Si el ArrayList de Rol trae un registro o mas obtenemos solo el primero 
//        }
//        return Carrito; // Devolver el rol encontrado por Id 
//    }
//
//    // Metodo para obtener todos los registro de la tabla de Rol
//    public static ArrayList<CarritoCompras> obtenerTodos() throws Exception {
//        ArrayList<CarritoCompras> Carrito;
//        Carrito = new ArrayList<>();
//        try (Connection conn = ComunDB.obtenerConexion();) {// Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
//            String sql = obtenerSelect(new CarritoCompras());  // Obtener la consulta SELECT de la tabla Rol
//            sql += agregarOrderBy(new CarritoCompras());  // Concatenar a la consulta SELECT de la tabla Rol el ORDER BY por Id 
//            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
//                obtenerDatos(ps, Carrito); // Llenar el ArrayList de Rol con las fila que devolvera la consulta SELECT a la tabla de Rol
//                ps.close(); // Cerrar el PreparedStatement
//            } catch (SQLException ex) {
//                throw ex; // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
//            }
//            conn.close(); // Cerrar la conexion a la base de datos
//        } catch (SQLException ex) {
//            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
//        }
//        return Carrito; // Devolver el ArrayList de Rol
//    }
//
//    // Metodo para asignar los filtros de la consulta SELECT de la tabla de Rol de forma dinamica
//    static void querySelect(CarritoCompras pCarrito, ComunDB.UtilQuery pUtilQuery) throws SQLException {
//        PreparedStatement statement = pUtilQuery.getStatement(); // Obtener el PreparedStatement al cual aplicar los parametros
//        if (pCarrito.getId_carrito_compra() > 0) { // Verificar si se va incluir el campo Id en el filtro de la consulta SELECT de la tabla de Rol
//            pUtilQuery.AgregarWhereAnd(" r.Id=? "); // Agregar el campo Id al filtro de la consulta SELECT y agregar en el WHERE o AND
//            if (statement != null) {
//                // Agregar el parametro del campo Id a la consulta SELECT de la tabla de Rol
//                statement.setInt(pUtilQuery.getNumWhere(), pCarrito.getId_carrito_compra());
//            }
//        }
//        // Verificar si se va incluir el campo Nombre en el filtro de la consulta SELECT de la tabla de Rol
//        if (pCarrito.getId_usuario() != 0) {
//            pUtilQuery.AgregarWhereAnd(" r.Nombre LIKE ? "); // Agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
//            if (statement != null) {
//                // Agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Rol
//                statement.setString(pUtilQuery.getNumWhere(), "%" + pCarrito.getId_usuario() + "%");
//            }
//        }
//    }
//
//    // Metodo para obtener todos los registro de la tabla de Rol que cumplan con los filtros agregados 
//    // a la consulta SELECT de la tabla de Rol 
//    public static ArrayList<CarritoCompras> buscar(CarritoCompras pCarrito) throws Exception {
//        ArrayList<CarritoCompras> roles = new ArrayList();
//        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
//            String sql = obtenerSelect(pCarrito); // Obtener la consulta SELECT de la tabla Rol
//            ComunDB comundb = new ComunDB();
//            ComunDB.UtilQuery utilQuery = comundb.new UtilQuery(sql, null, 0);
//            querySelect(pCarrito, utilQuery); // Asignar el filtro a la consulta SELECT de la tabla de Rol 
//            sql = utilQuery.getSQL();
//            sql += agregarOrderBy(pCarrito); // Concatenar a la consulta SELECT de la tabla Rol el ORDER BY por Id
//            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
//                utilQuery.setStatement(ps);
//                utilQuery.setSQL(null);
//                utilQuery.setNumWhere(0);
//                querySelect(pCarrito, utilQuery);  // Asignar los parametros al PreparedStatement de la consulta SELECT de la tabla de Rol
//                obtenerDatos(ps, roles); // Llenar el ArrayList de Rol con las fila que devolvera la consulta SELECT a la tabla de Rol
//                ps.close(); // Cerrar el PreparedStatement
//            } catch (SQLException ex) {
//                throw ex;  // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
//            }
//            conn.close(); // Cerrar la conexion a la base de datos
//        } catch (SQLException ex) {
//            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
//        }
//        return roles; // Devolver el ArrayList de Rol
//    }
//}