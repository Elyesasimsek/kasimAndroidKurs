package com.example.a068kisileruygulamasimvvmretrofit2.di;

import com.example.a068kisileruygulamasimvvmretrofit2.Retrofit.ApiUtils;
import com.example.a068kisileruygulamasimvvmretrofit2.Retrofit.KisilerDAO;
import com.example.a068kisileruygulamasimvvmretrofit2.data.repo.KisilerDAORepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public KisilerDAORepository provideKisilerDAORepository(KisilerDAO kdao){
        return new KisilerDAORepository(kdao);
    }

    @Provides
    @Singleton
    public KisilerDAO provideKisilerDAO(){
        return ApiUtils.getKisilerDAO();
    }
}
