package com.example.francis.nominaempleados;

/**
 * Created by ffulgencio on 16-Feb-17.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] Nombres;
    private final String[] Cargos;
    private final Integer[] imageId;

    public CustomList(Activity context,
                      String[] nombres,String[] cargos, Integer[] imageId) {
        super(context, R.layout.item_layout, nombres);
        this.context = context;
        this.Nombres = nombres;
        this.Cargos = cargos;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View rowView= inflater.inflate(R.layout.item_layout, null, true);

        TextView txtNombre = (TextView) rowView.findViewById(R.id.textView2);
        TextView txtCargo = (TextView) rowView.findViewById(R.id.textView3);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

        txtNombre.setText(Nombres[position]);
        txtCargo.setText(Cargos[position]);


        //imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
