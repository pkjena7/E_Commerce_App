package com.example.e_commerce_app.network;

import com.example.e_commerce_app.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("api/v1/products")
    Call<List<Model>> getProductDetails(@Query("_quantity=500") int quantity);
}
