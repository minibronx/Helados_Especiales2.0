package com.app.erick.heladosespeciales;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class tipos_helados extends AppCompatActivity {


    HeladoComenSql data;
    ArrayList<HeladosCom> helados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_helados);


        data = new HeladoComenSql(this);
        data.abir();

        helados = data.ConsultaHelado();

        ArrayList<String> nombres = new ArrayList<String>();


        for(HeladosCom res: helados ) {
            nombres.add(res.getNombre_h().toString());

        }

        ListView listViewContactos = (ListView) findViewById(R.id.PostresLista);
        listViewContactos.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,nombres));

        listViewContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(tipos_helados.this, Receta_Helado.class);
                intent.putExtra("nombre",helados.get(position).getNombre_h());
                intent.putExtra("ingrediente",helados.get(position).getIngredientes());


                startActivity(intent);
            }
        });

    }
    public void CerrarSesion(View v){
        Intent evento;
        evento = new Intent(this,postres_base_helado.class);
        startActivity(evento);
    }



}
