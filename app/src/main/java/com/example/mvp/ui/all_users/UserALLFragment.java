package com.example.mvp.ui.all_users;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.adapter.UserAdatpter;
import com.example.mvp.data.model.UserList;
import com.example.mvp.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserALLFragment extends Fragment implements UsersContract.UsersView{
    private static final String TAG = "UserALLFragment";
    @Bind(R.id.rvUsers)
    RecyclerView rvUsers;
    LinearLayoutManager layoutManager;
    UserAdatpter userAdatpter;
    private UserListPresenterImpl presenter;

    public UserALLFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_all, container, false);
        ButterKnife.bind(this,view);
        initView();
        initData();
        return view;
    }

    private void initView() {
        layoutManager = new LinearLayoutManager(getActivity());
        rvUsers.setLayoutManager(layoutManager);
    }

    private void initData() {
        presenter = new UserListPresenterImpl(this,new GetUserListIntractorImpl(getActivity()));
        presenter.requestDataForUserList();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.onDestroy();
        }
    }

    @Override
    public void showProgress() {
        CommonUtils.startProgressBarDialog(getActivity(),"Fetching the userlist data..wait");

    }

    @Override
    public void hideProgress() {
      CommonUtils.stopProgressBarDialog();
    }

    @Override
    public void setUsersListData(UserList userList) {
        List<UserList> userLists = new ArrayList<>();
         if (userList!=null){
             String name = userList.getUserName();
             String password = userList.getPassword();
             Log.d(TAG, "setUsersListData: "+password);
             Log.d(TAG, "setUsersListData: "+name);
            userAdatpter = new UserAdatpter(getActivity(), (List<UserList>) userList);
            rvUsers.setAdapter(userAdatpter);
         }
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(getActivity(),
                "Something went wrong please try again", Toast.LENGTH_LONG).show();
    }
}
