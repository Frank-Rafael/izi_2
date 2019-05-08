package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.izibo.EstructuraBase.ItemAreas;
import com.example.izibo.R;

public class ItemRegion extends AppCompatActivity  {

    Button btr1, btr2;
    //btr3, btr4, btr5, btr6, btr7;
    //int comparador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_region);

        //Bundle mibundle1 = this.getIntent().getExtras();
        //Toast.makeText(this,"El valor de contenedor es "+ mibundle1.getInt("1"), Toast.LENGTH_SHORT).show();
        //if (mibundle1.getInt("1") == 1) {
            btr1 = (Button) findViewById(R.id.bt_r1);
            btr2 = (Button) findViewById(R.id.bt_r2);
        //}
        /*if (mibundle1.getInt("1") == 2) {
            btr3 = (Button) findViewById(R.id.bt_r3);
            btr4 = (Button) findViewById(R.id.bt_r4);
        //}
        //if (mibundle1.getInt("1") == 3) {
            btr5 = (Button) findViewById(R.id.bt_r5);
            btr6 = (Button) findViewById(R.id.bt_r6);
        //}
        //if(mibundle1.getInt("1") == 4) {
            btr7 = (Button) findViewById(R.id.bt_r7);
        //}
        */

    }

     public void SelRegion1(View v) {
        if(v.getId() == btr1.getId()){
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }
        if(v.getId() == btr2.getId()) {
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }
        /*
        if(v.getId() == btr3.getId()) {
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }
        if(v.getId() == btr4.getId()) {
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }
        if(v.getId() == btr5.getId()) {
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }
        if(v.getId() == btr6.getId()) {
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }
        if(v.getId() == btr7.getId()) {
            Intent iniciar = new Intent(this, ItemAreas.class);
            startActivity(iniciar);
        }
        */
    }
}
