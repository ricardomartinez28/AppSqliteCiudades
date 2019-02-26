package com.example.appsqliteciudades.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class CiudadesSQLiteHelper extends SQLiteOpenHelper {

    static  final String DATABASE_NAME="CiudadesDB";
    static  final int DATABASE_VERSION=1;


    static final String CREATE_TABLE_CIUDADES=
            "CREATE TABLE "+CiudadesContract.CiudadesEntry.TABLE_NAME+"("+
                    CiudadesContract.CiudadesEntry.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                    CiudadesContract.CiudadesEntry.COLUMN_NAME+" TEXT NOT NULL, "+
                    CiudadesContract.CiudadesEntry.COLUMN_PROVINCE+" TEXT NOT NULL, "+
                    CiudadesContract.CiudadesEntry.COLUMN_NUMHAB+" INTEGER NOT NULL;";

    public CiudadesSQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CIUDADES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ CiudadesContract.CiudadesEntry.TABLE_NAME);
    }
}
