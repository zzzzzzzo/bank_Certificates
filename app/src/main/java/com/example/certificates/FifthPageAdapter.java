package com.example.certificates;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FifthPageAdapter extends FragmentPagerAdapter {

    //private String[] title = new String[]{"First","Second","Third"};

    public FifthPageAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new Fifth1Fragment();
        }else if(position==1){
            return new Fifth3Fragment();
        }else{
            return new Fifth4Fragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //return title[position];
        if(position==0){
            return "第一章";
        }else if(position==1){
            return "第三章";
        }else{
            return "第四章";
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}


