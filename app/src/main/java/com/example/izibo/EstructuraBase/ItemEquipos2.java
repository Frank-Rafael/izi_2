package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.izibo.ActadeInstalacion_Omniswitch;
import com.example.izibo.EstructuraBase.ItemDocumentacionOperaciones;
import com.example.izibo.R;
import com.example.izibo.Reportes.ActadeInstalacion2;

public class ItemEquipos2 extends AppCompatActivity {

    CheckBox cbe5, cbe6, cbe7, cbe8, cbe9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_equipos2);

        cbe5 = (CheckBox) findViewById(R.id.cb_e5);
        cbe6 = (CheckBox) findViewById(R.id.cb_e6);
        cbe7 = (CheckBox) findViewById(R.id.cb_e7);
        cbe8 = (CheckBox) findViewById(R.id.cb_e8);
        cbe9 = (CheckBox) findViewById(R.id.cb_e9);
    }


    public void SelEquipo2(View v) {
        if(v.getId() == R.id.bt_e2)
            validar();
    }

    private void validar() {
        if (cbe5.isChecked() == true) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe6.isChecked() == true) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe7.isChecked() == true) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe8.isChecked() == true) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe9.isChecked() == true) {
            Intent iniciar = new Intent(this, ActadeInstalacion_Omniswitch.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe6.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe7.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe8.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe6.isChecked() && cbe7.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe6.isChecked() && cbe8.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe6.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe7.isChecked() && cbe8.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe7.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe8.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe6.isChecked() && cbe7.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe6.isChecked() && cbe8.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe6.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe7.isChecked() && cbe8.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe7.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe8.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe6.isChecked() && cbe7.isChecked() && cbe8.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe6.isChecked() && cbe7.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe6.isChecked() && cbe8.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe7.isChecked() && cbe8.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe6.isChecked() && cbe7.isChecked() && cbe8.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe7.isChecked() && cbe8.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }else if (cbe5.isChecked() && cbe6.isChecked() && cbe8.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe6.isChecked() && cbe7.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe6.isChecked() && cbe7.isChecked() && cbe8.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
        else if (cbe5.isChecked() && cbe6.isChecked() && cbe7.isChecked() && cbe8.isChecked() && cbe9.isChecked()) {
            Intent iniciar = new Intent(this, ActadeInstalacion2.class);
            startActivity(iniciar);
        }
    }
}
