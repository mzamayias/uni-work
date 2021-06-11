package com.company.Model;

public class Order {
    private int orderID;
    private int customerID;
    private int inventoryID;
    private int quantity;
    private int price;

    public Order(int orderID, int customerID, int inventoryID, int quantity, int price) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.inventoryID = inventoryID;
        this.quantity = quantity;
        this.price = price;
    }

    public Order() {
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
