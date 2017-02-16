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

    public static final String CREAR_TABLA_EMPLEADOS =
            "CREATE TABLE " + EmpleadoContract.Empleado.TABLA +"("
            + EmpleadoContract.Empleado._ID + " INTEGER PRIMARY KEY, "
            + EmpleadoContract.Empleado.COLUMN_NOMBRE +" TEXT,"
            + EmpleadoContract.Empleado.COLUMN_APELLIDO +  " TEXT,"
            + EmpleadoContract.Empleado.COLUMN_CEDULA + " TEXT,"
            + EmpleadoContract.Empleado.COLUMN_CARGO  + " TEXT,"
            + EmpleadoContract.Empleado.COLUMN_SUELDO + " TEXT)";

    public static final String BORRAR_TABLA_EMPLEADOS =
            "DROP TABLE " + EmpleadoContract.Empleado.TABLA+ ';';

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
