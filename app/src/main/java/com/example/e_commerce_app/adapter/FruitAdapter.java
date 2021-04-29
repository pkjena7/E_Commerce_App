package com.example.e_commerce_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_commerce_app.R;
import com.example.e_commerce_app.model.Model;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    Context context;
    List<Model> itemlist;

    public FruitAdapter(Context context, List<Model> itemlist) {
        this.context = context;
        this.itemlist = itemlist;
    }

    @NonNull
    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruits_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.ViewHolder holder, int position) {
        holder.textView_name.setText(itemlist.get(position).getData().getName());
        holder.textView_price.setText(Float.toString(itemlist.get(position).getData().getPrice()));
        holder.textView_quantity.setText(Integer.toString(itemlist.get(position).getQuantity()));
        Glide.with(context).load(itemlist.get(position).getData().getImage()).into(holder.imageView);

        holder.button_increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(holder.textView_quantity.getText().toString());
                quantity++;
                holder.textView_quantity.setText(Integer.toString(quantity));
            }
        });

        holder.button_decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(holder.textView_quantity.getText().toString());
                if (quantity>1)
                {
                    quantity--;
                    holder.textView_quantity.setText(Integer.toString(quantity));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
       if (this.itemlist != null)
       {
           return this.itemlist.size();
       }
       return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView_name, textView_price, textView_quantity;
        Button button_addtocart, button_increment, button_decrement;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.fruit_image);
            textView_name = itemView.findViewById(R.id.fruit_name);
            textView_price = itemView.findViewById(R.id.fruit_price);
            textView_quantity = itemView.findViewById(R.id.fruit_quantity);
            button_addtocart = itemView.findViewById(R.id.fruit_addtocart);
            button_increment = itemView.findViewById(R.id.fruit_increment);
            button_decrement = itemView.findViewById(R.id.fruit_decrement);
        }
    }
}
