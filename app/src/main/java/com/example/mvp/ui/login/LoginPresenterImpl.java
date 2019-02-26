package com.example.mvp.ui.login;

import com.example.mvp.data.model.User;

public class LoginPresenterImpl implements LoginContract.LoginPresenter,LoginContract.GetLoginInIntractor.OnLoginInFinishedListener{
    private LoginContract.LoginView loginView;
    private LoginContract.GetLoginInIntractor getLoginInIntractor;

    public LoginPresenterImpl(LoginContract.LoginView loginView) {
        this.loginView=loginView;
    }
    public LoginPresenterImpl(LoginContract.LoginView loginView, LoginContract.GetLoginInIntractor getLoginInIntractor) {
        this.loginView = loginView;
        this.getLoginInIntractor = getLoginInIntractor;
    }



    @Override
    public void onDestory() {
        loginView =null;
    }

    @Override
    public void validateLoginInFromServer() {
        if (loginView!=null) {
            getLoginInIntractor.getLoginInfoData(this);
        }
    }

    @Override
    public void onFinished(User user) {
        if (loginView!=null){
          loginView.hideProgress();
          loginView.setLoginInData(user);
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
      if (loginView!=null){
         loginView.hideProgress();
         loginView.onResponseFailure(throwable);
      }
    }
}
