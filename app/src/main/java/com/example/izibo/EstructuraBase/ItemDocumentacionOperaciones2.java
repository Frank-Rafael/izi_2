package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.izibo.R;

public class ItemDocumentacionOperaciones2 extends AppCompatActivity {


    Button btdo2_1, btdo2_2, btdo2_3, btdo2_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_documentacion_operaciones2);

        btdo2_1 = (Button) findViewById(R.id.bt_do2_1);
        btdo2_2 = (Button) findViewById(R.id.bt_do2_2);
        btdo2_3 = (Button) findViewById(R.id.bt_do2_3);
        btdo2_4 = (Button) findViewById(R.id.bt_do2_4);


    }

    public void SelDocumentacion2(View v) {
        if (v.getId() == btdo2_1.getId()) {
            Intent iniciar = new Intent(this, ItemEquipos2.class);
            startActivity(iniciar);
        }

        if (v.getId() == btdo2_2.getId()) {
            Intent iniciar = new Intent(this, ItemEquipos2.class);
            startActivity(iniciar);
        }

        if (v.getId() == btdo2_3.getId()) {
            Intent iniciar = new Intent(this, ItemEquipos2.class);
            startActivity(iniciar);
        }
        /*
        if (v.getId() == btdo4.getId()) {
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }*/
    }
}
