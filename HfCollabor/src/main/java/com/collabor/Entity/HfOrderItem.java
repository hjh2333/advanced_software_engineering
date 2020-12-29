package com.collabor.Entity;

public class HfOrderItem {
    private int order_item_id;
    private int order_id;
    private int product_id;
    private int product_sum;

    public int getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_sum() {
        return product_sum;
    }

    public void setProduct_sum(int product_sum) {
        this.product_sum = product_sum;
    }

    @Override
    public String toString() {
        return "HfOrderItem{" +
                "order_item_id=" + order_item_id +
                ", order_id=" + order_id +
                ", product_id=" + product_id +
                ", product_sum=" + product_sum +
                '}';
    }
}
