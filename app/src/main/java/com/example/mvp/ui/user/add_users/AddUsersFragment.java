package com.example.mvp.ui.user.add_users;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUsersFragment extends Fragment {


    public AddUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_users, container, false);
        return view;
    }

}
