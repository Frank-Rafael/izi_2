package com.example.izibo;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DocumentacionSeguridad_ATS extends AppCompatActivity {

    WebView webViewATS;
    WebSettings webSettingsATS;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentacion_seg_ats);

        webViewATS = findViewById(R.id.webview3);

        webSettingsATS = webViewATS.getSettings();
        webSettingsATS.setJavaScriptEnabled(true);
        webSettingsATS.setTextZoom(100);
        webSettingsATS.setJavaScriptCanOpenWindowsAutomatically(true);
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            webSettingsATS.setAllowFileAccessFromFileURLs(true);
            webSettingsATS.setAllowUniversalAccessFromFileURLs(true);
        }

        //String codeToLoad = content;
        String mime = "text/html";
        String encoding = "utf-8";
        webViewATS.loadUrl("file:///android_asset/html/vistas/formato_ATS.html");

        webViewATS.addJavascriptInterface(this, "Android");
        webViewATS.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog dialog = new AlertDialog.Builder(view.getContext()).
                        setTitle("M&N Movil").
                        setMessage(message).
                        setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //do nothing
                                result.confirm();
                            }
                        }).create();
                dialog.show();
                //result.confirm();

                return true;
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, final JsResult result){
                AlertDialog dialog = new AlertDialog.Builder(view.getContext()).
                        setTitle("Nexum Móvil").
                        setMessage(message).
                        setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //do nothing
                                result.confirm();
                            }
                        }).setNegativeButton("Cancelar",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do nothing
                        result.cancel();
                    }
                }).create();
                dialog.show();
                //result.confirm();
                return true;
            }

            @Override
            public void onProgressChanged (WebView view,  int progress){

            }

        });
    }

    @JavascriptInterface
    public void capturarFirma(){

    }
}

