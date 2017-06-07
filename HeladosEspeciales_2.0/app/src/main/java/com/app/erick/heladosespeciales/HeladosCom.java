package com.app.erick.heladosespeciales;

/**
 * Created by Abraham on 04/06/2017.
 */

public class HeladosCom {
    private String nombre_h,ingredientes, receta,comentario;
    long id;


    public HeladosCom(String nombre_h, String ingredientes, String receta) {
        this.nombre_h = nombre_h;
        this.ingredientes = ingredientes;
        this.receta = receta;

    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre_h() {
        return nombre_h;
    }

    public void setNombre_h(String nombre_h) {
        this.nombre_h = nombre_h;
    }


}
