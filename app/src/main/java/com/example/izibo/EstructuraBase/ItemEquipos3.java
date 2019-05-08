package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.izibo.EstructuraBase.ItemDocumentacionOperaciones;
import com.example.izibo.R;
import com.example.izibo.Reportes.ActadeInstalacion;

public class ItemEquipos3 extends AppCompatActivity {

    CheckBox cbe10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_equipos3);

        cbe10 = (CheckBox) findViewById(R.id.cb_e10);
    }


    public void SelEquipo3(View v) {
        if(v.getId() == R.id.bt_e3)
            validar();
    }

    private void validar() {
        if (cbe10.isChecked() == true) {
            Intent iniciar = new Intent(this, ActadeInstalacion.class);
            startActivity(iniciar);
        }
    }
}
