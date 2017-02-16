package com.example.francis.nominaempleados;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by francis on 15-Feb-17.
 */

public class MessageBox {

    public static void Show(Context context, String mensaje){
        Toast.makeText(context,mensaje,Toast.LENGTH_SHORT).show();
    }
}
