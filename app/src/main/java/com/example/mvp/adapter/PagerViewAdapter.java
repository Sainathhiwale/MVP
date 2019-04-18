package com.example.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mvp.ui.user.add_users.AddUsersFragment;
import com.example.mvp.ui.user.all_users.UserALLFragment;
import com.example.mvp.ui.user.get_user.SingleUserFragment;

public class PagerViewAdapter extends FragmentPagerAdapter {

    public PagerViewAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AddUsersFragment addUsersFragment = new AddUsersFragment();
                return addUsersFragment;
            case 1:
                UserALLFragment userALLFragment = new UserALLFragment();
                return userALLFragment;
            case 2:
                SingleUserFragment singleUserFragment = new SingleUserFragment();
                return singleUserFragment;
            default:
                return null;
        }
        // return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
