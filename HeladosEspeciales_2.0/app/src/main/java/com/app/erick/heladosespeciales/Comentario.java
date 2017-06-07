package com.app.erick.heladosespeciales;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Comentario extends AppCompatActivity {
    HeladoComenSql data;
    private ArrayList<Comentarios> con;
    private EditText comentar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario);
        comentar = (EditText)findViewById(R.id.Comentar);



            data = new HeladoComenSql(this);
            data.abir();

            con = data.GetComentarios();




        ArrayList<String> nombres = new ArrayList<String>();


        for(Comentarios comentarios :con) {

            nombres.add(comentarios.getComentario().toString());
        }

        ListView listViewContactos = (ListView) findViewById(R.id.ComtariosL);
        listViewContactos.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,nombres));






    }
    public void Volver(View view){
        Intent eve;
        eve = new Intent(this,tipos_helados.class);
        startActivity(eve);
    }
    public void Comentar(View v){



        String com = comentar.getText().toString();
        Intent evento = new Intent(this,Comentario.class);
        String nom = "Parfats";

        try {
            //Esta clase BaseDatos Puerto VersionSQL
            SqlLiteHelper sql = new SqlLiteHelper ( this, "helados_especiales", null, 1 );
            SQLiteDatabase db = sql.getWritableDatabase (); // nos permite escribir dentro de la base de datos

            db.execSQL ( "INSERT INTO comentario (" +
                    "nombre_helado,comentario) VALUES ('" + nom + "' , '" + com + "');" );
            db.close ();
            Toast.makeText ( this, "Se ingreso correctamente el contacto", Toast.LENGTH_SHORT ).show ();

            startActivity ( evento );
        }catch (Exception e){
            Toast.makeText ( this,e.getMessage ().toString (),Toast.LENGTH_SHORT ).show ();
        }


    }
}
