package sample;

import java.time.LocalDate;

public class Producto {
    int id, cantidad, precio;
    LocalDate fechaIngreso;
    String nombre;

    public Producto(String nombre, int id, int cantidad, int precio, LocalDate fechaIngreso){
        this.nombre = nombre;
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaIngreso = fechaIngreso;
    }

    public void AnadirProductos(int cantidad) {

    }

    public void QuitarProductos(int cantidad) {

    }

    ///////////////////////////////GETTERS///////////////////////////////

    public int getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    ///////////////////////////////SETTERS///////////////////////////////

    public void setId(int id) {
        this.id = id;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
