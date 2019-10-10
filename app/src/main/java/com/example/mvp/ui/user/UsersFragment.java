package com.example.mvp.ui.user;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mvp.R;
import com.example.mvp.adapter.ViewPagerAdapter;
import com.example.mvp.ui.user.add_users.AddUsersFragment;
import com.example.mvp.ui.user.all_users.UserALLFragment;
import com.example.mvp.ui.user.get_user.SingleUserFragment;

import java.util.Objects;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment {


    @Bind(R.id.tab_layout_user)
    TabLayout tabLayoutUser;
    @Bind(R.id.viewpager_user)
    ViewPager viewpagerUser;
    @Bind(R.id.llHomeLayout)
    LinearLayout llHomeLayout;

    public UsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
     (((AppCompatActivity)(getActivity())).getSupportActionBar()).setTitle("Users");
        setupPager(viewpagerUser);
    }

    private void setupPager(ViewPager viewpagerUser) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new SingleUserFragment(),"single user");
        viewPagerAdapter.addFragment(new UserALLFragment(),"All User");
        viewPagerAdapter.addFragment(new AddUsersFragment(),"Add User");
        viewpagerUser.setAdapter(viewPagerAdapter);
    }



}
