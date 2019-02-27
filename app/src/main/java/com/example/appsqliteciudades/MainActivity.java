package com.example.appsqliteciudades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void insertarCiudad(View v){
        Intent i= new Intent(this, InsertarActivity.class);
        startActivity(i);

    }

    public void visualizarCiudad(View v){

        Intent i= new Intent(this, ListaCiudadesActivity.class);
        startActivity(i);
    }
}
