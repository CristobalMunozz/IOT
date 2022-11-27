package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.AbstractCollection;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private TextInputLayout TilTarea,TiLDescripcion;
    private Button btnIngresar, btnModificar, btnBuscar;
    private ArrayList<Tarea> arrayTarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referencias();
        eventos();
        arrayTarea = new ArrayList<Tarea>();
    }


    private void modificarTarea(){
        int encontrado = 0;
       for(Tarea tareaBuscada : arrayTarea){
           if(tareaBuscada.getTitulo().equalsIgnoreCase(TilTarea.getEditText().getText().toString())){
               tareaBuscada.setDescripcion(TiLDescripcion.getEditText().getText().toString());
               encontrado++;
               Log.d("TAG_", "Tarea modificada " + tareaBuscada.toString());
           }
       }
       if(encontrado == 0){
           Toast.makeText(MainActivity.this, "No se ha encontrado la tarea " + TilTarea.getEditText().getText().toString()
                   , Toast.LENGTH_SHORT).show();
       }

    }

    private void agregarTareas() {

        Tarea tarea = new Tarea ();
        Double idGenerado = Math.random() * 100;
        Log.d("TAG_", "idGenerado " + idGenerado);
        int idEntero = Integer.valueOf(idGenerado.intValue());
        Log.d("TAG_", "idEntero " + idEntero);
        tarea.setId(idEntero);
        tarea.setTitulo(TilTarea.getEditText().getText().toString());
        tarea.setDescripcion(TiLDescripcion.getEditText().getText().toString());
        arrayTarea.add(tarea);
        Log.d("TAG_", "Tarea agregada " + tarea.toString());
    }

    private void mostrarTareaSegundaPantalla(){
        Intent segundaPantalla = new Intent(this,segundaPantalla.class);
        segundaPantalla.putExtra("arrayTarea",arrayTarea);

        startActivity(segundaPantalla);
    }

    //region Eventos y referencias
    private void eventos() {
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarTareas();
            }
        });


        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarTarea();
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarTareaSegundaPantalla();
            }
        });
    }



    private void referencias() {
        TilTarea = findViewById(R.id.TilTarea);
        btnIngresar = findViewById(R.id.btningresar);
        btnModificar = findViewById(R.id.btnModificar);
        btnBuscar= findViewById(R.id.btnBuscar);
        TiLDescripcion=findViewById(R.id.TiLDescripcion);
    }


}
//endregion
