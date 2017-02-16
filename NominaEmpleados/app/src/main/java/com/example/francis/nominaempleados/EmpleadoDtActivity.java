package com.example.francis.nominaempleados;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EmpleadoDtActivity extends AppCompatActivity {

    TextView txtNombre, txtApellido,txtCargo, txtSueldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado_dt);
        try {
            String id = (String) getIntent().getExtras().getSerializable("ID");

            DBHelper h = new DBHelper(getApplicationContext());

            SQLiteDatabase db = h.getReadableDatabase();

            Cursor c = db.rawQuery("select _id,Nombre, Apellido, cargo, sueldo from "
                    + EmpleadoContract.Empleado.TABLA
                    + " where "+ EmpleadoContract.Empleado._ID+ "=" + id, null);

            txtNombre = (TextView) findViewById(R.id.txtNombre);
            txtApellido = (TextView) findViewById(R.id.txtApellido);
            txtCargo = (TextView) findViewById(R.id.txtCargo);
            txtSueldo = (TextView) findViewById(R.id.txtSueldo);

            if (c.moveToFirst()) {
                txtNombre.setText(c.getString(1));
                txtApellido.setText(c.getString(2));
                txtCargo.setText(c.getString(3));
                txtSueldo.setText(c.getString(4));
            }

            db.close();
        }catch (Exception e){
            MessageBox.Show(this, e.toString());
        }
    }
}
