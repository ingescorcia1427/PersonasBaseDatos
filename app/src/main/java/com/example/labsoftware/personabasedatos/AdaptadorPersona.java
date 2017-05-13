package com.example.labsoftware.personabasedatos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LabSoftware on 13/05/2017.
 */

public class AdaptadorPersona extends BaseAdapter {
    private Context contexto;
    private ArrayList<Persona> personas;

    public AdaptadorPersona(Context contexto, ArrayList<Persona> personas) {
        this.contexto = contexto;
        this.personas = personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(personas.get(position).getCedula());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Declarar variables
        TextView cajaCedula, cajaNombre, cajaApellido;
        ImageView foto;
        LayoutInflater inflater;
        View itemView;

        //Uso del Inflater
        inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.item_personalizado,null);

        //Capturar los objetos
        cajaCedula = (TextView)itemView.findViewById(R.id.txtcedP);
        cajaNombre = (TextView)itemView.findViewById(R.id.txtnomP);
        cajaApellido = (TextView)itemView.findViewById(R.id.txtapeP);
        foto = (ImageView)itemView.findViewById(R.id.imgFoto);

        //Pasar la informacion
        foto.setImageResource(Integer.parseInt(personas.get(position).getFoto()));
        cajaCedula.setText(personas.get(position).getCedula());
        cajaNombre.setText(personas.get(position).getNombre());
        cajaApellido.setText(personas.get(position).getApellido());

        //Retornar el ItemView
        return itemView;
    }
}
