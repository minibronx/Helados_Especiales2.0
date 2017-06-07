package com.app.erick.heladosespeciales;

/**
 * Created by Abraham on 05/06/2017.
 */

public class Comentarios {

    private long id;
    private String nombre,comentario;

    public Comentarios( String nombre, String comentario) {

        this.nombre = nombre;
        this.comentario = comentario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
