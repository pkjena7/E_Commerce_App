package com.example.e_commerce_app.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_commerce_app.model.Model;
import com.example.e_commerce_app.network.ApiRequest;
import com.example.e_commerce_app.repo.RetrofitRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitViewModel extends ViewModel {

    private MutableLiveData<List<Model>> productList;

    public RetrofitViewModel() {
        productList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Model>> getProductListObserver() {
        return productList;
    }

    public void makeApiCall() {
        ApiRequest apiRequest = RetrofitRepository.getRetroClient().create(ApiRequest.class);
        Call<List<Model>> call = apiRequest.getProductDetails(500);
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                productList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                productList.postValue(null);
            }
        });
    }
}
