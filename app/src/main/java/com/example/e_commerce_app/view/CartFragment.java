package com.example.e_commerce_app.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.e_commerce_app.R;


public class CartFragment extends Fragment {

TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);

        textView=view.findViewById(R.id.cartview);

        String value = getArguments().getString("YourKey");

        textView.setText(value);

        return  view;
    }
}