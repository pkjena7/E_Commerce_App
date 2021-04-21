package com.example.e_commerce_app.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.e_commerce_app.dao.ProductDao;
import com.example.e_commerce_app.database.ProductDatabase;
import com.example.e_commerce_app.model.Model;

import java.util.List;

public class ProductRepository {

    private ProductDatabase database;
    private LiveData<List<Model>> getAllProducts;

    public  ProductRepository(Application application)
    {
        database = ProductDatabase.getInstance(application);
        getAllProducts = database.productDao().getAllProducts();

    }

    public void insert(List<Model> productList)
    {
        new InsertAsynTask(database).execute(productList);
    }

    public LiveData<List<Model>> getAllProducts()
    {
        return getAllProducts;
    }

    static class InsertAsynTask extends AsyncTask<List<Model>,Void,Void>
    {

        private ProductDao productDao;
        public InsertAsynTask(ProductDatabase productDatabase)
        {
            productDao  = productDatabase.productDao();
        }

        @Override
        protected Void doInBackground(List<Model>... lists) {
            productDao.insert(lists[0]);
            return null;
        }
    }
}
