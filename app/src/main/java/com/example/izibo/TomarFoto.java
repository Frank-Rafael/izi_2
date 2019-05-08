package com.example.izibo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class TomarFoto extends AppCompatActivity {

    ImageView ivfoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        ivfoto.setImageBitmap(bitmap);
    }
}
