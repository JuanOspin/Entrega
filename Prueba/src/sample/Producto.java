package sample;

import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;

public class Producto {
    private SimpleStringProperty CodigoProducto, Objeto, Precio, Cantidad;
    private LocalDate UltIngreso;

    public Producto(String codigoProducto, String objeto, String precio, String cantidad, LocalDate ultIngreso) {
        this.CodigoProducto = new SimpleStringProperty(codigoProducto);
        this.Objeto = new SimpleStringProperty(objeto);
        this.Precio = new SimpleStringProperty(precio);
        this.Cantidad = new SimpleStringProperty(cantidad);
        this.UltIngreso = ultIngreso;
    }

    public String getCodigoProducto() {
        return CodigoProducto.get();
    }


    public void setCodigoProducto(String codigoProducto) {
        this.CodigoProducto.set(codigoProducto);
    }

    public String getObjeto() {
        return Objeto.get();
    }
    public void setObjeto(String objeto) {
        this.Objeto.set(objeto);
    }

    public String getPrecio() {
        return Precio.get();
    }

    public void setPrecio(String precio) {
        this.Precio.set(precio);
    }

    public String getCantidad() {
        return Cantidad.get();
    }

    public void setCantidad(String cantidad) {
        this.Cantidad.set(cantidad);
    }

    public LocalDate getUltIngreso() {
        return UltIngreso;
    }

    public void setUltIngreso(LocalDate ultIngreso) {
        UltIngreso = ultIngreso;
    }
}
