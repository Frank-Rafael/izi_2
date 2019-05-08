package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.izibo.R;

public class ItemDocumentacionOperaciones3 extends AppCompatActivity {

    Button btdo3_1, btdo3_2, btdo3_3, btdo3_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_documentacion_operaciones3);

        btdo3_1 = (Button) findViewById(R.id.bt_do3_1);
        btdo3_2 = (Button) findViewById(R.id.bt_do3_2);
        btdo3_3 = (Button) findViewById(R.id.bt_do3_3);
        btdo3_4 = (Button) findViewById(R.id.bt_do3_4);


    }

    public void SelDocumentacion3(View v) {
        if (v.getId() == btdo3_1.getId()) {
            Intent iniciar = new Intent(this, ItemEquipos3.class);
            startActivity(iniciar);
        }

        if (v.getId() == btdo3_2.getId()) {
            Intent iniciar = new Intent(this, ItemEquipos3.class);
            startActivity(iniciar);
        }

        if (v.getId() == btdo3_3.getId()) {
            Intent iniciar = new Intent(this, ItemEquipos3.class);
            startActivity(iniciar);
        }
        /*
        if (v.getId() == btdo4.getId()) {
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }*/
    }
}
