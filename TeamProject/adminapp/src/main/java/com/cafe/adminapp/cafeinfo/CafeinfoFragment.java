package com.cafe.adminapp.cafeinfo;

import android.support.v4.app.Fragment;



public class CafeinfoFragment extends Fragment {
    protected String orderKind="";

    public String getOrderKind() {
        return orderKind;
    }

    public void setOrderKind(String orderKind) {
        this.orderKind = orderKind;
        recall();

        // 메서드 호출
    }
    public void recall(){

    }
}
