package sample;

public class Trabajador {
    boolean gerente;
    String usuario;
    int contrasena;

    public Trabajador(boolean gerente, String usuario, int contrasena) {
        this.gerente = gerente;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    ///////////////////////////////GETTERS///////////////////////////////

    public boolean isGerente() {
        return gerente;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getContrasena() {
        return contrasena;
    }

    ///////////////////////////////SETTERS///////////////////////////////

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }
}
