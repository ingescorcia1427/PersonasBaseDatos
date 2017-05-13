package com.example.labsoftware.personabasedatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListadoPersonalizado extends AppCompatActivity {
    private ListView lstpersonalizado;
    private ArrayList<Persona> personas;
    private AdaptadorPersona adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_personalizado);

        lstpersonalizado = (ListView)findViewById(R.id.lstListado);
        personas = Datos.traerpersonas(getApplicationContext());
        adapter = new AdaptadorPersona(getApplicationContext(), personas);
        lstpersonalizado.setAdapter(adapter);

    }
}
