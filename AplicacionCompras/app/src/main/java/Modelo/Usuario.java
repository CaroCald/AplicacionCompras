package Modelo;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String user, password, tipo, correo;

    public Usuario(String user, String password, String tipo){
        this.user=user;
        this.password=password;
        this.tipo=tipo;
    }
    public Usuario(String nombre, String correo){
        this.user=nombre;
        this.correo=correo;
    }

    public String getPassword() {
        return password;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUser() {
        return user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
