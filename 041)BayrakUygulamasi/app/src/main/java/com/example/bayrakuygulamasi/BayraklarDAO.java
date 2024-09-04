package com.example.bayrakuygulamasi;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BayraklarDAO {
    public ArrayList<Bayraklar> rastgeleGetir(Veritabani vt){
        ArrayList<Bayraklar> bayraklarArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 7", null);

        while (cursor.moveToNext()){
            @SuppressLint("Range") Bayraklar b = new Bayraklar(cursor.getInt(cursor.getColumnIndex("bayrakId")),
                    cursor.getString(cursor.getColumnIndex("bayrakAd")),
                    cursor.getString(cursor.getColumnIndex("bayrakResim")));

            bayraklarArrayList.add(b);
        }
        return  bayraklarArrayList;
    }

    public ArrayList<Bayraklar> rastgele3YanlisGetir(Veritabani vt, int bayrakId){
        ArrayList<Bayraklar> bayraklarArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM bayraklar WHERE bayrakId != " + bayrakId +  " ORDER BY RANDOM() LIMIT 3", null);

        while (cursor.moveToNext()){
            @SuppressLint("Range") Bayraklar b = new Bayraklar(cursor.getInt(cursor.getColumnIndex("bayrakId")),
                    cursor.getString(cursor.getColumnIndex("bayrakAd")),
                    cursor.getString(cursor.getColumnIndex("bayrakResim")));

            bayraklarArrayList.add(b);
        }
        return  bayraklarArrayList;
    }
}
