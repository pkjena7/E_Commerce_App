package com.example.e_commerce_app.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.e_commerce_app.R;
import com.example.e_commerce_app.adapter.VegetableAdapter;
import com.example.e_commerce_app.model.Model;

import java.util.List;


public class VegetablesFragment extends Fragment {

    RecyclerView recyclerView;
    Context context;
    ProgressBar progressBar;
    VegetableAdapter vegetableAdapter;
    Fragment fragment;
    List<Model> vegetableList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vegetables, container, false);

        context = getActivity();
        fragment = this;

        recyclerView = view.findViewById(R.id.vegetables_recycler);
        progressBar = view.findViewById(R.id.vegetables_progress_bar);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        vegetableAdapter = new VegetableAdapter(context,vegetableList);
        recyclerView.setAdapter(vegetableAdapter);

        return  view;
    }
}