package com.company.Model;

public class Inventory {
    private int inventoryID;
    private String category;
    private String description;
    private int price;
    private int quantity;

    public Inventory(int inventoryID, String category, String description, int price, int quantity) {
        this.inventoryID = inventoryID;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Inventory() {
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
