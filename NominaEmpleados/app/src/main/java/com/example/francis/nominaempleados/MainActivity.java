package com.example.francis.nominaempleados;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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



        listaEmpleados = (ListView) findViewById(R.id.lvEmpleados);

        listaEmpleados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(getApplicationContext(),EmpleadoDtActivity.class);
                i.putExtra("ID", String.valueOf(position+1));
                startActivity(i);
            }
        });
        btnAgregar = (Button) findViewById(R.id.button2);

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

            Cursor empleados = db.rawQuery("select Nombre, Apellido, cargo from "+ EmpleadoContract.Empleado.TABLA,null);
            //Arr
            String[] items =new String[empleados.getCount()];
            String[] cargos =new String[empleados.getCount()];
            int i =0;
            if (empleados.moveToFirst()){
                do{
                    items[i]= empleados.getString(0)+" "+ empleados.getString(1);
                    cargos[i]= empleados.getString(2);
                    i+=1;
                }while(empleados.moveToNext());
            }

            Integer [] imagenId = {
                    R.mipmap.usuario,
                    R.mipmap.usuario,
                    R.mipmap.usuario,
                    R.mipmap.usuario/*,
                    R.mipmap.usuario ,
                    R.mipmap.usuario,
                    R.mipmap.usuario,
                    android.R.drawable.ic_menu_camera */
            };
            CustomList adapter = new
                    CustomList(MainActivity.this, items,cargos, imagenId);
            //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1, items);
            listaEmpleados.setAdapter(adapter);
            //listaEmpleados.setAdapter(adaptador);
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
            //MessageBox.Show(this, "onResume");
        } catch (Exception e) {
            MessageBox.Show(this, e.toString());
        }
    }
/*

    }//*/




}
