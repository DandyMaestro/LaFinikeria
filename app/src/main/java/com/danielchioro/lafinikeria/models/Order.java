package com.danielchioro.lafinikeria.models;

import java.util.List;

public class Order {

    public Order(String orderId, List<Food> detail, float ammount) {
        this.orderId = orderId;
        this.detail = detail;
        this.ammount = ammount;
    }

    public Order() {

    }

    private String orderId;

    public List<Food> getDetail() {
        return detail;
    }

    public void setDetail(List<Food> detail) {
        this.detail = detail;
    }

    public float getAmmount() {
        return ammount;
    }

    public void setAmmount(float ammount) {
        this.ammount = ammount;
    }

    private List<Food> detail;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    private float ammount;
}
