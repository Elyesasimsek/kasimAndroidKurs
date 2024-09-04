package com.example.a060filmleruygulamaretrofit2;

public class ApiUtils {
    public static  final  String BASE_URL = "https://elyesasimsek.com/";
    public static  FilmlerDAOInterface getFilmlerDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(FilmlerDAOInterface.class);
    }
}
