package com.example.e_commerce_app.repo;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRepository {

    public static String BASE_URL = "https://fakerapi.it/"; //  api/v1/products?_quantity=500

    private static Retrofit retrofit;



    public static Retrofit getRetroClient()
    {
        if (retrofit==null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
