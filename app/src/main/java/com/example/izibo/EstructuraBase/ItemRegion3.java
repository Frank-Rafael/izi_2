package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.izibo.EstructuraBase.ItemAreas;
import com.example.izibo.R;

public class ItemRegion3 extends AppCompatActivity {

    Button btr7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_region3);

        btr7 = (Button) findViewById(R.id.bt_r7);
    }

    public void SelRegion3(View v) {
        Intent iniciar = new Intent(this, ItemAreas.class);
        startActivity(iniciar);
    }
}
