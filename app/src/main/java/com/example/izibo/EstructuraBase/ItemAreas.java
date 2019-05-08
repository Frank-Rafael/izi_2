package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.izibo.R;

public class ItemAreas extends AppCompatActivity  {

    Button bta1, bta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_areas);

        bta1 = (Button) findViewById(R.id.bt_a1);
        bta2 = (Button) findViewById(R.id.bt_a2);
    }

    public void SelArea(View v) {
        if(v.getId() == bta1.getId()){
            Intent iniciar = new Intent(this, ItemTecnologias.class);
            startActivity(iniciar);
        }
        if(v.getId() == bta2.getId()){
            Intent iniciar = new Intent(this, ItemDocumentacionSeguridad.class);
            startActivity(iniciar);
        }
    }
}
