package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.izibo.EstructuraBase.ItemEquipos;
import com.example.izibo.EstructuraBase.ItemEquipos2;
import com.example.izibo.EstructuraBase.ItemEquipos3;
import com.example.izibo.R;

public class ItemTecnologias extends AppCompatActivity {

    Button btt1, btt2, btt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_tecnologias);

        btt1 = (Button) findViewById(R.id.bt_t1);
        btt2 = (Button) findViewById(R.id.bt_t2);
        btt3 = (Button) findViewById(R.id.bt_t3);

    }

    public void SelTecnologia(View v) {
        if(v.getId() == btt1.getId()){
            Intent iniciar = new Intent(this, ItemDocumentacionOperaciones.class);
            startActivity(iniciar);
        }
        if(v.getId() == btt2.getId()) {
            Intent iniciar = new Intent(this, ItemDocumentacionOperaciones2.class);
            startActivity(iniciar);
        }
        if(v.getId() == btt3.getId()) {
            Intent iniciar = new Intent(this, ItemDocumentacionOperaciones3.class);
            startActivity(iniciar);
        }
    }
}
