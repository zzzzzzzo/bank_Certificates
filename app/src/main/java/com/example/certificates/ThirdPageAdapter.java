package com.example.certificates;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ThirdPageAdapter extends FragmentPagerAdapter {

    //private String[] title = new String[]{"First","Second","Third"};

    public ThirdPageAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new Third1Fragment();
        }else if(position==1){
            return new Third2Fragment();
        }else if(position==2){
            return new Third3Fragment();
        }
        else if(position==3){
            return new Third4Fragment();
        }
        else{
            return new Third5Fragment();
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
        }else if(position==3){
            return "第四章";
        }else{
            return "第五章";
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}


