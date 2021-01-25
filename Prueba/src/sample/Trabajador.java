package sample;

public class Trabajador {
    boolean gerente;
    String usuario;
    String contrasena;

    public Trabajador(boolean gerente, String usuario, String contrasena) {
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

    public String getContrasena() {
        return contrasena;
    }

    ///////////////////////////////SETTERS///////////////////////////////

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
