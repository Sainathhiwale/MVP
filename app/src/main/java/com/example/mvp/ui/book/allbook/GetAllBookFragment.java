package com.example.mvp.ui.book.allbook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetAllBookFragment extends Fragment {


    public GetAllBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_all_book, container, false);
    }

}
