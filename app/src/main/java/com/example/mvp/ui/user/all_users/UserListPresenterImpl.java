package com.example.mvp.ui.user.all_users;

import com.example.mvp.data.model.UserList;

import java.util.List;

public class UserListPresenterImpl implements UsersContract.UsersPresenter,UsersContract.GetUsersInIntractor.OnUserFinishedListener{
    private UsersContract.UsersView usersView;
    private UsersContract.GetUsersInIntractor getUsersInIntractor;



    public UserListPresenterImpl(UsersContract.UsersView usersView, UsersContract.GetUsersInIntractor getUsersInIntractor){
         this.usersView = usersView;
         this.getUsersInIntractor = getUsersInIntractor;
     }


    @Override
    public void onDestroy() {
         usersView = null;
    }

    @Override
    public void requestDataForUserList() {
        if (usersView!=null){
            usersView.showProgress();
        }
         getUsersInIntractor.getUserListInfoData(this);
    }

    @Override
    public void onUFinished(List<UserList> userList) {
        if (usersView!=null){
            usersView.setUsersListData(userList);
            usersView.hideProgress();
        }
    }

    @Override
    public void onUFailure(Throwable throwable) {
        if (usersView!=null){
            usersView.onResponseFailure(throwable);
            usersView.hideProgress();
        }
    }
}
