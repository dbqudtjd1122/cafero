package com.spring.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelCafeMenu {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ModelCafeMenu.class);
    
    private Integer       cafeno;
    private Integer       menu_id;
    private String        menu_name;
    private Integer       price;
    private String        descrption;
    
    public static Logger getLogger() {
        return logger;
    }
    
    public static void setLogger(Logger logger) {
        ModelCafeMenu.logger = logger;
    }
    
    public Integer getCafeno() {
        return cafeno;
    }
    
    public void setCafeno(Integer cafeno) {
        this.cafeno = cafeno;
    }
    
    public Integer getMenu_id() {
        return menu_id;
    }
    
    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
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
    
    @Override
    public String toString() {
        return "ModelCafeMenu [cafeno=" + cafeno + ", menu_id=" + menu_id
                + ", menu_name=" + menu_name + ", price=" + price
                + ", descrption=" + descrption + "]";
    }
    
    public ModelCafeMenu(Integer cafeno, Integer menu_id, String menu_name,
            Integer price, String descrption) {
        super();
        this.cafeno = cafeno;
        this.menu_id = menu_id;
        this.menu_name = menu_name;
        this.price = price;
        this.descrption = descrption;
    }
    
    public ModelCafeMenu() {
        super();
    }
    
}
