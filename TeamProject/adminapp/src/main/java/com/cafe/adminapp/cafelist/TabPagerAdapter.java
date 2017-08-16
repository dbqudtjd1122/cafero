package com.cafe.adminapp.cafelist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class TabPagerAdapter extends FragmentPagerAdapter {

    // tab 갯수
    private int tabCount = 0;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new tabFragment1();
                break;
            case 1:
                fragment = new tabFragment2();
                break;
            case 2:
                fragment = new tabFragment3();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}

