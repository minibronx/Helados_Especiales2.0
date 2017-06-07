package com.app.erick.heladosespeciales;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    private EditText correo,user,pass;
    HeladoComenSql data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        correo = (EditText)findViewById(R.id.id_correo1);
        pass = (EditText)findViewById(R.id.id_password1);
        user = (EditText)findViewById(R.id.id_usuario1);

            data = new HeladoComenSql(this);
            data.abir();



    }
    public void Registrar(View v){
        String nom_user = user.getText().toString();
        String email = correo.getText().toString();
        String pass1 = pass.getText().toString();

        Intent evento = new Intent(this,sesion.class);

        try {
            //Esta clase BaseDatos Puerto VersionSQL
            SqlLiteHelper sql = new SqlLiteHelper(this, "helados_especiales", null, 1);

            SQLiteDatabase db = sql.getWritableDatabase(); // nos permite escribir dentro de la base de datos

            String query = "INSERT INTO usuario_postre ("
                    + "usuario,email,pass) VALUES('" + nom_user + "','" + email + "','"
                    + pass1 + "');";

            db.execSQL(query);
            db.close();
            Toast.makeText(getBaseContext(), "Bienvenido a Helados Especiales", Toast.LENGTH_LONG).show();

            startActivity(evento);

        } catch (Exception e) {

            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }
    public void Salir(View v){

        Intent evento = new Intent(this, postres_base_helado.class);
        startActivity(evento);

    }
}