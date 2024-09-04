package com.example.filmlercalisma.DAO;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.filmlercalisma.Object.Filmler;
import com.example.filmlercalisma.Object.Kategoriler;
import com.example.filmlercalisma.Object.Yonetmenler;

import java.util.ArrayList;

public class FilmlerDAO {
    @SuppressLint("Range")
    public ArrayList<Filmler> tumFilmler(VeritabaniYardimcisi veritabaniYardimcisi){
        ArrayList<Filmler> filmlerArrayList = new ArrayList<>();

        SQLiteDatabase db = veritabaniYardimcisi.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM filmler, kategoriler, yonetmenler WHERE filmler.kategori_id = kategoriler.kategori_id AND filmler.yonetmen_id = yonetmenler.yonetmen_id", null);
        while (cursor.moveToNext()){
            Kategoriler k = new Kategoriler(cursor.getInt(cursor.getColumnIndex("film_id")), cursor.getString(cursor.getColumnIndex("kategori_ad")));
            Yonetmenler y = new Yonetmenler(cursor.getInt(cursor.getColumnIndex("yonetmen_id")), cursor.getString(cursor.getColumnIndex("yonetmen_ad")));
            Filmler f = new Filmler(cursor.getInt(cursor.getColumnIndex("film_id")),
                    cursor.getString(cursor.getColumnIndex("film_ad")),
                    cursor.getInt(cursor.getColumnIndex("film_yil")),
                    cursor.getString(cursor.getColumnIndex("film_resim")), k, y);
            filmlerArrayList.add(f);
        }
        return filmlerArrayList;
    }
}
