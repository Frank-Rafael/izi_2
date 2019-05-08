package com.example.izibo.Reportes;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.izibo.AdaptadorListView;
import com.example.izibo.Database.DbHelper;
import com.example.izibo.Extras.PreviewImage;
import com.example.izibo.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static android.Manifest.permission.CAMERA;
import static android.support.v4.app.ActivityCompat.startActivityForResult;
import static java.lang.Integer.parseInt;

//Acta IIBB (Force 180)


public class ActadeInstalacion2 extends AppCompatActivity {

    public static final int RequestPermissionCode = 123;
    public static final int FROM_CAMERA = 2;

    private static final String IMAGE_DIRECTORY_NAME = "MyN_Fotos";
    String mCurrentPhotoPath;

    String codigoGlobal = "";

    WebView webView;
    WebSettings webSettings;

    //Context context= this;
    int[] datosIMGPreview = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,
            R.drawable.img_2};

    File photoFile = null;

    private String itemIDSeleccionado = "";

    DbHelper db;
    String[] actas = null;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actade_instalacion2);

        //Asignamos la variable global con el valor de las actas
        Resources res = getResources();
        actas = res.getStringArray(R.array.string_array_actas);

        //Instanciamos la base de datos
        db = new DbHelper(getApplicationContext());

        webView = findViewById(R.id.webview);

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
        webView.loadUrl("file:///android_asset/html/vistas/actadeInstalacion_Force_180.html");

        webView.addJavascriptInterface(this, "Android");
        webView.setWebChromeClient(new WebChromeClient() {

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
    public void capturarFirma() {

        Intent intent = new Intent(getApplicationContext(), com.example.izibo.CapturarFirma.class);
        getApplicationContext().startActivity(intent);
    }

    @JavascriptInterface
    public String loadPhotosFromDB() {
        //Cargamos las rutas de las fotos del acta ePMP_1000
        return db.getPhotosFromActa(Arrays.asList(actas).indexOf("ePMP_1000")).toString();
    }

    @JavascriptInterface
    public void capturarFoto(String itemID, String codigo) {

        Log.d("PRUEBA","itemID is:"+itemID+" | codigo="+codigo);
        itemIDSeleccionado = itemID;
        codigoGlobal=codigo;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkCameraPermission()){
                //Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult(takePicture, FROM_CAMERA);
                //FROM CAMERA
                captureImage();
            }else{
                requestPermission();
            }

        } else {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                captureImage();
            }
            else{
                captureImage2();
            }

            //Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //startActivityForResult(takePicture, FROM_CAMERA);
        }

    }

    @JavascriptInterface
    public void cargarImgPrevia(String itemID){

        Log.d("idItem","Is:"+itemID);
        Intent intentImgPre = new Intent(getApplicationContext(), PreviewImage.class);
        //intentImgPre.putExtra("IMG",itemID);
        intentImgPre.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intentImgPre.putExtra("IMG",datosIMGPreview[parseInt(itemID)-1]);
        getApplicationContext().startActivity(intentImgPre);
    }

    private void captureImage() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
            // Create the File where the photo should go
            try {

                photoFile = createImageFile();
                Log.i("WebViewFragment",photoFile.getAbsolutePath());

                // Continue only if the File was successfully created
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(getApplicationContext(), "com.example.izibo.fileprovider", photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, FROM_CAMERA);
                }
            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT).show();
                // Error occurred while creating the File
                Log.d("WebViewFragment",""+ex.getMessage());
            }

        }else{
            Log.d("WebViewFragment","Null");
        }

    }


    public void loadPicture(final String itemID, final String path){

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("javascript:cargarFotoCapturada('"+itemID+"','"+path+"');");
            }
        });

    }

    /* Capture Image function for 4.4.4 and lower. Not tested for Android Version 3 and 2 */
    private void captureImage2() {

        try {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            photoFile = createImageFile4();
            if(photoFile!=null)
            {
                Log.i("WebViewFrament",photoFile.getAbsolutePath());
                Uri photoURI  = Uri.fromFile(photoFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(cameraIntent, FROM_CAMERA);
            }
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Camara no disponible", Toast.LENGTH_SHORT).show();
            Log.d("WebView","Camera is not available."+e.toString());
        }
    }

    private File createImageFile4(){
        // External sdcard location
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), IMAGE_DIRECTORY_NAME);
        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Toast.makeText(getApplicationContext(), "No se puede crear el directorio", Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        String imgName = "IMG_TEST";
        return new File(mediaStorageDir.getPath() + File.separator + imgName);
    }

    private File createImageFile() throws IOException {

        String imgName = "IMG_TEST_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imgName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        Log.d("PHOTO","createImageFile()");
        return image;
    }

    public boolean checkCameraPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, RequestPermissionCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }

        if (requestCode == FROM_CAMERA) {

            if(resultCode == Activity.RESULT_OK){

                String filepath = photoFile.getAbsolutePath();
                File imagefile = new File(filepath);
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(imagefile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                Bitmap bm1 = null;
                Bitmap newBitmap = null;
                String textoEnImagenC = codigoGlobal;
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String textoEnImagen = dateFormat.format(date);

                bm1 = BitmapFactory.decodeStream(fis);
                Bitmap.Config config = bm1.getConfig();
                if (config == null) {
                    config = Bitmap.Config.ARGB_8888;
                }
                newBitmap = Bitmap.createBitmap(bm1.getWidth(), bm1.getHeight(), config);
                Canvas canvas = new Canvas(newBitmap);
                canvas.drawBitmap(bm1, 0, 0, null);

                Paint paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
                paintText.setColor(Color.WHITE);
                paintText.setTextSize(120);
                paintText.setStyle(Paint.Style.FILL);
                //paintText.setShadowLayer(10f, 10f, 10f, Color.BLACK);
                Rect textRect = new Rect();
                paintText.getTextBounds(textoEnImagen, 0, textoEnImagen.length(), textRect);
                if(textRect.width() >= (canvas.getWidth() - 4))
                    paintText.setTextSize(convertToPixels(getApplicationContext(),7));
                //int xPos = (canvas.getWidth() / 3) - 2;
                //int yPos = (int) ((canvas.getHeight() / 2) - ((paintText.descent() + paintText.ascent()) / 2)) ;
                int xPos = (canvas.getWidth() - textRect.width() - 150);
                int yPos = ((canvas.getHeight() - 100));
                canvas.drawText(textoEnImagen, xPos, yPos, paintText);

                Paint paintText2 = new Paint(Paint.ANTI_ALIAS_FLAG);
                paintText2.setColor(Color.WHITE);
                paintText2.setTextSize(120);
                paintText2.setStyle(Paint.Style.FILL);
                //paintText.setShadowLayer(10f, 10f, 10f, Color.BLACK);
                Rect textRect2 = new Rect();
                paintText2.getTextBounds(textoEnImagenC, 0, textoEnImagenC.length(), textRect2);
                if(textRect2.width() >= (canvas.getWidth() - 4))
                    paintText2.setTextSize(convertToPixels(getApplicationContext(),7));
                //int xPos = (canvas.getWidth() / 3) - 2;
                //int yPos = (int) ((canvas.getHeight() / 2) - ((paintText.descent() + paintText.ascent()) / 2)) ;
                int xPos2 = (canvas.getWidth() - textRect2.width() - 150);
                int yPos2 = ((canvas.getHeight() - 300));
                canvas.drawText(textoEnImagenC, xPos2, yPos2, paintText2);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                newBitmap.compress(Bitmap.CompressFormat.JPEG, 100 , baos);

                boolean deleted = imagefile.delete();
                Log.d("On-Compress","Deleted:"+deleted);

                File f = new File(photoFile.getAbsolutePath());
                try {

                    if(f.createNewFile()){
                        //write the bytes in file
                        FileOutputStream fo = new FileOutputStream(f);
                        fo.write(baos.toByteArray());
                        fo.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //DB-Action : Guardar Ruta de la foto
                int id_acta = Arrays.asList(actas).indexOf("Force_180");
                db.insertCameraOnActa(id_acta, Integer.valueOf(itemIDSeleccionado),codigoGlobal,photoFile.getAbsolutePath());

                loadPicture(itemIDSeleccionado,photoFile.getAbsolutePath());

            }else{
                Log.d("FROM_CAMERA","Ocurrio un error");
            }
        }
    }

    public static int convertToPixels(Context context, int nDP) {
        final float conversionScale = context.getResources().getDisplayMetrics().density;
        return (int) ((nDP * conversionScale) + 0.5f) ;
    }

}