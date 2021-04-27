package com.example.e_commerce_app.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.e_commerce_app.R;
import com.example.e_commerce_app.adapter.RootAdapter;
import com.example.e_commerce_app.model.Model;
import com.example.e_commerce_app.viewmodel.ProductViewModel;
import com.example.e_commerce_app.viewmodel.RetrofitViewModel;

import java.util.ArrayList;
import java.util.List;


public class RootsFragment extends Fragment {

    RecyclerView recyclerView;
    Context context;
    RootAdapter rootAdapter;
    Fragment fragment;
    List<Model> itemlist;
    Boolean isScrolling = false;
    int currentitems, scrolledItems, totalitems;
    ProgressBar progressBar;
    private RetrofitViewModel retrofitViewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_roots, container, false);

        context = getActivity();
        fragment = this;

        recyclerView = view.findViewById(R.id.roots_recycler);
        progressBar = view.findViewById(R.id.root_progress_bar);

        //retrofitViewModel = ViewModelProviders.of(this).get(RetrofitViewModel.class);
        retrofitViewModel = new ViewModelProvider(this).get(RetrofitViewModel.class);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

//        initData();
        retrofitViewModel.makeApiCall();

        rootAdapter = new RootAdapter(context, itemlist);
        recyclerView.setAdapter(rootAdapter);


        retrofitViewModel.getProductListObserver().observe(getViewLifecycleOwner(), new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> list) {
                if (list!=null)
                {
                    itemlist = list;
                    rootAdapter.setRootList(itemlist);
                }
            }
        });

//        retrofitViewModel.makeApiCall();

        //  pagination start

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentitems = gridLayoutManager.getChildCount();
                totalitems = gridLayoutManager.getItemCount();
                scrolledItems = gridLayoutManager.findFirstVisibleItemPosition();

                if (isScrolling && (currentitems + scrolledItems == totalitems)) {
                    isScrolling = false;
//                    fetchdata();
                }
            }
        });


        // pagination end


        return view;
    }



}