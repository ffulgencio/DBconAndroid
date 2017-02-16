package com.example.francis.nominaempleados;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {


    Button btnAgregar;
    SQLiteDatabase db;
    ListView listaEmpleados;
    DBHelper h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            h = new DBHelper(getApplicationContext());
            db = h.getReadableDatabase();
            LlenarLista(db);


        }catch (Exception e){
            MessageBox.Show(this,e.toString());
        }




        btnAgregar = (Button) findViewById(R.id.button);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crearEmpleado = new Intent(getApplicationContext(),CreateEmpleadoActivity.class);
                startActivity(crearEmpleado);
            }
        }); // */




    }


    public void LlenarLista(SQLiteDatabase db){
        try{
            listaEmpleados = (ListView) findViewById(R.id.lvEmpleados);

            Cursor empleados = db.rawQuery("select Nombre from "+ EmpleadoContract.Empleado.TABLA,null);
            //Arr
            String[] items =new String[empleados.getCount()];
            int i =0;
            if (empleados.moveToFirst()){
                do{
                    items[i]= empleados.getString(0);
                    i++;
                }while(empleados.moveToNext());
            }

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1, items);
            listaEmpleados.setAdapter(adaptador);
            db.close();
        }catch (Exception e){
            MessageBox.Show(getApplicationContext(),e.toString());
            db.close();
        }
    }// */

    @Override protected void onResume() {

        super.onResume();
        try {
            SQLiteDatabase data = h.getReadableDatabase();
            LlenarLista(data);
            MessageBox.Show(this, "onResume");
        } catch (Exception e) {
            MessageBox.Show(this, e.toString());
        }
    }
/*

    }//*/




}
