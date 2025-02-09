package com.example.a067kisileruygulamasimvvm.di;

import android.content.Context;

import androidx.room.Room;

import com.example.a067kisileruygulamasimvvm.data.repo.KisilerDAORepository;
import com.example.a067kisileruygulamasimvvm.room.KisilerDAO;
import com.example.a067kisileruygulamasimvvm.room.Veritabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public KisilerDAORepository provideKisilerDAORepostitory(KisilerDAO kdao){
        return new KisilerDAORepository(kdao);
    }

    @Provides
    @Singleton
    public KisilerDAO provideKisilerDAO(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context, Veritabani.class, "rehber.sqlite").createFromAsset("rehber.sqlite").build();
        return vt.getKisilerDAO();
    }
}
