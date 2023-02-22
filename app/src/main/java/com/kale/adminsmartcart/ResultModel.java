package com.kale.adminsmartcart;

public class ResultModel {
    int pro_id;
    String product_name;
    String product_img;
    String product_price;

    public ResultModel(String product_name, String product_img, String product_price) {
        this.product_name = product_name;
        this.product_img = product_img;
        this.product_price = product_price;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }
}
