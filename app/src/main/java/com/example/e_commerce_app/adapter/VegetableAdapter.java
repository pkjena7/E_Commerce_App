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

public class VegetableAdapter extends RecyclerView.Adapter<VegetableAdapter.ViewHolder> {

    Context context;
    List<Model> vegetableList;

    public VegetableAdapter(Context context, List<Model> vegetableList) {
        this.context = context;
        this.vegetableList = vegetableList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vegetables_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView_name.setText(vegetableList.get(position).getData().getName());
        holder.textView_price.setText(Float.toString(vegetableList.get(position).getData().getPrice()));
        holder.textView_quantity.setText(Integer.toString(vegetableList.get(position).getQuantity()));
        Glide.with(context).load(vegetableList.get(position).getData().getImage()).into(holder.imageView);

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
        if (vegetableList != null)
        {
            return this.vegetableList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView_name, textView_price, textView_quantity;
        Button button_addtocart, button_increment, button_decrement;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.vegetable_image);
            textView_name = itemView.findViewById(R.id.vegetable_name);
            textView_price = itemView.findViewById(R.id.vegetable_price);
            textView_quantity = itemView.findViewById(R.id.vegetable_quantity);
            button_addtocart = itemView.findViewById(R.id.vegetable_addtocart);
            button_increment = itemView.findViewById(R.id.vegetable_increment);
            button_decrement = itemView.findViewById(R.id.vegetable_decrement);

        }
    }

}
