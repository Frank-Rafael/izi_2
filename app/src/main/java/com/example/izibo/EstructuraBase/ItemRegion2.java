package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.izibo.EstructuraBase.ItemAreas;
import com.example.izibo.R;

public class ItemRegion2 extends AppCompatActivity {

    Button btr3, btr4, btr5, btr6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_region2);

        btr3 = (Button) findViewById(R.id.bt_r3);
        btr4 = (Button) findViewById(R.id.bt_r4);
        btr5 = (Button) findViewById(R.id.bt_r5);
        btr6 = (Button) findViewById(R.id.bt_r6);
    }

    public void SelRegion2(View v) {
        if(v.getId() == btr3.getId()){
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }
        if(v.getId() == btr4.getId()) {
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }
        if(v.getId() == btr5.getId()){
            Intent iniciar = new Intent(this,ItemAreas.class);
            startActivity(iniciar);
        }
        if(v.getId() == btr6.getId()) {
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }

    }
}
