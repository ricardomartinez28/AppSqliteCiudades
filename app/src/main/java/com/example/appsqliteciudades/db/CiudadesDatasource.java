package com.example.appsqliteciudades.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appsqliteciudades.model.Ciudad;

import java.util.ArrayList;

public class CiudadesDatasource {

    private CiudadesSQLiteHelper csh;

    public CiudadesDatasource(Context contexto) {

        csh= new CiudadesSQLiteHelper(contexto);

    }

    public SQLiteDatabase openReadable(){
        return csh.getReadableDatabase();
    }

    public SQLiteDatabase openWriteable(){
        return csh.getWritableDatabase();
    }

    public void close(SQLiteDatabase database){
        database.close();
    }

    public long insertarCiudad(Ciudad ciudad){

        SQLiteDatabase sdb=openWriteable();
        sdb.beginTransaction();

        ContentValues cv= new ContentValues();

        cv.put(CiudadesContract.CiudadesEntry.COLUMN_NAME, ciudad.getNombre());
        cv.put(CiudadesContract.CiudadesEntry.COLUMN_PROVINCE, ciudad.getProvincia());
        cv.put(CiudadesContract.CiudadesEntry.COLUMN_NUMHAB, ciudad.getNumHab());

        long id= sdb.insert(CiudadesContract.CiudadesEntry.TABLE_NAME, null,cv);

        if (id!=-1){

            sdb.setTransactionSuccessful();
        }

        sdb.endTransaction();
        close(sdb);


        return id;
    }

    public void editarCiudad(Ciudad ciudad){

        SQLiteDatabase sdb=openWriteable();
        sdb.beginTransaction();

        ContentValues cv= new ContentValues();

        cv.put(CiudadesContract.CiudadesEntry.COLUMN_NUMHAB, ciudad.getNumHab());


        String clausulaWhere= CiudadesContract.CiudadesEntry.COLUMN_ID+" =?";
        String[] argumentos={String.valueOf(ciudad.getId())};

        sdb.update(CiudadesContract.CiudadesEntry.TABLE_NAME, cv,clausulaWhere,argumentos);

        sdb.setTransactionSuccessful();
        sdb.endTransaction();
        close(sdb);
    }

    public void borrarCiudad(int idCiudad){

        SQLiteDatabase sdb = openWriteable();
        sdb.beginTransaction();

        String clausulaWhere= CiudadesContract.CiudadesEntry.COLUMN_ID+" = ? "+idCiudad;
        sdb.delete(CiudadesContract.CiudadesEntry.TABLE_NAME, clausulaWhere, null);

        sdb.setTransactionSuccessful();
        sdb.endTransaction();
        close(sdb);
    }

    public ArrayList<Ciudad> CargarCiudades() {
        ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>();
        SQLiteDatabase sdb = openReadable();

        String[] columnas = {CiudadesContract.CiudadesEntry.COLUMN_ID,
                CiudadesContract.CiudadesEntry.COLUMN_NAME,
                CiudadesContract.CiudadesEntry.COLUMN_PROVINCE,
                CiudadesContract.CiudadesEntry.COLUMN_NUMHAB};

        Cursor cursor = sdb.query(CiudadesContract.CiudadesEntry.TABLE_NAME,
                columnas, null, null,
                null, null,
                CiudadesContract.CiudadesEntry.COLUMN_NAME + " DESC");

        int id;
        String nombre;
        String provincia;
        int numHab;
        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex(CiudadesContract.CiudadesEntry.COLUMN_ID));
                nombre = cursor.getString(cursor.getColumnIndex(CiudadesContract.CiudadesEntry.COLUMN_NAME));
                provincia = cursor.getString(cursor.getColumnIndex(CiudadesContract.CiudadesEntry.COLUMN_PROVINCE));
                numHab=cursor.getInt(cursor.getColumnIndex(CiudadesContract.CiudadesEntry.COLUMN_NUMHAB));
                listaCiudades.add(new Ciudad(id, nombre, provincia, numHab));
            } while (cursor.moveToNext());
        }

        cursor.close();
        sdb.close();
        return listaCiudades;

    }

}
