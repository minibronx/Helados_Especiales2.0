package com.app.erick.heladosespeciales;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Receta_Helado extends AppCompatActivity  {
    FloatingActionButton fab;
    TextView Nombre, Ingrediente,Preparado;
    HeladoComenSql data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta__helado);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eve = new Intent(Receta_Helado.this,Comentario.class);
                startActivity(eve);
            }
        });

        Nombre = (TextView)findViewById(R.id.NombreHelado);
        Ingrediente = (TextView)findViewById(R.id.Ingrediente);


            data = new HeladoComenSql(this);
            data.abir();

        Bundle parametros = getIntent().getExtras();
        String nom = parametros.getString("nombre");
        String ing = parametros.getString("ingrediente");





        Nombre.setText(nom);
        Ingrediente.setText(ing);


    }
    public void Salir2(View view){
        Intent eve;
        eve = new Intent(this,tipos_helados.class);
        startActivity(eve);
    }


    public void pagina(View view){

        Uri uri = null;

        String nombre = Nombre.getText().toString();

        if (nombre.equals("PARFAITS")){
             uri = Uri.parse("https://www.elmejornido.com/es/recetas/parfaits-de-fresa-la-lechera-145593");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (nombre.equals("MOUSE GLACE")){
            uri = Uri.parse("http://menuperu.elcomercio.pe/recetas/carlota-rusa-1304");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (nombre.equals("BOMBAS GLACES")){
            uri = Uri.parse("https://www.weightwatchers.com/au/recipe/raspberry-eton-mess-1/562688c9cb94e20c341762a9");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (nombre.equals("BICUIT GLACE")){
            uri = Uri.parse("http://www.recetasdemama.es/2011/09/biscuit-glacce-con-praline-de-almendras/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (nombre.equals("SOUFFLES GLACES")){
            uri = Uri.parse("https://www.odelices.com/recette/souffles-glaces-aux-framboises-r18/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }


    }


}
