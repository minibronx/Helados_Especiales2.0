package com.app.erick.heladosespeciales;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Abraham on 04/06/2017.
 */

public class HeladoComenSql {
    private SQLiteDatabase database;
    private SqlLiteHelper dbHelper;

    public HeladoComenSql(Context context){
        dbHelper = new SqlLiteHelper(context);
    }

    public void abir() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }
    public void cerrar() {
        dbHelper.close();
    }

    public long crearHelado(HeladosCom helado){
        ContentValues values = new ContentValues();
        values.put("nombre_h",helado.getNombre_h());
        values.put("ingre",helado.getIngredientes());
        values.put("receta",helado.getReceta());
        long id = database.insert("helado",null,values);

        return id;


    }
    public ArrayList<HeladosCom> ConsultaHelado(){
        ArrayList<HeladosCom> helados = new ArrayList<HeladosCom>();
        Cursor cursor = database.query("helado",new String[]{"id_helado","nombre_helado","ingredientes","receta"},null,null,null,null,null);;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            HeladosCom hela = cursorToHelado(cursor);
            helados.add(hela);
            cursor.moveToNext();
        }
        cursor.close();
        return helados;
    }

    private HeladosCom cursorToHelado(Cursor cursor) {
        HeladosCom hellados = new HeladosCom(
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3));
        hellados.setId(cursor.getLong(0));

        return hellados;
    }


    public ArrayList<Comentarios> GetComentarios(){
        ArrayList<Comentarios> comentario = new ArrayList<Comentarios>();
        Cursor cursor = database.rawQuery("SELECT nombre_helado,comentario FROM comentario",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Comentarios contact = cursorToContact(cursor);
            comentario.add(contact);
            cursor.moveToNext();
        }
        cursor.close();
        return comentario;

    }
    public ArrayList<HeladosCom> ConsultaHelado(String nombre){
        ArrayList<HeladosCom> comentario = new ArrayList<HeladosCom>();
        Cursor cursor = database.rawQuery("SELECT nombre_helado,ingredientes FROM helado WHERE nombre_helado='"+nombre+"';",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            HeladosCom contact = cursorToHelado(cursor);
            comentario.add(contact);
            cursor.moveToNext();
        }
        cursor.close();
        return comentario;

    }





    private Comentarios cursorToContact (Cursor cursor){
        Comentarios contact = new Comentarios(

                cursor.getString(0),
                cursor.getString(1));


        return contact;
    }




}
