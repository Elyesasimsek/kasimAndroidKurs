package com.example.a067kisileruygulamasimvvm.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.a067kisileruygulamasimvvm.data.entity.Kisiler;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface KisilerDAO {
    @Query("SELECT * FROM kisiler")
    Single<List<Kisiler>> tumKisiler();

    @Query("SELECT * FROM kisiler WHERE kisiAd like '%' || :aramaKelimesi || '%' ")
    Single<List<Kisiler>> kisiAra(String aramaKelimesi);

    @Delete
    Completable kisiSil(Kisiler kisi);

    @Insert
    Completable kisiEkle(Kisiler kisi);

    @Update
    Completable kisiGuncelle(Kisiler kisi);
}
