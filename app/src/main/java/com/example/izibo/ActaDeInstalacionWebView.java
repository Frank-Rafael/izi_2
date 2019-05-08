package com.example.izibo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.File;

public class ActaDeInstalacionWebView extends AppCompatActivity {
    public static final int RequestPermissionCode = 123;
    public static final int FROM_CAMERA = 2;

    private static final String IMAGE_DIRECTORY_NAME = "MyN_Fotos";
    String mCurrentPhotoPath;

    WebView webView;
    WebSettings webSettings;

    File photoFile = null;

    private String itemIDSeleccionado = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acta_de_instalacion_web_view);
        webView = findViewById(R.id.webview2);

        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setTextZoom(100);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            webSettings.setAllowFileAccessFromFileURLs(true);
            webSettings.setAllowUniversalAccessFromFileURLs(true);
        }

        //String codeToLoad = content;
        String mime = "text/html";
        String encoding = "utf-8";
        webView.loadUrl("file:///android_asset/html/index.html");
    }

}
