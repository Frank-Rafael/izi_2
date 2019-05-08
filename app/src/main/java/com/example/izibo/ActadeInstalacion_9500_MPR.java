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
import com.example.izibo.Reportes.ActadeInstalacion;

public class ActadeInstalacion_9500_MPR extends AppCompatActivity {

    ListView lvai3;

    String[][] datos = {
            {"1","Número de serie de Antena"},
            {"2","Número de serie de ODU"},
            {"3","Número de serie de P.I.B"},
            {"4","Foto frontal de antena"},
            {"5","Etiqueta Antena"},
            {"6","Estructura donde se vea la antena instalada"},
            {"7","Sellado R2CT"},
            {"8","Polarización"},
            {"9","Aterramiento ODU lado Antena"},
            {"10","Aterramiento ODU lado BDT"},
            {"11","Sellado KIT de tierra alto"},
            {"12","Sellado KIT de tierra medio (si aplica)"},
            {"13","Sellado KIT de tierra bajo"},
            {"14","Sellado KIT de tierra Pasamuro"},
            {"15","Ruteo SF/UTP vertical arriba"},
            {"16","Ruteo SF/UTP vertical abajo"},
            {"17","Ruteo SF/UTP horizontal hacia subida"},
            {"18","Ruteo SF/UTP exterior hacia pasamuros"},
            {"19","Ruteo SF/UTP interior hacia pasamuros"},
            {"20","Vista de Rack completo"},
            {"21","Vista de interconexión P.I.B a Router o Sw."},
            {"22","Vista de aterramiento P.I.B"},
            {"23","Alimentación rectificador (1)"},
            {"24","Alimentación rectificador (2)"},
            {"25","Etiquetados energía (Rect)"},
            {"26","Etiquetados energía (P.I.B)"},
            {"27","Etiquetados SF/UTP ODU - PIB"},
            {"28","Etiquetados tierra P.I.B - Barra"},


    };

    int[] datosIMGPreview = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1};

    int[] datosIMGCamera = {R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actade_instalacion_9500_mpr);

        lvai3 = (ListView) findViewById(R.id.lv_ai3);

        if (ContextCompat.checkSelfPermission(ActadeInstalacion_9500_MPR.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(ActadeInstalacion_9500_MPR.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ActadeInstalacion_9500_MPR.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }

        lvai3.setAdapter(new Adaptador3(this,datos,datosIMGPreview,datosIMGCamera));
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

        /*
        @Override
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            ivfoto.setImageBitmap(bitmap);
        }

    }*/
}