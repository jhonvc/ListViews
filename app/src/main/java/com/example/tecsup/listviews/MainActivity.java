package com.example.tecsup.listviews;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    List<String>datos;
    GridAdapter adapter;
    Button btn_agregar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.grid_view);
        btn_agregar=findViewById(R.id.btn_agregar);
        datos=new ArrayList<>();
        datos.add("hola");
        datos.add("codigo");

        adapter=new GridAdapter(this,R.layout.grid_item,datos);
        gridView.setAdapter(adapter);
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MostarDialogoAgregar();
            }
        });

    }
    void MostarDialogoAgregar(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Crear Nuevo");
        builder.setMessage("Ingrese un nuevo dato");
        View v=LayoutInflater.from(MainActivity.this).inflate(R.layout.item_form,null);
        builder.setView(v);
       final EditText et=v.findViewById(R.id.editText);
        builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                CrearNuevoItem(et.getText().toString());

            }
        });
        builder.show();

    }
    void CrearNuevoItem(String s){
        datos.add(s);
        adapter.notifyDataSetChanged();
    }
}
