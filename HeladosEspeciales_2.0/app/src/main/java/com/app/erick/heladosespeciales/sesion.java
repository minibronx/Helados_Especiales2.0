package com.app.erick.heladosespeciales;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class sesion extends AppCompatActivity {
    HeladoComenSql data;
    private EditText user,pass;

    private ArrayList<HeladosCom> helados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);

        try {
            data = new HeladoComenSql(this);
            data.abir();
        }catch (Exception e){
            data.abir();
        }

        user = (EditText)findViewById(R.id.id_usuario);
        pass = (EditText)findViewById(R.id.id_password);


    }

    public void Helados(View v) {

        SqlLiteHelper admin=new SqlLiteHelper(this,"helados_especiales",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String usuario = user.getText().toString();
        String contrasena = pass.getText().toString();
        Cursor fila;
        fila=db.rawQuery("SELECT usuario,pass FROM usuario_postre WHERE usuario='" +
                usuario + "'AND pass='" + contrasena + "'", null);
        //preguntamos si el cursor tiene algun valor almacenado
        if(fila.moveToFirst()==true) {
            //capturamos los valores del cursos y lo almacenamos en variable
            String usua = fila.getString(0);
            String pass1 = fila.getString(1);
            //preguntamos si los datos ingresados son iguales
            if (usuario.equals(usua) && contrasena.equals(pass1)) {
                //si son iguales entonces vamos a otra ventana
                //Menu es una nueva actividad empty
                Intent ven = new Intent(this, tipos_helados.class);
                startActivity(ven);
                Toast.makeText(this,"Bienvenido "+usua,Toast.LENGTH_SHORT).show();
                //limpiamos las las cajas de texto
                user.setText("");
                pass.setText("");
            }
        }
    }
    public void Registro(View v){
        Intent evento;
        evento = new Intent(this,Registrar.class);
        startActivity(evento);
    }
    public void Salir(View v){
        Intent evento;
        evento = new Intent(this,postres_base_helado.class);
        startActivity(evento);
    }
}
