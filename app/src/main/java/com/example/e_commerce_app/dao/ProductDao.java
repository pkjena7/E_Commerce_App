package com.example.e_commerce_app.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.e_commerce_app.model.Model;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Model> itemlist);
    @Query("SELECT * FROM PRODUCT")
    LiveData<List<Model>> getAllProducts();

    @Query("DELETE  FROM PRODUCT")
    void deleteAll();
}
