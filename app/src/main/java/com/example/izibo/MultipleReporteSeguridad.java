package com.example.izibo;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MultipleReporteSeguridad extends AppCompatActivity implements FragmentATS.OnFragmentInteractionListener,
                FragmentCharla.OnFragmentInteractionListener{

    FragmentATS fragmentATS;
    FragmentCharla fragmentCharla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_reporte_seguridad);

        fragmentATS = new FragmentATS();
        fragmentCharla = new FragmentCharla();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments,fragmentATS);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.ATS:
                    fragmentTransaction.replace(R.id.contenedorFragments,fragmentATS);
                break;
            case R.id.Charla:
                    fragmentTransaction.replace(R.id.contenedorFragments,fragmentCharla);
                break;
        }




        fragmentTransaction.commit();
    }
}
