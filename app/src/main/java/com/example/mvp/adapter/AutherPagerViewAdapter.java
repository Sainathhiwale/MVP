package com.example.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mvp.ui.authers.authersList.AuthersFragment;

public class AutherPagerViewAdapter extends FragmentPagerAdapter {
    public AutherPagerViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                AuthersFragment  authersFragment = new AuthersFragment();
                return authersFragment;

                default:
                   return null;
        }
        //return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
