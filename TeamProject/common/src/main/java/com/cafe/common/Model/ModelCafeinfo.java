package com.cafe.common.Model;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ModelCafeinfo implements Serializable {
    
     private Integer cafeno;
     private String brand;
     private String cafename;
     private String cafeaddr;
     private String cafephone;
     private Float avg_grade;
     private Integer review_count;
     private Integer like_count;
     private String cafebigtype;
     private String cafesmalltype;



    public ModelCafeinfo(String cafebigtype) {
        this.cafebigtype = cafebigtype;
    }


    public Integer getCafeno() {
        return cafeno;
    }
    public void setCafeno(Integer cafeno) {
        this.cafeno = cafeno;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getCafename() {
        return cafename;
    }
    public void setCafename(String cafename) {
        this.cafename = cafename;
    }
    public String getCafeaddr() {
        return cafeaddr;
    }
    public void setCafeaddr(String cafeaddr) {
        this.cafeaddr = cafeaddr;
    }
    public String getCafephone() {
        return cafephone;
    }
    public void setCafephone(String cafephone) {
        this.cafephone = cafephone;
    }
    public Float getAvg_grade() {
        return avg_grade;
    }
    public void setAvg_grade(Float avg_grade) {
        this.avg_grade = avg_grade;
    }
    public Integer getReview_count() {
        return review_count;
    }
    public void setReview_count(Integer review_count) {
        this.review_count = review_count;
    }
    public Integer getLike_count() {
        return like_count;
    }
    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }
    public String getCafebigtype() {
        return cafebigtype;
    }
    public void setCafebigtype(String cafebigtype) {
        this.cafebigtype = cafebigtype;
    }
    public String getCafesmalltype() {
        return cafesmalltype;
    }
    public void setCafesmalltype(String cafesmalltype) {
        this.cafesmalltype = cafesmalltype;
    }


    @Override
    public String toString() {
        return "ModelCafeinfo{" +
                "cafeno=" + cafeno +
                ", brand='" + brand + '\'' +
                ", cafename='" + cafename + '\'' +
                ", cafeaddr='" + cafeaddr + '\'' +
                ", cafephone='" + cafephone + '\'' +
                ", avg_grade=" + avg_grade +
                ", review_count=" + review_count +
                ", like_count=" + like_count +
                ", cafebigtype='" + cafebigtype + '\'' +
                ", cafesmalltype='" + cafesmalltype + '\'' +
                '}';
    }

    public ModelCafeinfo(Integer cafeno, String brand, String cafename, String cafeaddr, String cafephone, Float avg_grade, Integer review_count, Integer like_count, String cafebigtype, String cafesmalltype) {
        this.cafeno = cafeno;
        this.brand = brand;
        this.cafename = cafename;
        this.cafeaddr = cafeaddr;
        this.cafephone = cafephone;
        this.avg_grade = avg_grade;
        this.review_count = review_count;
        this.like_count = like_count;
        this.cafebigtype = cafebigtype;
        this.cafesmalltype = cafesmalltype;
    }

    public ModelCafeinfo() {
        super();
    }


    protected ModelCafeinfo(Parcel in) {
    }



}
