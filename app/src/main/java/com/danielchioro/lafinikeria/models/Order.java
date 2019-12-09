package com.danielchioro.lafinikeria.models;

public class Order {

    public Order(String orderId, String detail, String ammount) {
        this.orderId = orderId;
        this.detail = detail;
        this.ammount = ammount;
    }

    private String orderId;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAmmount() {
        return ammount;
    }

    public void setAmmount(String ammount) {
        this.ammount = ammount;
    }

    private String detail;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    private String ammount;
}
