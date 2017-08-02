package com.cafe.userapp;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017-08-02.
 */

public class wirte implements Parcelable {

    String review = "";
    String star = "";



    public wirte(){

    }

    protected wirte(Parcel in) {
        review = in.readString();
        star = in.readString();
    }

    public static final Creator<wirte> CREATOR = new Creator<wirte>() {
        @Override
        public wirte createFromParcel(Parcel in) {
            return new wirte(in);
        }

        @Override
        public wirte[] newArray(int size) {
            return new wirte[size];
        }
    };

    @Override
    public String toString() {
        return "wirte{" +
                "review='" + review + '\'' +
                ", star='" + star + '\'' +
                '}';
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public wirte(String review, String star) {
        this.review = review;
        this.star = star;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(review);
        dest.writeString(star);
    }

    //    public wirte() {
//
//    }
//
//    @Override
//    public String toString() {
//        return "wirte{" +
//                "review='" + review + '\'' +
//                ", star='" + star + '\'' +
//                '}';
//    }
//
//    public String getStar() {
//        return star;
//    }
//
//    public void setStar(String star) {
//        this.star = star;
//    }
//
//
//    public String getReview() {
//        return review;
//    }
//
//    public void setReview(String review) {
//        this.review = review;
//    }
//
//    public static Creator<wirte> getCREATOR() {
//        return CREATOR;
//    }
//
//    public wirte(String review, String star) {
//        this.review = review;
//        this.star = star;
//    }
//
//    protected wirte(Parcel in) {
//        review = in.readString();
//    }
//
//    public static final Creator<wirte> CREATOR = new Creator<wirte>() {
//        @Override
//        public wirte createFromParcel(Parcel in) {
//            return new wirte(in);
//        }
//
//        @Override
//        public wirte[] newArray(int size) {
//            return new wirte[size];
//        }
//    };
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(review);
//    }
}
