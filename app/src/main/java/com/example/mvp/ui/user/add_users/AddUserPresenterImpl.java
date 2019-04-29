package com.example.mvp.ui.user.add_users;

import com.example.mvp.data.model.AddUser;

public class AddUserPresenterImpl implements AddUserContract.AddUserPresenter,AddUserContract.GetAddUserInIntractor.OnAddUserFinishedListener {
    private AddUserContract.AddUserView  addUserView;
    private AddUserContract.GetAddUserInIntractor getAddUserInIntractor;

    public AddUserPresenterImpl(AddUserContract.AddUserView addUserView, AddUserContract.GetAddUserInIntractor getAddUserInIntractor) {
        this.addUserView = addUserView;
        this.getAddUserInIntractor = getAddUserInIntractor;
    }

    @Override
    public void onDestory() {
        addUserView = null;
    }

    @Override
    public void validateAddUserInFromServer() {
       if (addUserView!=null){
           addUserView.showProgress();
       }
       getAddUserInIntractor.getAddUserInfoData(this);
    }

    @Override
    public void onAUFinished(AddUser addUser) {
        if (addUserView!=null){
            addUserView.setAdduserInData(addUser);
            addUserView.hideProgress();
        }
    }

    @Override
    public void onAUFailure(Throwable throwable) {
          if (addUserView!=null){
              addUserView.onResponseFailure(throwable);
              addUserView.hideProgress();
          }
    }
}
