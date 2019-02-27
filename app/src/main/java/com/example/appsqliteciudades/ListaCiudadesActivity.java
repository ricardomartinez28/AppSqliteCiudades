package com.example.appsqliteciudades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.appsqliteciudades.db.CiudadesDatasource;
import com.example.appsqliteciudades.model.Ciudad;

import java.util.ArrayList;

public class ListaCiudadesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private Adaptador adapter;
    private ArrayList<Ciudad> lista;
    private CiudadesDatasource cds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ciudades);
        cds= new CiudadesDatasource(this);

        lista= cds.CargarCiudades();
        recyclerView=findViewById(R.id.rvLista);

        recyclerView.setHasFixedSize(true);

        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        adapter= new Adaptador(lista);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaCiudadesActivity.this , TarjetaCiudadActivity.class );
                i.putExtra(String.valueOf(recyclerView.indexOfChild(v)), "IDCIUDAD");
                startActivity(i);

            }
        });
        recyclerView.setAdapter(adapter);
    }
}
