package com.example.mvp.ui.authers.authersList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.adapter.AuthersAdapter;
import com.example.mvp.data.model.authers.AuthorsList;
import com.example.mvp.utils.CommonUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuthersFragment extends Fragment implements AuthersContract.AuthersView {
      @Bind(R.id.rvAuthList)
    RecyclerView rvAuthList;
   LinearLayoutManager linearLayoutManager;
   AuthersListPresenterImpl presenter;
   AuthersAdapter authersAdapter;
    public AuthersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_authers, container, false);
        ButterKnife.bind(this,view);
        initData();
        return view;
    }

    private void initData() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rvAuthList.setLayoutManager(linearLayoutManager);
        presenter = new AuthersListPresenterImpl(this,new GetAuthersIntractorImpl(getActivity()));
        presenter.requestDataForAuthersList();


    }

    @Override
    public void showProgress() {
        CommonUtils.startProgressBarDialog(getActivity(),"Fetching the AuthersList data..wait");
    }

    @Override
    public void hideProgress() {
       CommonUtils.stopProgressBarDialog();
    }

    @Override
    public void setAuthersListData(List<AuthorsList> authersListData) {
       if (authersListData!=null){
            authersAdapter = new AuthersAdapter(getActivity(),authersListData);
            rvAuthList.setAdapter(authersAdapter);
       }
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(getActivity(), "Something went wrong!", Toast.LENGTH_SHORT).show();
    }
}
