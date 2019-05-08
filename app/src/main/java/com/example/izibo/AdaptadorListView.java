package com.example.izibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.izibo.Extras.PreviewImage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class AdaptadorListView { //extends BaseAdapter  {

    /*private static LayoutInflater inflater = null;

    Context context;
    String[][] datosAd;
    int[] datosIMGAd;
    int[] datosIMGCameraAd;
    static final int REQUEST_IMAGE_CAPTURE=1;

    public AdaptadorListView(Context context, String[][] datosAdC, int[] datosIMGAdC, int[] datosIMGCameraAd){
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
        ImageView ivfoto = (ImageView) vista.findViewById(R.id.iv_foto);

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
        ivfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            //onClick == tomarFoto
            public void onClick(View v) {

                //Intent intentF = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult(intentF,0);
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
    }*/
}
