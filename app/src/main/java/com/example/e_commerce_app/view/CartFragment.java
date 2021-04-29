package com.example.e_commerce_app.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.e_commerce_app.R;
import com.example.e_commerce_app.adapter.CartAdapter;
import com.example.e_commerce_app.model.Model;

import java.util.List;


public class CartFragment extends Fragment {

    RecyclerView recyclerView;
    Context context;
    Fragment fragment;
    CartAdapter cartAdapter;
    List<Model> cartList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);

        context = getActivity();
        fragment = this;

        recyclerView = view.findViewById(R.id.cart_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        cartAdapter = new CartAdapter(context,cartList);
        recyclerView.setAdapter(cartAdapter);



        return  view;
    }
}