package com.example.myapplication.Models;

public class OrdersModel {
    int orderimage;

    public OrdersModel() {

    }

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }

    public String getSolditemname() {
        return solditemname;
    }

    public void setSolditemname(String solditemname) {
        this.solditemname = solditemname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    String solditemname;
    String price;

    public OrdersModel(int orderimage, String solditemname, String price, String orderNumber) {
        this.orderimage = orderimage;
        this.solditemname = solditemname;
        this.price = price;
        this.orderNumber = orderNumber;
    }

    String orderNumber;

}
