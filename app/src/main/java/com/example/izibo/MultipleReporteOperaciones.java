package com.example.izibo;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MultipleReporteOperaciones extends AppCompatActivity implements FragmentePMP1000.OnFragmentInteractionListener,
                    FragmentForce180.OnFragmentInteractionListener{

    FragmentePMP1000 fragmentePMP1000;
    FragmentForce180 fragmentForce180;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_reporte_operaciones);

        fragmentePMP1000 = new FragmentePMP1000();
        fragmentForce180 = new FragmentForce180();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments,fragmentePMP1000);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.ePMP1000:
                fragmentTransaction.replace(R.id.contenedorFragments,fragmentePMP1000);
                break;
            case R.id.Force180:
                fragmentTransaction.replace(R.id.contenedorFragments,fragmentForce180);
                break;
        }




        fragmentTransaction.commit();
    }
}