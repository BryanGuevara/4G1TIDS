package construrraptor.accesoadatos;

import java.util.*;
import java.sql.*;
import construrraptor.entidadesdenegocio.*;
import java.time.LocalDate;

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
        try ( Connection con = ComunDB.obtenerConexion();) {
            sql = "INSERT INTO detalle_carrito VALUES(?,?,?,?,?,?)";
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(con, sql)) {
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

}
