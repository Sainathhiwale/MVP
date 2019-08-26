package com.example.mvp.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.ui.authers.authersList.AuthersFragment;
import com.example.mvp.ui.user.UsersActivity;
import com.example.mvp.ui.user.all_users.UserALLFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    @Bind(R.id.llBook)
    LinearLayout llBook;
    @Bind(R.id.llUser)
    LinearLayout llUser;
    @Bind(R.id.llAuthers)
    LinearLayout llAuthers;
    @Bind(R.id.llActivities)
    LinearLayout llActivities;
    @Bind(R.id.llCoverPhto)
    LinearLayout llCoverPhto;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.llUser, R.id.llBook, R.id.llAuthers})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llUser:
                UserALLFragment userALLFragment = new UserALLFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,userALLFragment );
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
                break;
            case R.id.llBook:
                Toast.makeText(getActivity(), "Book list", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llAuthers:
                AuthersFragment authersFragment = new AuthersFragment();
                FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.main_container, authersFragment);
                fragmentTransaction2.commit();
                fragmentTransaction2.addToBackStack(null);
                break;


        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
