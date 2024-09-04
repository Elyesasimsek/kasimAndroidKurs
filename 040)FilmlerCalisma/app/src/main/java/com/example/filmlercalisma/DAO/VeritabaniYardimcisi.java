package com.example.filmlercalisma.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VeritabaniYardimcisi extends SQLiteOpenHelper {

    public VeritabaniYardimcisi(@Nullable Context context) {
        super(context, "filmler.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS kategoriler(kategori_id INTEGER PRIMARY KEY AUTOINCREMENT, kategori_ad TEXT );");

        db.execSQL("CREATE TABLE IF NOT EXISTS yonetmenler(yonetmen_id INTEGER PRIMARY KEY AUTOINCREMENT, yonetmen_ad TEXT);");

        db.execSQL("CREATE TABLE IF NOT EXISTS filmler(film_id INTEGER PRIMARY KEY AUTOINCREMENT, film_ad TEXT, film_yil INTEGER, film_resim TEXT, kategori_id INTEGER, yonetmen_id INTEGER, FOREIGN KEY(kategori_id) REFERENCES kategoriler (kategoril_id), FOREIGN KEY (yonetmen_id) REFERENCES yonetmenler(yonetmen_id));");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS kategoriler");
        db.execSQL("DROP TABLE IF EXISTS yonetmenler ");
        db.execSQL("DROP TABLE IF EXISTS filmler");
        onCreate(db);

    }
}
