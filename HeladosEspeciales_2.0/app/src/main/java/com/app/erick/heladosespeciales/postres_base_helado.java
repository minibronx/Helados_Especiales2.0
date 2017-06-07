package com.app.erick.heladosespeciales;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class postres_base_helado extends AppCompatActivity {
     HeladoComenSql data;
    private boolean activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postres_base_helado);
        activity = true;
            try {
                data = new HeladoComenSql(this);
                data.abir();
            }catch (Exception e){
                data.abir();
            }



    }


    public void TiposHelados(View v) {
        Intent intent = new Intent(this, sesion.class);
        startActivity(intent);
    }
    public void FaceBook(View view){

        Uri  uri = Uri.parse("https://www.facebook.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
    public void Twitter(View view){

        Uri  uri = Uri.parse("https://www.twitter.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

}
