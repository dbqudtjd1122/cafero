package com.spring.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ModelMenu {
    
    private String cafe_name;
    private String menu_id;
    private String menu_name;
    private String sales;
    private Integer price;
    
    
    public String getCafe_name() {
        return cafe_name;
    }
    public void setCafe_name(String cafe_name) {
        this.cafe_name = cafe_name;
    }
    public String getMenu_id() {
        return menu_id;
    }
    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }
    public String getMenu_name() {
        return menu_name;
    }
    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }
    public String getSales() {
        return sales;
    }
    public void setSales(String sales) {
        this.sales = sales;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "ModelMenu [cafe_name=" + cafe_name + ", menu_id=" + menu_id
                + ", menu_name=" + menu_name + ", sales=" + sales + ", price="
                + price + "]";
    }
    public ModelMenu(String cafe_name, String menu_id, String menu_name,
            String sales, Integer price) {
        super();
        this.cafe_name = cafe_name;
        this.menu_id = menu_id;
        this.menu_name = menu_name;
        this.sales = sales;
        this.price = price;
    }
    public ModelMenu() {
        super();
    }

    
}
