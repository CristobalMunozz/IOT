package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class segundaPantalla extends AppCompatActivity {
    private TextInputLayout tilBuscar;
    private Button btnFiltrar;
    private Spinner spnTarea;
    private ListView ltvTareas;
    private ArrayAdapter<Tarea> adaptadorTareasLista;
    private ArrayList<Tarea> arrayRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        referencias();
        obtenerDatos();
        eventos();

        adaptadorTareasLista = new ArrayAdapter<Tarea>(this, android.R.layout.simple_list_item_1, arrayRecibido);
        //spnTarea.setAdapter(adaptadorTareasLista);

        ltvTareas.setAdapter(adaptadorTareasLista);
    }

    private void obtenerDatos() {

        arrayRecibido = (ArrayList<Tarea>) getIntent().getExtras().get("arrayTarea");
        Log.d("TAG_", "Tarea recibida ");
        for(Tarea tareaR : arrayRecibido){
            Log.d("TAG_", "Tarea recibida " + tareaR.toString());
        }
    }

    private void referencias() {
        tilBuscar = findViewById(R.id.tilBuscar);
        btnFiltrar = findViewById(R.id.btnFiltrar);
        ltvTareas = findViewById(R.id.ltvTareas);
    }

    private void eventos() {



        ltvTareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int indiceSeleccionado, long id) {
                /**Tarea tareaSeleccionada = TareasArraylist.get(indiceSeleccionado);
                Toast.makeText(segundaPantalla.this, "La tarea  es " + tareaSeleccionada.getTitulo()
                        , Toast.LENGTH_SHORT).show();*/


            }
        });

        /** ltvTareas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               Tarea tareaSeleccionada = TareasArraylist.get(position);
                Toast.makeText(segundaPantalla.this, "la Descripcion es " + tareaSeleccionada.getDescripcion()
                        , Toast.LENGTH_SHORT).show();
                return true;
            }
        });*/

    }

    //endregion


}