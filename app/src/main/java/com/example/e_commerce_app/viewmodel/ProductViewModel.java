package com.example.e_commerce_app.viewmodel;

import android.app.Application;
import android.view.Display;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_commerce_app.model.Model;
import com.example.e_commerce_app.repo.ProductRepository;

import java.util.List;

public class ProductViewModel extends ViewModel {

    ProductRepository productRepository;
    LiveData<List<Model>> getAllProducts;

    public ProductViewModel(@NonNull Application application) {
        super();
        productRepository = new ProductRepository(application);
        getAllProducts = productRepository.getAllProducts();
    }

    public void insert(List<Model> list)
    {
        productRepository.insert(list);
    }

    public LiveData<List<Model>> getAllProducts()
    {
        return getAllProducts;
    }
}
