package com.example.izibo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ItemProyectosBUListView extends AppCompatActivity {
    /*
    ListView lvpro;
    int p;

    String proyectos[] = {"Redes Regionales", "RDNFO", "IPRAN (CLARO)", "BACKHAUL (TDP)"};
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_proyectos_bulist_view);
        /*
        lvpro = (ListView) findViewById(R.id.lv_pro);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_proyectos, proyectos);
        lvpro.setAdapter(adapter);

        lvpro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lvpro.getItemAtPosition(position);
                p = position;
               // if (lvpro.getItemAtPosition(position) == 0) {
                    Intent redreg = new Intent(this, ItemRegion.class);
                    startActivity(redreg);
                }else if (lvpro.getItemAtPosition(position) == 1) {
                    Intent rdnfo = new Intent(this, ItemRegion.class);
                    startActivity(rdnfo);
                } else if (lvpro.getItemAtPosition(position) == 2) {
                    Intent ipran = new Intent(this, ItemRegion.class);
                    startActivity(ipran);
                } else if (lvpro.getItemAtPosition(position) == 3) {
                    Intent bh = new Intent(this, ItemRegion.class);
                    startActivity(bh);
                }//

            }
        });
        */
    }
}
