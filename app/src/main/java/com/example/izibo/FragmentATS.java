package com.example.izibo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentATS.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentATS#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentATS extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentATS() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentATS.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentATS newInstance(String param1, String param2) {
        FragmentATS fragment = new FragmentATS();
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

    View vista;
    WebView webViewATS;
    WebSettings webSettingsATS;


    @SuppressLint("JavascriptInterface")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_ats, container, false);

        webViewATS = vista.findViewById(R.id.webview3);

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



        return vista;
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
