package Modelo;

import java.io.Serializable;

public class Zapatos implements Serializable {
    private String descripcion, precio;

            public Zapatos(String descripcion, String precio){
            this.descripcion=descripcion;
            this.precio=precio;
            }

    public Zapatos(String descripcion){
        this.descripcion=descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return " "+ getDescripcion()+" "+getPrecio();
    }

    public String toStringDos(){
        return " "+ getDescripcion();
    }
}
