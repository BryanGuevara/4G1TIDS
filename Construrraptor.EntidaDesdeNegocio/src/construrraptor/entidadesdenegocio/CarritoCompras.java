package construrraptor.entidadesdenegocio;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.print.attribute.standard.DateTimeAtCompleted;

public class CarritoCompras {

    private int id_carrito_compra;
    private int id_usuario;
    private int id_producto;
    private int cantidad;
    private LocalDate fecha_creacion;
    private int top_aux;
    private ArrayList<CarritoCompras> CarritoCompras;

    public CarritoCompras() {
    }

    public CarritoCompras(int id_carrito_compra, int id_usuario, int id_producto, int cantidad, LocalDate fecha_creacion) {
        this.id_carrito_compra = id_carrito_compra;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.fecha_creacion = fecha_creacion;
    }

    public int getId_carrito_compra() {
        return id_carrito_compra;
    }

    public void setId_carrito_compra(int id_carrito_compra) {
        this.id_carrito_compra = id_carrito_compra;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getTop_aux() {
        return top_aux;
    }

    public void setTop_aux(int top_aux) {
        this.top_aux = top_aux;
    }

    public ArrayList<CarritoCompras> getCarritoCompras() {
        return CarritoCompras;
    }

    public void setCarritoCompras(ArrayList<CarritoCompras> CarritoCompras) {
        this.CarritoCompras = CarritoCompras;
    }

}
