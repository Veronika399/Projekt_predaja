package com.example.newproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    final int NUM_PAGES=2;
    private String tabTitles[]=new String[]{"Izračun","Tablica"};


    public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT); }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return PrviFragment.newInstance("1");
            default:
                return DrugiFragment.newInstance("2");
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return tabTitles[position];
    }

}
