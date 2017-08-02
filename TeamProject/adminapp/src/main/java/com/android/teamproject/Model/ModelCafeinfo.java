package com.android.teamproject.Model;


import android.os.Parcel;
import android.os.Parcelable;

import com.android.teamproject.Main_Model_Adapter.ModelCafe;

public class ModelCafeinfo implements Parcelable {
    
     private Integer cafeno;
     private String brand;
     private String cafename;
     private String cafeaddr;
     private String cafephone;
     private Float avg_grade;
     private Integer review_count;
     private Integer like_count;
     
     
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
    @Override
    public String toString() {
        return "ModelCafeinfo [cafeno=" + cafeno + ", brand=" + brand
                + ", cafename=" + cafename + ", cafeaddr=" + cafeaddr
                + ", cafephone=" + cafephone + ", avg_grade=" + avg_grade
                + ", review_count=" + review_count + ", like_count="
                + like_count + "]";
    }
    public ModelCafeinfo(Integer cafeno, String brand, String cafename,
            String cafeaddr, String cafephone, Float avg_grade,
            Integer review_count, Integer like_count) {
        super();
        this.cafeno = cafeno;
        this.brand = brand;
        this.cafename = cafename;
        this.cafeaddr = cafeaddr;
        this.cafephone = cafephone;
        this.avg_grade = avg_grade;
        this.review_count = review_count;
        this.like_count = like_count;
    }
    public ModelCafeinfo() {
        super();
    }
    public static Parcelable.Creator<ModelCafeinfo> getCREATOR() {
        return CREATOR;
    }

    protected ModelCafeinfo(Parcel in) {
    }

    public static final Parcelable.Creator<ModelCafeinfo> CREATOR = new Parcelable.Creator<ModelCafeinfo>() {
        @Override
        public ModelCafeinfo createFromParcel(Parcel in) {
            return new ModelCafeinfo(in);
        }

        @Override
        public ModelCafeinfo[] newArray(int size) {
            return new ModelCafeinfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
