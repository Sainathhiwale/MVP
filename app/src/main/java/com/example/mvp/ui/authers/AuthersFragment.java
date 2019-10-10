package com.example.mvp.ui.authers;


import android.os.Build;
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
import com.example.mvp.ui.authers.add_authers.AddAutherFragment;
import com.example.mvp.ui.authers.authersList.AuthersListFragment;


import java.util.Objects;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuthersFragment extends Fragment {


    @Bind(R.id.tab_layout_authers)
    TabLayout tabLayoutAuthers;
    @Bind(R.id.viewpager_authers)
    ViewPager viewpagerAuthers;
    @Bind(R.id.llAutherLayout)
    LinearLayout llAutherLayout;

    public AuthersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_authers, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            (Objects.requireNonNull(((AppCompatActivity) (Objects.requireNonNull(getActivity()))).getSupportActionBar())).setTitle("Authers");
        }
        setupPager(viewpagerAuthers);
    }

    private void setupPager(ViewPager viewpagerAuthers) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new AddAutherFragment(),"add Authers");
        viewPagerAdapter.addFragment(new AuthersListFragment(),"Authers List");
        viewpagerAuthers.setAdapter(viewPagerAdapter);
    }

}
