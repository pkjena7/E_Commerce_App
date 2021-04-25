package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.e_commerce_app.model.Model;
import com.example.e_commerce_app.view.CartFragment;
import com.example.e_commerce_app.view.HomeFragment;
import com.example.e_commerce_app.viewmodel.ProductViewModel;
import com.example.e_commerce_app.viewmodel.RetrofitViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ProductViewModel productViewModel;
    RetrofitViewModel retrofitViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
 //       productViewModel.init(this.getApplication());
        retrofitViewModel = ViewModelProviders.of(this).get(RetrofitViewModel.class);

        bottomNavigationView = findViewById(R.id.button_nav);
//        bottomNavigationView.setSelectedItemId(R.id.home);

        Fragment selectedFragment;
        selectedFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, selectedFragment).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.home:
                        selectedFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, selectedFragment).commit();
                        return true;
                    case R.id.cart:
                        selectedFragment = new CartFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, selectedFragment).commit();
                        return true;
                }
                return true;
            }
        });

        retrofitViewModel.makeApiCall();

    }


//    public void itemclick(int position) {
//        productViewModel.getAllProducts().observe(this, new Observer<List<Model>>() {
//            @Override
//            public void onChanged(List<Model> list) {
//                CartFragment ldf = new CartFragment ();
//                Bundle args = new Bundle();
//                args.putString("YourKey", String.valueOf(list));
//                ldf.setArguments(args);
//
////Inflate the fragment
//                getSupportFragmentManager().beginTransaction().add(R.id.container, ldf).commit();
//            }
//        });
//    }


}