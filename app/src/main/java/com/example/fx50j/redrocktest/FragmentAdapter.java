package com.example.fx50j.redrocktest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.fx50j.redrocktest.fragment.Fragment_DZ;
import com.example.fx50j.redrocktest.fragment.Fragment_MZ;

/**
 * Created by FX50J on 2016/4/17.
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    private String[] mtittle = {"妹子图","段子"};
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fragment_MZ();
            case 1:
                return new Fragment_DZ();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mtittle[position];
    }
}
