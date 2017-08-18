package com.cafe.common.Model;


public class ModelCafeMenu {
    // SLF4J Logging

    private String menu_name;
    private Integer price;
    private String descrption;
    private String brand;
    private String menucd;


    @Override
    public String toString() {
        return "ModelCafeMenu{" +
                "menu_name='" + menu_name + '\'' +
                ", price=" + price +
                ", descrption='" + descrption + '\'' +
                ", brand='" + brand + '\'' +
                ", menucd='" + menucd + '\'' +
                '}';
    }

    public ModelCafeMenu() {
    }

    public ModelCafeMenu(String menu_name, Integer price, String descrption, String brand, String menucd) {
        this.menu_name = menu_name;
        this.price = price;
        this.descrption = descrption;
        this.brand = brand;
        this.menucd = menucd;
    }

    public ModelCafeMenu(String menu_name, Integer price, String descrption) {
        this.menu_name = menu_name;
        this.price = price;
        this.descrption = descrption;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMenucd() {
        return menucd;
    }

    public void setMenucd(String menucd) {
        this.menucd = menucd;
    }
}
