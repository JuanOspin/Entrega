package sample;

import java.time.LocalDate;

public class NodoDoble {
    Trabajador datoT;
    Producto datoP;
    NodoDoble ligaIzquierda, ligaDerecha;

    public NodoDoble(boolean gerente, String usuario, int contrasena) {
        datoT = new Trabajador(gerente, usuario, contrasena);
        ligaDerecha = null;
        ligaIzquierda = null;
    }

    public NodoDoble(String nombre, int id, int cantidad, int precio, LocalDate fechaIngreso) {
        datoP = new Producto(nombre, id, cantidad, precio, fechaIngreso);
        ligaDerecha = null;
        ligaIzquierda = null;
    }

    public NodoDoble(){
        datoP = null;
        datoT = null;
        ligaDerecha = null;
        ligaIzquierda = null;
    }

    ///////////////////////////////GETTERS///////////////////////////////

    public Trabajador getDatoT() {
        return datoT;
    }

    public Producto getDatoP() {
        return datoP;
    }

    public NodoDoble getLigaIzquierda() {
        return ligaIzquierda;
    }

    public NodoDoble getLigaDerecha() {
        return ligaDerecha;
    }

    ///////////////////////////////SETTERS///////////////////////////////

    public void setDatoT(Trabajador datoT) {
        this.datoT = datoT;
    }

    public void setDatoP(Producto datoP) {
        this.datoP = datoP;
    }

    public void setLigaIzquierda(NodoDoble ligaIzquierda) {
        this.ligaIzquierda = ligaIzquierda;
    }

    public void setLigaDerecha(NodoDoble ligaDerecha) {
        this.ligaDerecha = ligaDerecha;
    }
}
