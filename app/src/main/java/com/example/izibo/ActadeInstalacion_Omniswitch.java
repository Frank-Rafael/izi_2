package com.example.izibo;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.izibo.Extras.PreviewImage;


public class ActadeInstalacion_Omniswitch extends AppCompatActivity {

    ListView lvai5;

    String[][] datos = {
            {"1","LED de encendido del equipo"},
            {"2","Estado de conexión y etiquetado"},
            {"3","Etiquetado frontal del equipo (Número de serie)"},
            {"4","Posición 02 de ITM en Rectificador"},
            {"5","Cable de puesta a tierra en equipo (lado equipo)"},
            {"6","Cable de puesta a tierra en Gabinete"},
            {"7","Conexión y etiquetado de datos"},
            {"8","Anclaje de equipo en UR de acuerdo con el MDI"},
            {"9","Frontal del  Shelter mostrando el equipo en el rack."},

    };

    int[] datosIMGPreview = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3};

    int[] datosIMGCamera = {R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actade_instalacion_omniswitch);

        lvai5 = (ListView) findViewById(R.id.lv_ai5);

        if (ContextCompat.checkSelfPermission(ActadeInstalacion_Omniswitch.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(ActadeInstalacion_Omniswitch.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ActadeInstalacion_Omniswitch.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }

        lvai5.setAdapter(new Adaptador3(this,datos,datosIMGPreview,datosIMGCamera));
    }

    public class Adaptador3 extends BaseAdapter {

        private LayoutInflater inflater = null;

        Context context;
        String[][] datosAd;
        int[] datosIMGAd;
        int[] datosIMGCameraAd;

        public ImageView ivfoto;

        static final int REQUEST_IMAGE_CAPTURE=1;

        public Adaptador3(Context context, String[][] datosAdC, int[] datosIMGAdC, int[] datosIMGCameraAd){
            this.context = context;
            this.datosAd = datosAdC;
            this.datosIMGAd = datosIMGAdC;
            this.datosIMGCameraAd = datosIMGCameraAd;

            inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final View vista = inflater.inflate(R.layout.molde_listview_documentacion,null);

            TextView tvnumfot = (TextView)vista.findViewById(R.id.tv_numfot);
            TextView tvdescription = (TextView) vista.findViewById(R.id.tv_description);

            ImageView ivpreview = (ImageView) vista.findViewById(R.id.iv_preview);
            ivfoto = (ImageView) vista.findViewById(R.id.iv_foto);

            Button btcapturar = (Button)vista.findViewById(R.id.bt_capturar);

            tvnumfot.setText(datosAd[position][0]);
            tvdescription.setText(datosAd[position][1]);

            ivpreview.setImageResource(datosIMGAd[position]);
            ivfoto.setImageResource(datosIMGCameraAd[position]);

            ivpreview.setTag(position);
            ivpreview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentImgPre = new Intent(context, PreviewImage.class);
                    intentImgPre.putExtra("IMG",datosIMGAd[(Integer)v.getTag()]);
                    context.startActivity(intentImgPre);
                }
            });

            ivfoto.setTag(position);
            btcapturar.setTag(position);
            btcapturar.setOnClickListener(new View.OnClickListener() {

                @Override
                //onClick == tomarFoto
                public void onClick(View v) {
                    Intent intentF = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intentF,0);
                }
            });
            return vista;
        }


        @Override
        public int getCount() {
            return datosIMGAd.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
/*
    public class TomarFoto2 extends ActadeInstalacion {


       ImageView ivfoto;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.molde_listview_documentacion);

            Button btcapturar = (Button)findViewById(R.id.bt_capturar);
            ivfoto = (ImageView)findViewById(R.id.iv_foto);

            btcapturar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentF = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intentF,0);

                }
            });
        }
*/
        /*
        @Override
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            ivfoto.setImageBitmap(bitmap);
        }
        */
}