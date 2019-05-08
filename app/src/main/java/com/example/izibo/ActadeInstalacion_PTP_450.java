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


public class ActadeInstalacion_PTP_450 extends AppCompatActivity {

    ListView lvai4;

    String[][] datos = {
            {"1","Número de serie de Antena"},
            {"2","Número de serie de Antena Integrada"},
            {"3","Número de serie de Surge Suppressor (outdoor)"},
            {"4","Número de serie de Surge Suppressor (indoor)"},
            {"5","Número de serie de Surge Suppressor (cmm5)"},
            {"6","Número de serie antena UGPS"},
            {"7","Número de serie CMM5 Controller"},
            {"8","Número de serie CMM5 Injector"},
            {"9","Número de serie de PoE"},
            {"10","Foto frontal de antena."},
            {"11","Etiquetado de antena sólo para conectorizado"},
            {"12","Estructura donde se ve la antena instalada"},
            {"13","Sellado"},
            {"14","Polarización"},
            {"15","Foto frontal de antena /Integrada)"},
            {"16","Estructura donde se ve la antena instalada"},
            {"17","Sellado"},
            {"18","Polarización"},
            {"19","Foto frontal antena UGPS"},
            {"20","Estructura donde se ve la antena"},
            {"21","Sellado de antena UGPS"},
            {"22","Ubicación de antena UGPS con brújula"},
            {"23","Aterramiento lado Antena integrada"},
            {"24","Aterramiento antena integrada"},
            {"25","Sellado KIT de tierra alto"},
            {"26","Sellado KIT de tierra medio (si aplica)"},
            {"27","Sellado KIT de tierra bajo"},
            {"28","Sellado KIT de tierra Pasamuro"},
            {"29","Ruteo SF/UTP vertical hacia arriba"},
            {"30","Ruteo SF/UTP vertical abajo"},
            {"31","Ruteo SF/UTP horizontal hacia subida"},
            {"32","Ruteo SF/UTP exterior hacia pasamuro"},
            {"33","Ruteo SF/UTP interior hacia pasamuros"},
            {"34","Vista de Rack completo"},
            {"35","Vista de interconexión PoE"},
            {"36","Etiquetado tierra PoE (barra)"},
            {"37","Alimentación de PoE en rectificador"},
            {"38","Ubicación de PoE  y S.Supp en bandeja"},
            {"39","Etiquetados en puerto de PoE"},
            {"40","Etiquetados SF/UTP en S.Suppressor"},
            {"41","Etiquetados tierra S.Suppressor"},
            {"42","Instalación de CMM5 en rack"},
            {"43","Etiquetados de energía  (en equipo)"},
            {"44","Etiquetados tierra en equipo"},
            {"45","Etiquetados tierra en barra"},
            {"46","Panoramica de la torre."},
            {"47","Panorámica de la estación."},


    };

    int[] datosIMGPreview = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_3};

    int[] datosIMGCamera = {R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actade_instalacion_ptp_450);

        lvai4 = (ListView) findViewById(R.id.lv_ai4);

        if (ContextCompat.checkSelfPermission(ActadeInstalacion_PTP_450.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(ActadeInstalacion_PTP_450.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ActadeInstalacion_PTP_450.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }

        lvai4.setAdapter(new Adaptador3(this,datos,datosIMGPreview,datosIMGCamera));
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

            //Button btcapturar = (Button)vista.findViewById(R.id.bt_capturar);

            tvnumfot.setText(datosAd[position][0]);
            tvdescription.setText(datosAd[position][1]);

            ivpreview.setImageResource(datosIMGAd[position]);
            //ivfoto.setImageResource(datosIMGCameraAd[position]);

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
            //btcapturar.setTag(position);
            /*btcapturar.setOnClickListener(new View.OnClickListener() {

                @Override
                //onClick == tomarFoto
                public void onClick(View v) {
                    TomarFoto2();
                    //Intent intentF = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //startActivityForResult(intentF,0);
                }
            });*/
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
        */
    }
}