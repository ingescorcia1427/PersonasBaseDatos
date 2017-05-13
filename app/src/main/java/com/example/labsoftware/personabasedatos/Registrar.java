package com.example.labsoftware.personabasedatos;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Registrar extends AppCompatActivity {
    private EditText cajaCedula, cajaNombre, cajaApellido;
    private RadioButton rdMasculino, rdFemenino;
    private CheckBox chkProgramar, chkLeer, chkBailar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        cajaCedula = (EditText) findViewById(R.id.txtcedula);
        cajaNombre = (EditText) findViewById(R.id.txtnombre);
        cajaApellido = (EditText) findViewById(R.id.txtapellido);
        rdMasculino = (RadioButton) findViewById(R.id.rdbMasculino);
        rdFemenino = (RadioButton) findViewById(R.id.rdbFemenino);
        chkProgramar = (CheckBox)findViewById(R.id.chbprogramar);
        chkLeer = (CheckBox)findViewById(R.id.chbleer);
        chkBailar = (CheckBox)findViewById(R.id.chbBailar);
    }

    public boolean validarTodo() {
        if (cajaCedula.getText().toString().isEmpty()) {
            cajaCedula.setError("Digite cédula");
            cajaCedula.requestFocus();
            return false;
        }
        if (cajaNombre.getText().toString().isEmpty()) {
            cajaNombre.setError("Digite Nombre");
            cajaNombre.requestFocus();
            return false;
        }
        if (cajaApellido.getText().toString().isEmpty()) {
            cajaApellido.setError("Digite Apellido");
            cajaApellido.requestFocus();
            return false;
        }

        if((!chkProgramar.isChecked()) && (!chkLeer.isChecked()) && (!chkBailar.isChecked())){
            new AlertDialog.Builder(this).setMessage("Seleccione por lo menos un pasatiempo").show();
        }
        return true;

    }

    public boolean validarCedula() {
        if (cajaCedula.getText().toString().isEmpty()) {
            cajaCedula.setError("Digite cédula");
            cajaCedula.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        cajaCedula.setText("");
        cajaNombre.setText("");
        cajaApellido.setText("");
        rdMasculino.setChecked(true);
        chkProgramar.setChecked(false);
        chkLeer.setChecked(false);
        chkBailar.setChecked(false);
        cajaCedula.requestFocus();
    }

    public void guardar(View v){
        String foto, cedula, nombre, apellido, sexo, pasatiempo="";
        Persona p;

        if (validarTodo()){
            foto = String.valueOf(fotoAleatoria());
            cedula = cajaCedula.getText().toString();
            nombre = cajaNombre.getText().toString();
            apellido = cajaApellido.getText().toString();

            if(rdMasculino.isChecked()) sexo=getResources().getString(R.string.masculino);
            else sexo=getResources().getString(R.string.femenino);

            if(chkProgramar.isChecked()){
                pasatiempo = getResources().getString(R.string.programar) + ", ";
            }

            if(chkLeer.isChecked()){
                pasatiempo = pasatiempo+getResources().getString(R.string.leer) + ", ";
            }

            if(chkBailar.isChecked()){
                pasatiempo = pasatiempo+getResources().getString(R.string.bailar) + ", ";
            }

            pasatiempo = pasatiempo.substring(0, pasatiempo.length()-2);
            p = new Persona(foto, cedula, nombre, apellido, sexo, pasatiempo);
            p.guardar(getApplicationContext());

            new AlertDialog.Builder(this).setMessage("Persona guardada Exitosamente").show();
            limpiar(v);
        }
    }


    public void buscar(View v){
        Persona p;
        String pasatiempos;
        if(validarCedula()){
            p = Datos.buscarPersona(getApplicationContext(),cajaCedula.getText().toString());
            if(p!=null) {
                cajaNombre.setText(p.getNombre());
                cajaApellido.setText(p.getApellido());
                //Setear RadioButton
                if (p.getSexo().equalsIgnoreCase(getResources().getString(R.string.masculino)))
                    rdMasculino.setChecked(true);
                else rdFemenino.setChecked(true);
                //Setear CheckBox
                pasatiempos = p.getPasatiempo();
                if (pasatiempos.contains(getResources().getString(R.string.programar))) chkProgramar.setChecked(true);
                if (pasatiempos.contains(getResources().getString(R.string.leer))) chkLeer.setChecked(true);
                if (pasatiempos.contains(getResources().getString(R.string.bailar))) chkBailar.setChecked(true);
            }
        }
    }

    public void eliminar(View v){
        Persona p;
        if(validarCedula()){
            p = Datos.buscarPersona(getApplicationContext(),cajaCedula.getText().toString());
            if(p!=null) {
                p.eliminar(getApplicationContext());
                new AlertDialog.Builder(this).setMessage("Persona Eliminada Exitosamente").show();
                limpiar(v);
            }
        }
    }

    public int fotoAleatoria(){
        int fotod[] = {R.drawable.images, R.drawable.images2, R.drawable.images3};
        int numero = (int)(Math.random()*3);
        return fotod[numero];
    }
}
