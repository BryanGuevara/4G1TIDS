//Hecho por Bryan Guevara 👍🏻
package construrraptor.entidadesdenegocio;

public class DetalleDeCarritoDeCompras {

    private int id_detalle_compra;
    private int id_producto;
    private int cantidad;
    private float precio_unitario;
    private float subtotal;
    private int id_compra;
    private int top_aux;

    public DetalleDeCarritoDeCompras() {
    }

    public DetalleDeCarritoDeCompras(int id_detalle_compra, int id_producto, int cantidad, float precio_unitario, float subtotal, int id_compra) {
        this.id_detalle_compra = id_detalle_compra;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
        this.id_compra = id_compra;
    }

    public int getId_detalle_compra() {
        return id_detalle_compra;
    }

    public void setId_detalle_compra(int id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

}
