package com.example.appsqliteciudades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appsqliteciudades.db.CiudadesDatasource;
import com.example.appsqliteciudades.model.Ciudad;

public class TarjetaCiudadActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etProvincia;
    EditText etNumHab;

    Ciudad ciudad;
    CiudadesDatasource cds;
    Button btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeta_ciudad);


        etNombre=findViewById(R.id.etNomCiu);
        etProvincia=findViewById(R.id.etNomProv);
        etNumHab=findViewById(R.id.etNumHab);
        btnBorrar=findViewById(R.id.btnEliminar);

        cds= new CiudadesDatasource(this);
        int id= getIntent().getIntExtra("IDCIUDAD", 0);

        System.out.println(id);
        ciudad= cds.consultarCiudad(id);

        etNombre.setText(ciudad.getNombre());
        etProvincia.setText(ciudad.getProvincia());
        etNumHab.setText(String.valueOf(ciudad.getNumHab()));


    }


    public void guardarCambios(View v){

    String numHab= etNumHab.getText().toString().trim();

    if(numHab.isEmpty()){
        Toast.makeText(this,"Debes introducir un número",Toast.LENGTH_LONG).show();
    }else{

        ciudad.setNumHab(Integer.parseInt(numHab));

        cds.editarCiudad(ciudad);

        Toast.makeText(this,"Se ha modificado correctamente",Toast.LENGTH_LONG).show();


    }

    finish();

    }

    public void eliminarCiudad(View v){


        cds.borrarCiudad(ciudad.getId());

        Toast.makeText(this, "Se han Borrado correctamente",Toast.LENGTH_LONG).show();

        etNombre.setText("");
        etProvincia.setText("");
        etNumHab.setText("");

        btnBorrar.setEnabled(false);

        finish();

    }

    public void cancelar(View v){

        finish();
    }
}
