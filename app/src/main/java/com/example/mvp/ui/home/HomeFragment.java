package com.example.mvp.ui.home;


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
import com.example.mvp.ui.user.all_users.UserALLFragment;
import com.example.mvp.ui.user.get_user.SingleUserFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    @Bind(R.id.llUserList)
     LinearLayout llUserList;
    @Bind(R.id.llSingleUser)
    LinearLayout llSingleUser;
    @Bind(R.id.llBook)
    LinearLayout llBook;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick({R.id.llUserList,R.id.llSingleUser,R.id.llBook,R.id.llAuthers})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.llUserList:
                UserALLFragment userALLFragment = new UserALLFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,userALLFragment);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
                break;
            case R.id.llSingleUser:
                SingleUserFragment singleUserFragment = new SingleUserFragment();
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.main_container,singleUserFragment);
                fragmentTransaction1.commit();
                fragmentTransaction1.addToBackStack(null);
                break;
            case R.id.llBook:
                Toast.makeText(getActivity(), "Book list", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llAuthers:
                AuthersFragment authersFragment = new AuthersFragment();
                FragmentTransaction fragmentTransaction2  = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.main_container,authersFragment);
                fragmentTransaction2.commit();
                fragmentTransaction2.addToBackStack(null);
                break;


        }
    }
}
