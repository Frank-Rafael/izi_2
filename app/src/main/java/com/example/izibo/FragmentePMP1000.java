package com.example.izibo;

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
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.izibo.Database.DbHelper;
import com.example.izibo.Extras.PreviewImage;

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

import static android.Manifest.permission.CAMERA;
import static java.lang.Integer.parseInt;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentePMP1000.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentePMP1000#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentePMP1000 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentePMP1000() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentePMP1000.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentePMP1000 newInstance(String param1, String param2) {
        FragmentePMP1000 fragment = new FragmentePMP1000();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public static final int RequestPermissionCode = 123;
    public static final int FROM_CAMERA = 2;

    private static final String IMAGE_DIRECTORY_NAME = "MyN_Fotos";
    String mCurrentPhotoPath;

    String codigoGlobal = "";

    View vista;
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
            R.drawable.img_3,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3};

    File photoFile = null;

    private String itemIDSeleccionado = "";

    DbHelper db;
    String[] actas = null;


    @SuppressLint("JavascriptInterface")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_epmp1000, container, false);

        webView = vista.findViewById(R.id.webview3);

        Resources res = getResources();
        actas = res.getStringArray(R.array.string_array_actas);

        //Instanciamos la base de datos
        db = new DbHelper(getActivity().getApplicationContext());

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
        webView.loadUrl("file:///android_asset/html/vistas/actadeInstalacion_ePMP_1000.html");

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

        return vista;
    }



    @JavascriptInterface
    public void capturarFirma() {

        Intent intent = new Intent(getActivity().getApplicationContext(), com.example.izibo.CapturarFirma.class);
        getActivity().getApplicationContext().startActivity(intent);
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
        Intent intentImgPre = new Intent(getActivity().getApplicationContext(), PreviewImage.class);
        //intentImgPre.putExtra("IMG",itemID);
        intentImgPre.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intentImgPre.putExtra("IMG",datosIMGPreview[parseInt(itemID)-1]);
        getActivity().getApplicationContext().startActivity(intentImgPre);
    }

    private void captureImage() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getApplicationContext().getPackageManager()) != null) {
            // Create the File where the photo should go
            try {

                photoFile = createImageFile();
                Log.i("WebViewFragment",photoFile.getAbsolutePath());

                // Continue only if the File was successfully created
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(getActivity().getApplicationContext(), "com.example.izibo.fileprovider", photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, FROM_CAMERA);
                }
            } catch (Exception ex) {
                Toast.makeText(getActivity().getApplicationContext(), "Ocurrió un error", Toast.LENGTH_SHORT).show();
                // Error occurred while creating the File
                Log.d("WebViewFragment",""+ex.getMessage());
            }

        }else{
            Log.d("WebViewFragment","Null");
        }

    }


    public void loadPicture(final String itemID, final String path){

        getActivity().runOnUiThread(new Runnable() {
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
            Toast.makeText(getActivity().getApplicationContext(), "Camara no disponible", Toast.LENGTH_SHORT).show();
            Log.d("WebView","Camera is not available."+e.toString());
        }
    }

    private File createImageFile4(){
        // External sdcard location
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), IMAGE_DIRECTORY_NAME);
        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Toast.makeText(getActivity().getApplicationContext(), "No se puede crear el directorio", Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        String imgName = "IMG_TEST";
        return new File(mediaStorageDir.getPath() + File.separator + imgName);
    }

    private File createImageFile() throws IOException {

        String imgName = "IMG_TEST_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
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
        int result = ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), CAMERA);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(getActivity(), new String[]{CAMERA}, RequestPermissionCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_CANCELED) {
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
                    paintText.setTextSize(convertToPixels(getActivity().getApplicationContext(),7));
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
                    paintText2.setTextSize(convertToPixels(getActivity().getApplicationContext(),7));
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
                int id_acta = Arrays.asList(actas).indexOf("ePMP_1000");
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
