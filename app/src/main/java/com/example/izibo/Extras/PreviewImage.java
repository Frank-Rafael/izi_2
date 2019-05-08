package com.example.izibo.Extras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.izibo.R;

public class PreviewImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_image);

        ImageView ivpreimg = (ImageView)findViewById(R.id.iv_preimg);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            ivpreimg.setImageResource(bundle.getInt("IMG"));
        }
    }
}
