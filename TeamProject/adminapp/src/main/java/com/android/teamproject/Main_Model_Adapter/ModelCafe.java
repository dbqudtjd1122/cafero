package com.android.teamproject.Main_Model_Adapter;


import android.os.Parcel;
import android.os.Parcelable;

public class ModelCafe implements Parcelable {
    
     public Integer cafe_number;
     public String brand;
     public String cafe_name;
     public String location;
     public String address;
     public String phone;
     public Float star;
     public Integer review_count;
     public Integer star_count;
     
 
    public ModelCafe() {
        super();
    }
    public ModelCafe(String brand, String cafe_name) {
        super();
        this.brand = brand;
        this.cafe_name = cafe_name;
    }
    public ModelCafe(Integer cafe_number, String brand, String cafe_name,
            String location, String address, String phone, Float star,
            Integer review_count, Integer star_count) {
        super();
        this.cafe_number = cafe_number;
        this.brand = brand;
        this.cafe_name = cafe_name;
        this.location = location;
        this.address = address;
        this.phone = phone;
        this.star = star;
        this.review_count = review_count;
        this.star_count = star_count;
    }
    public Integer getCafe_number() {
        return cafe_number;
    }
    public void setCafe_number(Integer cafe_number) {
        this.cafe_number = cafe_number;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getCafe_name() {
        return cafe_name;
    }
    public void setCafe_name(String cafe_name) {
        this.cafe_name = cafe_name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Float getStar() {
        return star;
    }
    public void setStar(Float star) {
        this.star = star;
    }
    public Integer getReview_count() {
        return review_count;
    }
    public void setReview_count(Integer review_count) {
        this.review_count = review_count;
    }
    public Integer getStar_count() {
        return star_count;
    }
    public void setStar_count(Integer star_count) {
        this.star_count = star_count;
    }
    @Override
    public String toString() {
        return "ModelCafe [cafe_number=" + cafe_number + ", brand=" + brand
                + ", cafe_name=" + cafe_name + ", location=" + location
                + ", address=" + address + ", phone=" + phone + ", star=" + star
                + ", review_count=" + review_count + ", star_count="
                + star_count + "]";
    }

    public static Parcelable.Creator<ModelCafe> getCREATOR() {
        return CREATOR;
    }

    protected ModelCafe(Parcel in) {
    }

    public static final Parcelable.Creator<ModelCafe> CREATOR = new Parcelable.Creator<ModelCafe>() {
        @Override
        public ModelCafe createFromParcel(Parcel in) {
            return new ModelCafe(in);
        }

        @Override
        public ModelCafe[] newArray(int size) {
            return new ModelCafe[size];
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
