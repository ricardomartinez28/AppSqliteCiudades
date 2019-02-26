package com.example.appsqliteciudades.db;

import android.provider.BaseColumns;

public class CiudadesContract {

    public static abstract class CiudadesEntry implements BaseColumns{
        public static final String TABLE_NAME="CIUDAD";
        public static final String COLUMN_ID=BaseColumns._ID;
        public static final String COLUMN_NAME="NOMBRE";
        public static final String COLUMN_PROVINCE="PROVINCIA";
        public static final String COLUMN_NUMHAB="HABITANTES";

    }
}
