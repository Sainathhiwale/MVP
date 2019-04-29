package com.example.mvp.ui.authers;

import com.example.mvp.data.model.authers.AuthorsList;

import java.util.List;

public class AuthersListPresenterImpl implements AuthersContract.AuthersPresenter,AuthersContract.GetAuthersInIntractor.OnAuthersFinishedListener {
    private AuthersContract.AuthersView authersView;
    private AuthersContract.GetAuthersInIntractor getAuthersInIntractor;

    public AuthersListPresenterImpl(AuthersContract.AuthersView authersView, AuthersContract.GetAuthersInIntractor getAuthersInIntractor) {
        this.authersView = authersView;
        this.getAuthersInIntractor = getAuthersInIntractor;
    }

   /* public AuthersListPresenterImpl(AuthersContract.AuthersView authersView) {
        this.authersView = authersView;
    }
*/
    @Override
    public void onDestory() {
      authersView = null;
    }

    @Override
    public void requestDataForAuthersList() {
        if (authersView!=null){
            authersView.showProgress();
        }
      getAuthersInIntractor.getAuthersListInfoData(this);
    }

    @Override
    public void onASFinished(List<AuthorsList> authersListData) {
        if (authersView!=null){
            authersView.setAuthersListData(authersListData);
            authersView.hideProgress();
        }
    }

    @Override
    public void onASFailure(Throwable throwable) {
       if (authersView!=null){
           authersView.onResponseFailure(throwable);
           authersView.hideProgress();
       }
    }
}
