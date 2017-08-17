package com.cafe.userapp;

import android.graphics.drawable.Drawable;

import java.text.Collator;
import java.util.Comparator;

public class ModelItem {

    //    private Drawable iconItem  ;
    private String menutype;
    private String dataItem01;
    private String dataItem02;
    private String dataItem03;
    private String dataItem04;
    private String detail1;
    private String detail2;

    public ModelItem() {

    }


    @Override
    public String toString() {
        return "ModelItem{" +
                "menutype='" + menutype + '\'' +
                ", dataItem01='" + dataItem01 + '\'' +
                ", dataItem02='" + dataItem02 + '\'' +
                ", dataItem03='" + dataItem03 + '\'' +
                ", dataItem04='" + dataItem04 + '\'' +
                ", detail1='" + detail1 + '\'' +
                ", detail2='" + detail2 + '\'' +
                '}';
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public String getDataItem01() {
        return dataItem01;
    }

    public void setDataItem01(String dataItem01) {
        this.dataItem01 = dataItem01;
    }

    public String getDataItem02() {
        return dataItem02;
    }

    public void setDataItem02(String dataItem02) {
        this.dataItem02 = dataItem02;
    }

    public String getDataItem03() {
        return dataItem03;
    }

    public void setDataItem03(String dataItem03) {
        this.dataItem03 = dataItem03;
    }

    public String getDataItem04() {
        return dataItem04;
    }

    public void setDataItem04(String dataItem04) {
        this.dataItem04 = dataItem04;
    }

    public String getDetail1() {
        return detail1;
    }

    public void setDetail1(String detail1) {
        this.detail1 = detail1;
    }

    public String getDetail2() {
        return detail2;
    }

    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }

    public ModelItem(String menutype, String dataItem01, String dataItem02, String dataItem03, String dataItem04, String detail1, String detail2) {
        this.menutype = menutype;
        this.dataItem01 = dataItem01;
        this.dataItem02 = dataItem02;
        this.dataItem03 = dataItem03;
        this.dataItem04 = dataItem04;
        this.detail1 = detail1;
        this.detail2 = detail2;
    }

    //    public Drawable getIconItem() {
//        return iconItem;
//    }
//    public void setIconItem(Drawable iconItem) {
//        this.iconItem = iconItem;
//    }


    /**
     * 알파벳 이름으로 정렬
     */
    public static final Comparator<ModelItem> ALPHA_COMPARATOR = new Comparator<ModelItem>() {
        private final Collator sCollator = Collator.getInstance();

        @Override
        public int compare(ModelItem mListDate_1, ModelItem mListDate_2) {
            return sCollator.compare(mListDate_1.dataItem01, mListDate_2.dataItem01);
        }
    };
}
