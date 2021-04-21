package com.example.e_commerce_app.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_roots, container, false);

        context = getActivity();
        fragment = this;

        recyclerView = view.findViewById(R.id.roots_recycler);
        progressBar = view.findViewById(R.id.root_progress_bar);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        initData();

        rootAdapter = new RootAdapter(context, itemlist);
        recyclerView.setAdapter(rootAdapter);


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
                    fetchdata();
                }
            }
        });


        return view;
    }

    private List<Model> fetchdata() {
        progressBar.setVisibility(View.VISIBLE);
        itemlist = new ArrayList<>();
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 10));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 90));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 180));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 108));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 109));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 104));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 103));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 102));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 101));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 100));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 107));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 109));
//        itemlist.add(new Model(R.drawable.ic_launcher_foreground, "Apple", 107));
//
//
//        rootAdapter.notifyDataSetChanged();
//        progressBar.setVisibility(View.GONE);
        return itemlist;
    }

    private List<Model> initData() {
        itemlist = new ArrayList<>();

        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));
        itemlist.add(new Model(R.drawable.ic_launcher_background, "Tamato", 20, 1));

        return itemlist;


    }


}