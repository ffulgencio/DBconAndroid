package com.example.francis.nominaempleados;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateEmpleadoActivity extends AppCompatActivity {
    Button btnAgregar;
    SQLiteDatabase db;
    EditText etNombre, etApellido, etCargo, etSueldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_empleado);

        try{
            DBHelper h = new DBHelper(getApplicationContext());
            db = h.getWritableDatabase();
            //db.close();
        }catch (Exception e){
            MessageBox.Show(this,e.toString());
        }
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etCargo = (EditText) findViewById(R.id.etCargo);
        etSueldo = (EditText) findViewById(R.id.etSueldo);

        btnAgregar = (Button) findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues c = new ContentValues();
                c.put(EmpleadoContract.Empleado.COLUMN_NOMBRE, String.valueOf(etNombre.getText()));
                c.put(EmpleadoContract.Empleado.COLUMN_APELLIDO, String.valueOf(etApellido.getText()));
                c.put(EmpleadoContract.Empleado.COLUMN_CARGO, String.valueOf(etCargo.getText()));
                c.put(EmpleadoContract.Empleado.COLUMN_SUELDO, String.valueOf(etSueldo.getText()));

                db.insert(EmpleadoContract.Empleado.TABLA,null,c);
            }
        });



    }
}
