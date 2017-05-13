package com.example.labsoftware.personabasedatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListadoPersonalizado extends AppCompatActivity {
    private ListView lista;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_personalizado);

        lista = (ListView)findViewById(R.l)
    }
}
