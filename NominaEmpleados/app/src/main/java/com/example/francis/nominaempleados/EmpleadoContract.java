package com.example.francis.nominaempleados;

import android.provider.BaseColumns;

/**
 * Created by francis on 15-Feb-17.
 */

public final class EmpleadoContract {

    private EmpleadoContract(){

    }

    public static class Empleado implements BaseColumns{
        public static final String TABLA ="Empleados";
        public static final String COLUMN_NOMBRE ="Nombre";
        public static final String COLUMN_APELLIDO = "Apellido";
        public static final String COLUMN_CEDULA ="Cedula";
        public static final String COLUMN_CARGO = "Cargo";
        public static final String COLUMN_SUELDO = "Sueldo";

    }
}
