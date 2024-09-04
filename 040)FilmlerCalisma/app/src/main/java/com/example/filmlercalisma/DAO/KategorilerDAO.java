package com.example.filmlercalisma.DAO;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.filmlercalisma.Object.Kategoriler;

import java.util.ArrayList;

public class KategorilerDAO {
    @SuppressLint("Range")
    public ArrayList<Kategoriler> tumKategoriler(VeritabaniYardimcisi veritabaniYardimcisi){
        ArrayList<Kategoriler> kategorilerArrayList = new ArrayList<>();

        SQLiteDatabase db = veritabaniYardimcisi.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM kategoriler", null);
        while (cursor.moveToNext()){
            Kategoriler k;
            k = new Kategoriler(cursor.getInt(cursor.getColumnIndex("kategori_id")), cursor.getString(cursor.getColumnIndex("kategori_ad")));

            kategorilerArrayList.add(k);
        }
        return kategorilerArrayList;
    }
}
