package com.example.labsoftware.personabasedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LabSoftware on 13/05/2017.
 */

public class PersonasSQLiteOpenHelper extends SQLiteOpenHelper {
    private String sql = "CREATE TABLE Personas(foto text, cedula text, nombre text, apellido, text, sexo, text, pasatiempo text)";

    public PersonasSQLiteOpenHelper(Context contexto, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(contexto, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Personas");
        db.execSQL(sql);
    }
}
