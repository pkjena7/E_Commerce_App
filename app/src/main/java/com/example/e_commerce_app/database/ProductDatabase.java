package com.example.e_commerce_app.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.e_commerce_app.R;
import com.example.e_commerce_app.dao.ProductDao;
import com.example.e_commerce_app.model.Model;
import com.example.e_commerce_app.view.RootsFragment;
import com.example.e_commerce_app.viewmodel.ProductViewModel;

import java.util.List;

@Database(entities = {Model.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {

//    public static final String DATABASE_NAME = "Product_Database";
//
//    public abstract ProductDao productDao();
//
//
//    public static volatile ProductDatabase INSTANCE;
//
//
//    public static synchronized ProductDatabase getInstance(Context context) {
//
//        if (INSTANCE == null) {
//
//            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ProductDatabase.class, DATABASE_NAME)
//                    .fallbackToDestructiveMigration()
//                    .addCallback(callback)
//                    .build();
//        }
//        return INSTANCE;
//    }
//
//    static Callback callback = new Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            new PopulateAsynTask(INSTANCE).execute();
//        }
//    };
//
//    static class PopulateAsynTask extends AsyncTask<Void, Void, Void> {
//        private ProductDao productDao;
//        ProductViewModel productViewModel;
//
//        PopulateAsynTask(ProductDatabase productDatabase) {
//            productDao = productDatabase.productDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            productDao.insert(productViewModel.getAllProducts().getValue());
//            return null;
//        }
//    }
}
