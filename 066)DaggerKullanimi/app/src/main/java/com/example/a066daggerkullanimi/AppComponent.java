package com.example.a066daggerkullanimi;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    public void inject(MainActivity activity);
}
