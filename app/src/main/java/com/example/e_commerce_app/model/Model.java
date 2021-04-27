package com.example.e_commerce_app.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import javax.xml.namespace.QName;

import kotlin.jvm.Synchronized;

@Entity(tableName = "product")
public class Model {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int productId;

    @ColumnInfo(name = "image")
    @SerializedName("image")
    int image;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    String name;

    @ColumnInfo(name = "price")
    @SerializedName("upc")
    int price;

    @ColumnInfo(name = "quantity")
    int quantity;


    @SerializedName("data")
    private Data data;


    public Model(Data data,int quantity) {
        this.data = data;
        this.quantity = quantity;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
