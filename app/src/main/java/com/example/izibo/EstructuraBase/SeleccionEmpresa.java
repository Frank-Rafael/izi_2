package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.izibo.EstructuraBase.ItemProyectos;
import com.example.izibo.R;

public class SeleccionEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_empresa);
    }

    public void SelEmpresa(View view) {
        Intent mn = new Intent(this, ItemProyectos.class);
        startActivity(mn);
    }
}
