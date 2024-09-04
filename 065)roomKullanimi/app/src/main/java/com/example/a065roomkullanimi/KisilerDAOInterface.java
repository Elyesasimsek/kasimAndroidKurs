package com.example.a065roomkullanimi;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface KisilerDAOInterface {
    @Query("SELECT * FROM kisiler")
    Single<List<Kisiler>> tumKisiler();

    @Insert
    Completable kisiEkle(Kisiler kisi);

    @Update
    Completable kisiGuncelle(Kisiler kisi);

    @Delete
    Completable kisiSil(Kisiler kisi);

    @Query("SELECT * FROM kisiler ORDER BY RANDOM() LIMIT 2")
    Single<List<Kisiler>> rastgele1KisiGetir();

    @Query("SELECT * FROM kisiler WHERE kisiAd like '%' || :aramaKelimesi ||  '%' ")
    Single<List<Kisiler>> kisiAra(String aramaKelimesi);

    @Query("SELECT * FROM kisiler WHERE kisiId = :kisiId")
    Single<Kisiler> kisiGetir(int kisiId);

    @Query("SELECT count(*) FROM kisiler WHERE kisiAd = :kisiAd")
    Single<Integer> kayitKontrol(String kisiAd);
}
