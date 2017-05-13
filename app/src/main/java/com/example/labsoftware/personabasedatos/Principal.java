package com.example.labsoftware.personabasedatos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Principal extends AppCompatActivity {
    private ListView opciones;
    private String[] opc;
    private ArrayAdapter adapter;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        opciones = (ListView)findViewById(R.id.lstprincipal);
        opc = getResources().getStringArray(R.array.opciones);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, opc);
        opciones.setAdapter(adapter);

        opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        i = new Intent(Principal.this, Registrar.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Principal.this, ListadoTabla.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(Principal.this, ListadoPersonalizado.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }
}
