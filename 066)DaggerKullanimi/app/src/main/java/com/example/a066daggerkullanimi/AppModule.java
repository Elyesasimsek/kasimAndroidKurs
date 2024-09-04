package com.example.a066daggerkullanimi;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    public Adres providesAdres(){
        return new Adres("Merkez/SİVAS");
    }
}
