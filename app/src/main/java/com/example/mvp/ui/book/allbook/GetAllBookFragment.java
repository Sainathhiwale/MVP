package com.example.mvp.ui.book.allbook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp.R;
import com.example.mvp.data.model.book.BookInfoList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetAllBookFragment extends Fragment implements AllBookContract.GetAllBookView {

    public GetAllBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_all_book, container, false);
        return view;
    }

    @Override
    public void showProgress() {
        
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setAllBookInfoData(BookInfoList bookInfoData) {

    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
