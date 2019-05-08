package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.izibo.Reportes.ActadeInstalacion;
import com.example.izibo.R;
import com.example.izibo.Reportes.ActadeInstalacion2;

public class ItemDocumentacionOperaciones extends AppCompatActivity {

    Button btdo1, btdo2, btdo3, btdo4, btdo5;
    //public Bundle datoscadena;
    //public String datosobtenidos = "";

    /*public int a;
    static final int MPR_9500 = 1;
    static final int PTP_450 = 2;
    static final int EPMP_100 = 3;
    static final int FORCE_180 = 4;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_documentacion_operaciones);

        btdo1 = (Button) findViewById(R.id.bt_do1);
        btdo2 = (Button) findViewById(R.id.bt_do2);
        btdo3 = (Button) findViewById(R.id.bt_do3);
        btdo4 = (Button) findViewById(R.id.bt_do4);
        btdo5 = (Button) findViewById(R.id.bt_do5);

        //datoscadena = getIntent().getExtras();
        //datosobtenidos = datoscadena.getString("cadena");
    }

    public void SelDocumentacion(View v) {
        if (v.getId() == btdo1.getId()) {
            Intent iniciar = new Intent(this, ItemEquipos.class);
            startActivity(iniciar);
        }

        if (v.getId() == btdo2.getId()) {
            Intent iniciar = new Intent(this, ItemEquipos.class);
            startActivity(iniciar);
        }

        if (v.getId() == btdo3.getId()) {
            Intent iniciar = new Intent(this, ItemEquipos.class);
            startActivity(iniciar);
        }
        if (v.getId() == btdo4.getId()) {
            Intent iniciar = new Intent(this, ItemEquipos.class);
            startActivity(iniciar);
        }/*
        if (v.getId() == btdo5.getId()) {
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }*/
    }
}


