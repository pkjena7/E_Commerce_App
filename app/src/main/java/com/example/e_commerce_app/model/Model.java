package com.example.e_commerce_app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product")
public class Model {
    @PrimaryKey(autoGenerate = true)
    private int productId;
    int image;
    String name;
    int price;
    int quantity;

    public Model(int image, String name, int price, int quantity) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
