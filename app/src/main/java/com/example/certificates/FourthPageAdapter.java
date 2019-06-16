package com.example.certificates;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FourthPageAdapter extends FragmentPagerAdapter {

    //private String[] title = new String[]{"First","Second","Third"};

    public FourthPageAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new Fourth1Fragment();
        }else if(position==1){
            return new Fourth2Fragment();
        }else if(position==2) {
            return new Fourth3Fragment();
        }else{
            return new Fourth4Fragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //return title[position];
        if(position==0){
            return "第一章";
        }else if(position==1){
            return "第二章";
        }else if(position==2){
            return "第三章";
        }else{
            return "第四章";
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}


