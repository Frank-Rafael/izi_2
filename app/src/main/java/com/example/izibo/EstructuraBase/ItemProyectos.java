package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.izibo.R;

public class ItemProyectos extends AppCompatActivity {

    public Button btp1, btp2, btp3, btp4;
    //public ContenedorBoton ctbt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_proyectos);

        btp1 = (Button) findViewById(R.id.bt_p1);
        btp2 = (Button) findViewById(R.id.bt_p2);
        btp3 = (Button) findViewById(R.id.bt_p3);
        btp4 = (Button) findViewById(R.id.bt_p4);

    }

    public void SelProyecto(View v) {
        if(v.getId() == btp1.getId()){
            Intent iniciar = new Intent(this, ItemRegion.class);
            startActivity(iniciar);
        }
        if(v.getId() == btp2.getId()){
            Intent iniciar = new Intent(this, ItemRegion2.class);
            startActivity(iniciar);
        }
        if(v.getId() == btp3.getId()){
            Intent iniciar = new Intent(this, ItemRegion3.class);
            startActivity(iniciar);
        }
        if(v.getId() == btp4.getId()){
            Intent iniciar = new Intent(this,ItemRegion3.class);
            /*int ctbt = 4;
            Bundle mibundle = new Bundle();
            mibundle.putInt("1",ctbt);
            iniciar.putExtras(mibundle);*/
            startActivity(iniciar);
        }
    }
}
