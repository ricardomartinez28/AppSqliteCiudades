package com.example.appsqliteciudades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appsqliteciudades.db.CiudadesDatasource;
import com.example.appsqliteciudades.model.Ciudad;

public class InsertarActivity extends AppCompatActivity {
    EditText etNombre;
    EditText etProvincia;
    EditText etNumHab;
    CiudadesDatasource cds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        etNombre=findViewById(R.id.etNombre);
        etProvincia=findViewById(R.id.etProvincia);
        etNumHab=findViewById(R.id.etNumHab);

        cds= new CiudadesDatasource(this);


    }

    public void validar(View v){

        String nombre=etNombre.getText().toString().trim();
        String provincia=etProvincia.getText().toString().trim();
        String numHab= etNumHab.getText().toString().trim();

        if(nombre.isEmpty() || provincia.isEmpty() || numHab.isEmpty()){

            Toast.makeText(this, "Debes introducir todos los datos",Toast.LENGTH_LONG).show();
        }else{


            Ciudad ciudad= new Ciudad(nombre,provincia,Integer.parseInt(numHab));

            long id= cds.insertarCiudad(ciudad);

            if(id!=-1){

                Toast.makeText(this, "La insercion se ha realizado correctamente",Toast.LENGTH_LONG).show();
                ciudad.setId((int) id);

                etNombre.setText("");
                etProvincia.setText("");

            }else{
                Toast.makeText(this, "La insercion no se ha podido realizar",Toast.LENGTH_LONG).show();
            }
        }

    }

    public void cancelarInsercion(View v){

        finish();
    }
}
