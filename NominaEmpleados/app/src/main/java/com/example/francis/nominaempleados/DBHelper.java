package com.example.francis.nominaempleados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by francis on 15-Feb-17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String NOMBRE_DB = "NominaEmpleados";

    public static final int VERSION = 2 ;

    public static final String CREAR_TABLA_EMPLEADOS=
            "CREATE TABLE " + EmpleadoContact.Empleado.TABLA +"("+ EmpleadoContact.Empleado._ID
            + " INT PRIMARY KEY, "+ EmpleadoContact.Empleado.COLUMN_NOMBRE +" TEXT,"
            + EmpleadoContact.Empleado.COLUMN_APELLIDO +  " TEXT,"
            + EmpleadoContact.Empleado.COLUMN_CEDULA + " TEXT,"
            + EmpleadoContact.Empleado.COLUMN_CARGO  + " TEXT,"
            + EmpleadoContact.Empleado.COLUMN_SUELDO + " TEXT);";

    public static final String BORRAR_TABLA_EMPLEADOS =
            "DROP TABLE " + NOMBRE_DB + ';';

    public DBHelper(Context context) {
        super(context, NOMBRE_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREAR_TABLA_EMPLEADOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(BORRAR_TABLA_EMPLEADOS);
            db.execSQL(CREAR_TABLA_EMPLEADOS);

    }
}
