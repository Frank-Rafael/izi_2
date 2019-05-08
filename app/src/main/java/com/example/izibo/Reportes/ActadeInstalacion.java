package com.example.izibo.Reportes;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.izibo.Extras.PreviewImage;
import com.example.izibo.R;

import java.io.File;

//Acta ePMP10000

public class ActadeInstalacion extends AppCompatActivity {

    ListView lvai1;

    String[][] datos = {
            {"1","Número de serie del GPS"},
            {"2","Número de serie de Antena"},
            {"3","Número de serie de AP"},
            {"4","Número de serie POE"},
            {"5","Número de serie S. SUPPRESSOR INF. (S. Suppressor indoor)"},
            {"6","Vista Frontal GPS"},
            {"7","Vista Posterior GPS"},
            {"8","Conexión GPS - ePMP 1000"},
            {"9","Foto frontal de antena"},
            {"10","Estruct. donde se vea antena instalada (CON BRUJULA)"},
            {"11","Sellado"},
            {"12","Polarización"},
            {"13","Foto frontal de AP"},
            {"14","Estructura donde se vea AP instalado"},
            {"15","Sellado"},
            {"16","Cableado de Jumper"},
            {"17","Aterramiento AP"},
            {"18","Aterramiento AP lado BDT"},
            {"19","Sellado KIT de tierra alto (si aplica)"},
            {"20","Sellado KIT de tierra medio"},
            {"21","Sellado KIT de tierra bajo"},
            {"22","Sellado KIT de tierra Pasamuro"},
            {"23","Ruteo SF/UTP vertical superior"},
            {"24","Ruteo SF/UTP vertical abajo"},
            {"25","Ruteo SF/UTP horizontal hacia subida"},
            {"26","Ruteo SF/UTP exterior hacia pasamuros"},
            {"27","Ruteo SF/UTP en pasamuros"},
            {"28","BDT Pasamuro (conexiones en barra)"},
            {"29","BDT Pasamuro (recorrido vertical)"},
            {"30","Sellado de ductos en pasamuro."},
            {"31","Vista de Rack completo"},
            {"32","Vista interconexión AP en supresor"},
            {"33","Vista de conexiones del supresor"},
            {"34","Vista interconexion supresor y POE"},
            {"35","Aterramiento supresor"},
            {"36","Vista de equipos POE y S.Suppresor"},
            {"37","Etiquetados SF/UTP ODU - Supresor"},
            {"38","Etiquetados tierra Supresor - Barra"},
            {"39","Uso de terminales tipo manguito"},
            {"40","Vista de intercon. POE en router o Sw"},
            {"41","Vista de conexiones del POE"},
            {"42","Frontal rectificador y  barra de 0v"},
            {"43","Breakers Utilzados (Foto Zoom)"},
            {"44","Etiquetados energía (Rect)"},
            {"45","Etiquetados energía (POE)"},
            {"46","Etiquetados SF/UTP POE – Supresor"},
            {"47","Etiquetados tierra POE - Barra"},
            {"48","Panoramica Estacion / Torre"}
    };

    int[] datosIMGPreview = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1};

    int[] datosIMGCamera = {R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara,
            R.drawable.camara,R.drawable.camara,R.drawable.camara,R.drawable.camara};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actade_instalacion);

        lvai1 = (ListView) findViewById(R.id.lv_ai1);

        if (ContextCompat.checkSelfPermission(ActadeInstalacion.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(ActadeInstalacion.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ActadeInstalacion.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }

        lvai1.setAdapter(new Adaptador3(this,datos,datosIMGPreview,datosIMGCamera));
    }

    public class Adaptador3 extends BaseAdapter{

        private  LayoutInflater inflater = null;
        private File imageFile;

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

            //inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View vista = convertView;
            if(vista==null) {
                inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                vista = inflater.inflate(R.layout.molde_listview_documentacion, null);
            }
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
                    imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"test.jpg");
                    Uri tempuri=Uri.fromFile(imageFile);
                    intentF.putExtra(MediaStore.EXTRA_OUTPUT,tempuri);
                    startActivityForResult(intentF,0);
                }
                public void onActivityResult(int requestCode,int resulCode,Intent data){
                    if(requestCode==0){
                        switch (resulCode){
                            case Activity.RESULT_OK:
                                if(imageFile.exists()) {
                                    Log.d("Debug", "El archivo fue guardado en " + imageFile.getAbsolutePath());
                                   }
                                break;
                            case Activity.RESULT_CANCELED:
                                if(imageFile.exists())
                                    Log.d("Debug","Hubo un error al guardar");
                                break;
                            default:
                                break;

                        }

                    }
                }
            });
            return vista;
        }
/*
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            ivfoto.setImageBitmap(bitmap);
        }
*/

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



