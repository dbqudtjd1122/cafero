package com.android.userapp_tabandfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2017-08-04.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    //tab 갯수
    private int tabCount= 0;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new tab_frgment1();
                break;
            case 1:
                fragment = new tab_frgment2();
                break;
            case 2:
                fragment = new tab_frgment3();
                break;
            case 3:
                fragment = new tab_frgment4();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
