package com.cafe.adminapp.cafeinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cafe.adminapp.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class Cafeinfo_tabFragment3 extends CafeinfoFragment {

    private View view = null;

    public Cafeinfo_tabFragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cafeinfo_tab_fragment_3, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
