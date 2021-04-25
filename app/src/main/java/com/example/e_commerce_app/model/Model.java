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

    public Model(int image, String name, int price, int quantity) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
