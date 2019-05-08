package com.example.izibo.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "izibo_db";
    private final String TAG_DB = "DbHelper";
    private static int DATABASE_VERSION = 1;

    private static final String CREATE_ACTAS = "CREATE TABLE IF NOT EXISTS " + DbContract.ACTAS + "(" +
            DbContract.ACTAS_F1 + " integer," +
            DbContract.ACTAS_F2 + " text" +
            ");";

    private static final String CREATE_DATA_ACTAS = "CREATE TABLE IF NOT EXISTS " + DbContract.DATA_ACTAS + "(" +
            DbContract.DATA_ACTAS_F1 + " integer," +
            DbContract.DATA_ACTAS_F2 + " integer," +
            DbContract.DATA_ACTAS_F3 + " text," +
            DbContract.DATA_ACTAS_F4 + " text" +
            ");";

    private static final String CREATE_DATA_SEGURIDAD_CHARLA = "CREATE TABLE IF NOT EXISTS " + DbContract.DATA_SEGURIDAD_CHARLA + "(" +
            DbContract.DATA_SEGURIDAD_CHARLA_F1 + " integer," +
            DbContract.DATA_SEGURIDAD_CHARLA_F2 + " text," +
            DbContract.DATA_SEGURIDAD_CHARLA_F3 + " text," +
            DbContract.DATA_SEGURIDAD_CHARLA_F4 + " text," +
            DbContract.DATA_SEGURIDAD_CHARLA_F5 + " text," +
            DbContract.DATA_SEGURIDAD_CHARLA_F6 + " text," +
            DbContract.DATA_SEGURIDAD_CHARLA_F7 + " text," +
            DbContract.DATA_SEGURIDAD_CHARLA_F8 + " text," +
            DbContract.DATA_SEGURIDAD_CHARLA_F9 + " text, " +
            DbContract.DATA_SEGURIDAD_CHARLA_F10 + " text, " +
            DbContract.DATA_SEGURIDAD_CHARLA_F11 + " text, " +
            DbContract.DATA_SEGURIDAD_CHARLA_F12 + " text, " +
            DbContract.DATA_SEGURIDAD_CHARLA_F13 + " text, " +
            DbContract.DATA_SEGURIDAD_CHARLA_F14 + " text, " +
            DbContract.DATA_SEGURIDAD_CHARLA_F15 + " text " +
            ");";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_ACTAS);
        sqLiteDatabase.execSQL(CREATE_DATA_ACTAS);
        sqLiteDatabase.execSQL(CREATE_DATA_SEGURIDAD_CHARLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DbContract.ACTAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DbContract.DATA_ACTAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DbContract.DATA_SEGURIDAD_CHARLA);
        onCreate(sqLiteDatabase);
    }

    public void insertCameraOnActa(Integer id_acta, Integer id_dato, String codigo, String ruta_foto){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor verificar = db.rawQuery("SELECT "+DbContract.DATA_ACTAS_F4+" FROM "+DbContract.DATA_ACTAS+" WHERE "+
                DbContract.DATA_ACTAS_F1+" = "+id_acta+" AND "+DbContract.DATA_ACTAS_F2+" = "+id_dato, null);

        long count = verificar.getCount();

        if(count==0){
            ContentValues cv = new ContentValues();
            cv.put(DbContract.DATA_ACTAS_F1, id_acta);
            cv.put(DbContract.DATA_ACTAS_F2, id_dato);
            cv.put(DbContract.DATA_ACTAS_F3, codigo);
            cv.put(DbContract.DATA_ACTAS_F4, ruta_foto);

            long ins =  db.insert(DbContract.DATA_ACTAS, null, cv);
            Log.d(TAG_DB,"Insert-Path:"+ins);
        }else{

            ContentValues cv = new ContentValues();
            cv.put(DbContract.DATA_ACTAS_F4, ruta_foto);

            long upd = db.update(DbContract.DATA_ACTAS,cv,
                    DbContract.DATA_ACTAS_F1+"=? AND "+DbContract.DATA_ACTAS_F2+"=?",
                    new String[]{String.valueOf(id_acta),String.valueOf(id_dato)});

            Log.d(TAG_DB,"Update-Path:"+upd);

            String oldPath = "";

            while (verificar.moveToNext()) {
                try {
                    if( verificar.getString(0) != null ){
                        oldPath = verificar.getString(0);
                    }else{
                        oldPath = "";
                    }
                }catch( Exception e ){
                    Log.d("ITERATE ERROR", e.getMessage()  );
                }
            }

            if(!oldPath.equals("")){
                File imagefile = new File(oldPath);
                boolean deleted = imagefile.delete();
                Log.d("On-Update","Deleted:"+deleted);
            }

        }

        verificar.close();
        db.close();
    }

    public JSONArray getPhotosFromActa(int id_acta){

        SQLiteDatabase db = getWritableDatabase();

        String select = "SELECT "+DbContract.DATA_ACTAS_F2+","+DbContract.DATA_ACTAS_F3+","+DbContract.DATA_ACTAS_F4+" FROM "+DbContract.DATA_ACTAS;
        String where = " WHERE "+DbContract.DATA_ACTAS_F1+"="+id_acta;
        String qry = select + where;
        Cursor res = db.rawQuery(qry, null);
        int cc = res.getCount();

        JSONArray data = new JSONArray();

        if(cc > 0){

            try{
                while (res.moveToNext()) {
                    int totalColumn = res.getColumnCount();

                    JSONObject obj = new JSONObject();

                    for( int i=0 ;  i< totalColumn ; i++ ) {
                        if( res.getColumnName(i) != null ){

                            try {

                                if( res.getString(i) != null ){
                                    obj.put(res.getColumnName(i),res.getString(i));
                                }else{
                                    Log.d("ITERATE OTHER", res.getColumnName(i));
                                }
                            }catch( Exception e ){
                                Log.d("ITERATE ERROR", e.getMessage()  );
                            }
                        }
                    }
                    data.put(obj);
                }
            }finally {
                res.close();
            }
        }

        //Log.d(TAG_DB,"getPhotosFromActa="+data.toString()+"|cc="+data.length());
        return data;
    }

    public void insertDataATS(Integer id_acta_charla,String nombre_acta_seg_charla,String data_responsable,String data_empresa,String data_site,String data_nombre_1,String data_dni_1,String data_nombre_2,String data_dni_2,String data_nombre_3,String data_dni_3,String data_tema_ambiental,String data_tema_sst,String fecha_acta_seg_charla,String hora_acta_seg_charla)
    {

    }
}