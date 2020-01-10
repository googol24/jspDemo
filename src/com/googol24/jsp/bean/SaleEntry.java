package com.googol24.jsp.bean;

public class SaleEntry {
    private String itemId = "unknown";
    private double discountCode = 1.0d;
    private int numItems = 0;

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        if (itemId != null) {
            this.itemId = itemId;
        } else {
            this.itemId = "unknown";
        }
    }

    public double getDiscountCode() {
        return this.discountCode;
    }

    public void setDiscountCode(double discount) {
        this.discountCode = discount;
    }

    public int getNumItems() {
        return this.numItems;
    }

    public void setNumItems(int num) {
        this.numItems = num;
    }

    public double getItemCost() {
        double cost;

        if (itemId.equals("a1234")) {
            cost = 12.99 * getDiscountCode();
        } else {
            cost = -9999;
        }

        return this.round(cost);
    }

    // 精确到小数后2位保存
    private double round(double cost) {
        return Math.floor(cost * 100) / 100;
    }

    public double getTotalCost() {
        return getItemCost() * getNumItems();
    }
}
