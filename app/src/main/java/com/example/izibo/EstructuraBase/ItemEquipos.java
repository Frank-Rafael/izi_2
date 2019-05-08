package com.example.izibo.EstructuraBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.example.izibo.ActaDeInstalacionWebView;
import com.example.izibo.ActadeInstalacion_9500_MPR;
import com.example.izibo.ActadeInstalacion_PTP_450;
import com.example.izibo.ActadeInstalacion_ePMP_1000;
import com.example.izibo.MultipleReporteOperaciones;
import com.example.izibo.R;
import com.example.izibo.Reportes.ActadeInstalacion;
import com.example.izibo.Reportes.ActadeInstalacion2;

public class ItemEquipos extends AppCompatActivity {

    CheckBox cbe1, cbe2, cbe3, cbe4, cbe5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_equipos);

        cbe1 = (CheckBox) findViewById(R.id.cb_e1);
        cbe2 = (CheckBox) findViewById(R.id.cb_e2);
        cbe3 = (CheckBox) findViewById(R.id.cb_e3);
        cbe4 = (CheckBox) findViewById(R.id.cb_e4);
        cbe5 = (CheckBox) findViewById(R.id.cb_e5);

    }


    public void SelEquipo1(View v) {
        if (v.getId() == R.id.bt_e1)
            validar();
    }


    private void validar() {
        Intent iniciar = null;
        if (cbe1.isChecked() == true) {
            Log.d("Debug","Ya ingreso al if de mpr");
            iniciar = new Intent(this, ActadeInstalacion_9500_MPR.class);
            //iniciar.putExtra("cadena", "MPR 9500");
            startActivity(iniciar);
        } else if (cbe2.isChecked() == true) {
            iniciar = new Intent(this, ActadeInstalacion_PTP_450.class);
            //iniciar.putExtra("cadena", "PTP 450");
            startActivity(iniciar);
        } else if (cbe3.isChecked() == true) {
            Log.d("Debug","Ya ingreso al if de epmp");
            iniciar = new Intent(this, ActadeInstalacion_ePMP_1000.class);
            //iniciar = new Intent(this, ActaDeInstalacionWebView.class);
            //iniciar.putExtra("cadena", "ePMP 1000");
            startActivity(iniciar);
        } else if (cbe4.isChecked() == true) {
            iniciar = new Intent(this, ActadeInstalacion2.class);
            //iniciar.putExtra("cadena", "Force 180");
            startActivity(iniciar);
        } else if (cbe5.isChecked() == true) {
            iniciar = new Intent(this, MultipleReporteOperaciones.class);
            //iniciar.putExtra("cadena", "Force 180");
            startActivity(iniciar);
        } else if (cbe1.isChecked() == true && cbe2.isChecked() == true) {
            iniciar = new Intent(this, ActadeInstalacion.class);
            startActivity(iniciar);
        } else if (cbe1.isChecked() == true && cbe3.isChecked() == true) {
            iniciar = new Intent(this, ActadeInstalacion.class);
            startActivity(iniciar);
        } else if (cbe1.isChecked() == true && cbe4.isChecked() == true) {
            iniciar = new Intent(this, ActadeInstalacion.class);
            startActivity(iniciar);
        } else if (cbe2.isChecked() == true && cbe3.isChecked() == true) {
            iniciar = new Intent(this, ActadeInstalacion.class);
            startActivity(iniciar);
        } else if (cbe2.isChecked() == true && cbe4.isChecked() == true) {
            iniciar = new Intent(this, ActadeInstalacion.class);
            startActivity(iniciar);
        } else if (cbe3.isChecked() == true && cbe4.isChecked() == true) {
            iniciar = new Intent(this, ActadeInstalacion.class);
            startActivity(iniciar);
        } else if (cbe1.isChecked() == true && cbe2.isChecked() == true && cbe3.isChecked() == true) {
            iniciar = new Intent(this, ActadeInstalacion.class);
            startActivity(iniciar);
        } else if (cbe1.isChecked() == true && cbe2.isChecked() == true && cbe4.isChecked() == true) {
            iniciar = new Intent(this, ActadeInstalacion.class);
            startActivity(iniciar);
        } else if (cbe2.isChecked() == true && cbe3.isChecked() == true && cbe4.isChecked() == true) {
            iniciar = new Intent(this, ActadeInstalacion.class);
            startActivity(iniciar);
        } else if (cbe1.isChecked() == true && cbe2.isChecked() == true && cbe3.isChecked() == true && cbe4.isChecked() == true) {
            iniciar = new Intent(this, ActadeInstalacion.class);
            startActivity(iniciar);
        }


    }
}

