package com.danielchioro.lafinikeria.models;

import java.io.Serializable;

public class Food implements Serializable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private String name;
    private String description;
    private float price;

    public Food() {

    }

    public Food(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

}
