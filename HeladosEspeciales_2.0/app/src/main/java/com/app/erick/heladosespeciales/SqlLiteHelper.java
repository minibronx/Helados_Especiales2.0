package com.app.erick.heladosespeciales;

/**
 * Created by Abraham on 04/06/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.name;
import static android.R.attr.version;

/**
 * Created by  on 24/05/17.
 */

public class SqlLiteHelper extends SQLiteOpenHelper {

    //nombre de las tablas
    private static final String TABLE_NAME = "usuario_postre";
    private static final String TABLE_NAME_1 = "helado";
    private static final String TABLE_NAME_2 = "comentario";

    private static final String PRIMARY_KEY = "id_usuario";
    private static final String PRIMARY_KEY_1 = "id_helado";
    private static final String PRIMARY_KEY_2 = "id_comen";


    private static final String DATABASE_NAME = "helados_especiales";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;// elimina duplicados de base de datos

    private static final String SQL_DELETE_ENTRIES_1 =
            "DROP TABLE IF EXISTS " + TABLE_NAME_1;
    private static final String SQL_DELETE_ENTRIES_2 =
            "DROP TABLE IF EXISTS " + TABLE_NAME_2;

    private static final String DATABASE_CREATE = "create table " + TABLE_NAME + " ( " + PRIMARY_KEY + " integer primary key autoincrement," +
            "usuario text not null, email text not null, pass text not null);";
    private static final String DATABASE_CREATE_1 = "create table " + TABLE_NAME_1 + " ( " + PRIMARY_KEY_1 + " integer primary key autoincrement," +
            "nombre_helado text not null,ingredientes text not null, receta text not null);";
    private static final String DATABASE_CREATE_2 = "create table " + TABLE_NAME_2 + " ( " + PRIMARY_KEY_1 + " integer primary key autoincrement," +
            "nombre_helado text not null, comentario text not null);";

    public SqlLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SqlLiteHelper ( Context context, String s, Object o, int i ) {
        super ( context, s, (SQLiteDatabase.CursorFactory) o, i );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //ejecuta la BD
        db.execSQL(DATABASE_CREATE);
        //Inserta un valor en la tabla
        db.execSQL("INSERT INTO " + TABLE_NAME + "("
                + "usuario,email,pass) VALUES(" +
                "'MiniBronx','erick_arrieta@gmial.com','cerrada')");



        db.execSQL(DATABASE_CREATE_1);
        //Inserta un valor en la tabla
        db.execSQL("INSERT INTO "+TABLE_NAME_1+" (nombre_helado,ingredientes,receta) VALUES('"+
                "'PARFAITS'," +
                "INGREDIENTES:\n'1 1/2 tazas de yogur griego natural, sin sabor\n" +
                " y sin grasa,\n" +
                "3 cucharadas de mermelada de fresa sin semillas,\n" +
                "1/2 taza de Leche Condensada Azucarada\n" +
                " LA LECHERA de NESTLÉ o de Leche Condensada Azucarada \n" +
                "LA LECHERA de NESTLÉ (botella exprimible)," +
                "1 cucharadita de ralladura de cáscara de limón,\n" +
                "1 1/4 tazas de cereal de hojuelas de maíz triturado,\n" +
                "Fresas en rodajas','" +
                "https://www.elmejornido.com/es/recetas/parfaits-de-fresa-la-lechera-145593" +
                "')");
        db.execSQL("INSERT INTO "+TABLE_NAME_1+" (nombre_helado,ingredientes,receta) VALUES('" +
                "MOUSE GLACE','" +
                "INGREDIENTES:\n" +
                "1 bote de pasta de castañas\n" +
                "4 huevos\n" +
                "150 g de chocolate negro\n','" +
                "http://menuperu.elcomercio.pe/recetas/carlota-rusa-1304." +
                "')");
        db.execSQL("INSERT INTO "+TABLE_NAME_1+" (nombre_helado,ingredientes,receta) VALUES('" +
                "BOMBAS GLACES','" +
                "INGREDIENTES:\nAzúcar 180 grs.\nCrema de leche 180 grs.\nJugo de limón 25 cc.\nClaras 3 Unidades.\nPulpa de frambuesas sin semillas 200 g.','" +
                "https://www.weightwatchers.com/au/recipe/raspberry-eton-mess-1/562688c9cb94e20c341762a9" +
                "')");
        db.execSQL("INSERT INTO "+TABLE_NAME_1+" (nombre_helado,ingredientes,receta) VALUES('" +
                "BICUIT GLACE','" +
                "INGREDIENTES:\n" +
                "1 taza de leche\n" +
                "250 g de azucar\n" +
                "32 g de almidón\n" +
                "1 taza de agua\n" +
                "8 g de café tostado molido\n" +
                "12 yemas de huevo\n" +
                "2 claras de huevo','" +
                "http://www.recetasdemama.es/2011/09/biscuit-glacce-con-praline-de-almendras/" +
                "minutos." +
                "')");
        db.execSQL("INSERT INTO "+TABLE_NAME_1+" (nombre_helado,ingredientes,receta) VALUES('" +
                "SOUFFLES GLACES','" +
                "INGREDIENTES:\n" +
                "3 huevos.\n" +
                "150 g de queso fresco 0% MG.\n" +
                "2 cucharadas soperas de edulcorante en polvo.\n" +
                "15 gotas de aroma de ron.\n" +
                "180 g de cereales de avena con sabor caramelo.\n" +
                "12 cucharadas soperas de compota de ruibarbo casera','" +
                "https://www.odelices.com/recette/souffles-glaces-aux-framboises-r18/" +
                "')");



        db.execSQL(DATABASE_CREATE_2);
        //Inserta un valor en la tabla
        db.execSQL("insert into " + TABLE_NAME_2 + "("
                + "nombre_helado,comentario) VALUES('Parfaits','Este tipo de helados le encantan a mi familia, Buen aporte!')");


    }

    //borra los registros (actualiza los datos)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_DELETE_ENTRIES_1);
        db.execSQL(SQL_DELETE_ENTRIES_2);
        onCreate(db);
    }
}
