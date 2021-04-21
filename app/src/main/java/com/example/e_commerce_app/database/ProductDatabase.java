package com.example.e_commerce_app.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.e_commerce_app.dao.ProductDao;
import com.example.e_commerce_app.model.Model;

@Database(entities = {Model.class},version = 1)
public abstract class ProductDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "Product Database";

    public abstract ProductDao productDao();

    public static volatile ProductDatabase INSTANCE;

    public static ProductDatabase getInstance(Context context) {

        if (INSTANCE == null) {
            synchronized (ProductDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, ProductDatabase.class, DATABASE_NAME)
                            .addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsynTask(INSTANCE);
        }
    };

    static class PopulateAsynTask extends AsyncTask {
        private ProductDao productDao;

        PopulateAsynTask(ProductDatabase productDatabase) {
            productDao = productDatabase.productDao();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            productDao.deleteAll();
            return null;
        }
    }
}
