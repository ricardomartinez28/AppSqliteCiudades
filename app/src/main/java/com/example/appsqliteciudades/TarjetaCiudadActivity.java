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
    Intent i;
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
        String id= i.getStringExtra("IDCIUDAD");

        ciudad= cds.consultarCiudad(Integer.parseInt(id));

    }


    public void guardarCambios(View v){

    String numHab= etNumHab.getText().toString().trim();

    if(numHab.isEmpty()){
        Toast.makeText(this,"Debes introducir un número",Toast.LENGTH_LONG).show();
    }else{

        ciudad.setNumHab(Integer.parseInt(numHab));

        cds.editarCiudad(ciudad);
    }


    }

    public void eliminarCiudad(View v){


        cds.borrarCiudad(ciudad.getId());

        Toast.makeText(this, "Se han Borrado correctamente",Toast.LENGTH_LONG).show();

        etNombre.setText("");
        etProvincia.setText("");
        etNumHab.setText("");

        btnBorrar.setEnabled(false);

    }

    public void cancelar(View v){

        finish();
    }
}
