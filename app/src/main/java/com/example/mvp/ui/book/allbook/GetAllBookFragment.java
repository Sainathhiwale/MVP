package com.example.mvp.ui.book.allbook;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mvp.R;
import com.example.mvp.adapter.BookAdapter;
import com.example.mvp.data.model.book.BookInfoList;
import com.example.mvp.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetAllBookFragment extends Fragment implements AllBookContract.GetAllBookView {
    private static final String TAG = "GetAllBookFragment";
    @Bind(R.id.svBook)
    SearchView svBook;
    @Bind(R.id.rvBook)
    RecyclerView rvBook;
    @Bind(R.id.llallBookLayout)
    LinearLayout llallBookLayout;
    private AllBookPresenterImpl presenter;
    private List<BookInfoList> bookInfoLists = new ArrayList<>();
    private BookAdapter bookAdapter;

    public GetAllBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_all_book, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        presenter = new AllBookPresenterImpl(this, new GetAllBookIntractorImpl());
        presenter.getAllbookInfoData();
    }

    private void initView() {
        rvBook.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvBook.setHasFixedSize(true);
        presenter = new AllBookPresenterImpl(this);
        svBook.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    @Override
    public void showProgress() {
        CommonUtils.startProgressBarDialog(getActivity(), "Loading data....");
    }

    @Override
    public void hideProgress() {
        CommonUtils.stopProgressBarDialog();
    }

    @Override
    public void setAllBookInfoData(BookInfoList bookInfoData) {
        if (bookInfoData != null) {
            bookInfoLists = Collections.singletonList(bookInfoData);
            bookAdapter = new BookAdapter(getActivity(), bookInfoLists);
            rvBook.setAdapter(bookAdapter);
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        Snackbar snackbar = Snackbar.make(llallBookLayout,throwable.toString(),Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
