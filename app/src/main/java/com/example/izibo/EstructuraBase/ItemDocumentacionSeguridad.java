package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.izibo.DocumentacionSeguridad_ATS;
import com.example.izibo.DocumentacionSeguridad_Charla;
import com.example.izibo.MultipleReporteSeguridad;
import com.example.izibo.R;

public class ItemDocumentacionSeguridad extends AppCompatActivity {

    Button btds1, btds2, btds3, btds4, btds5, btds6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_documentacion_seguridad);

        btds1 = (Button) findViewById(R.id.bt_ds1);
        btds2 = (Button) findViewById(R.id.bt_ds2);
        btds3 = (Button) findViewById(R.id.bt_ds3);
        btds4 = (Button) findViewById(R.id.bt_ds4);
        btds5 = (Button) findViewById(R.id.bt_ds5);

        btds6 = (Button) findViewById(R.id.bt_ds6);
    }

    public void SelDocumentacionSeg(View v) {
        if (v.getId() == btds1.getId()) {
            Intent iniciar = new Intent(this, DocumentacionSeguridad_ATS.class);
            startActivity(iniciar);
        }

        if (v.getId() == btds2.getId()) {
            Intent iniciar = new Intent(this, DocumentacionSeguridad_Charla.class);
            startActivity(iniciar);
        }

        if (v.getId() == btds3.getId()) {
            Intent iniciar = new Intent(this, DocumentacionSeguridad_ATS.class);
            startActivity(iniciar);
        }
        if (v.getId() == btds4.getId()) {
            Intent iniciar = new Intent(this, DocumentacionSeguridad_ATS.class);
            startActivity(iniciar);
        }/*
        if (v.getId() == btdo5.getId()) {
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }*/
        if (v.getId() == btds6.getId()) {
            Intent iniciar = new Intent(this, MultipleReporteSeguridad.class);
            startActivity(iniciar);
        }
    }
}
