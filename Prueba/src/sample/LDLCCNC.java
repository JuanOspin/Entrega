package sample;

import java.time.LocalDate;

public class LDLCCNC {
    NodoDoble nodoCabeza;
    int tamano;

    private NodoDoble nodoAux;

    public LDLCCNC() {
        nodoCabeza = new NodoDoble();
        tamano = 0;
    }

    public int RetornaTama() {
        return tamano;
    }

    public boolean EsVacio() {
        if (tamano == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void AnadirNodoT(boolean gerente, String usuario, int contrasena) {
        nodoAux = new NodoDoble(gerente, usuario, contrasena);
        if (tamano == 0) {
            nodoAux.setLigaIzquierda(nodoCabeza);
            nodoAux.setLigaDerecha(nodoCabeza);
            nodoCabeza.setLigaDerecha(nodoAux);
            nodoCabeza.setLigaIzquierda(nodoAux);
        } else {
            nodoAux.setLigaDerecha(nodoCabeza);
            nodoAux.setLigaIzquierda(nodoCabeza.getLigaIzquierda());
            nodoCabeza.setLigaIzquierda(nodoAux);
        }
    }

    public void AnadirNodoP(String nombre, int id, int cantidad, int precio, LocalDate fechaIngreso) {
        nodoAux = new NodoDoble(nombre, id, cantidad, precio, fechaIngreso);
        if (tamano == 0) {
            nodoAux.setLigaIzquierda(nodoCabeza);
            nodoAux.setLigaDerecha(nodoCabeza);
            nodoCabeza.setLigaDerecha(nodoAux);
            nodoCabeza.setLigaIzquierda(nodoAux);
        } else {
            nodoAux.setLigaDerecha(nodoCabeza);
            nodoAux.setLigaIzquierda(nodoCabeza.getLigaIzquierda());
            nodoCabeza.setLigaIzquierda(nodoAux);
        }
    }

    public void BorrarNodoT(String usuario) {
        nodoAux = BuscarNodoT(usuario);
        if (tamano == 1) {
            nodoCabeza.setLigaDerecha(null);
            nodoCabeza.setLigaIzquierda(null);
        } else {
            nodoAux.getLigaIzquierda().setLigaDerecha(nodoAux.getLigaDerecha());
            nodoAux.getLigaDerecha().setLigaIzquierda(nodoAux.getLigaIzquierda());
        }
    }

    public void BorrarNodoP(int id) {
        nodoAux = BuscarNodoP(id);
        if (tamano == 1) {
            nodoCabeza.setLigaDerecha(null);
            nodoCabeza.setLigaIzquierda(null);
        } else {
            nodoAux.getLigaIzquierda().setLigaDerecha(nodoAux.getLigaDerecha());
            nodoAux.getLigaDerecha().setLigaIzquierda(nodoAux.getLigaIzquierda());
        }
    }

    public NodoDoble BuscarNodoT(String usuario) {
        nodoAux = nodoCabeza;
        for (int i = 1; i <= tamano; i++) {
            nodoAux = nodoAux.getLigaDerecha();
            if (nodoAux.getDatoT().getUsuario() == usuario) {
                return nodoAux;
            }
        }
        return null;
    }

    public NodoDoble BuscarNodoP(int id) {
        nodoAux = nodoCabeza;
        for (int i = 1; i <= tamano; i++) {
            nodoAux = nodoAux.getLigaDerecha();
            if (nodoAux.getDatoP().getId() == id) {
                return nodoAux;
            }
        }
        return null;
    }
}
