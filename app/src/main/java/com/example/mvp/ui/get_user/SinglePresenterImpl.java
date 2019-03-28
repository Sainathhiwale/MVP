package com.example.mvp.ui.get_user;

import com.example.mvp.data.model.SingleUsers;

public class SinglePresenterImpl implements SingleContract.SinglePresenter,SingleContract.GetSingleInIntractor.OnSUFinishedListener {
    private  SingleContract.SingleView singleView;
    private SingleContract.GetSingleInIntractor getSingleInIntractor;

    public SinglePresenterImpl(SingleContract.SingleView singleView, SingleContract.GetSingleInIntractor getSingleInIntractor) {
        this.singleView = singleView;
        this.getSingleInIntractor = getSingleInIntractor;
    }

    @Override
    public void onSUFinished(SingleUsers singleUsers) {
       if (singleView!=null){
           singleView.setSingleUserInfoData(singleUsers);
       }
    }

    @Override
    public void onSUFailure(Throwable throwable) {
      if (singleView!=null){
          singleView.onResponseFailure(throwable);
          singleView.hideProgress();
      }
    }

    @Override
    public void onDestroy() {
       singleView = null;
    }

    @Override
    public void requestDataForSingleUser() {
           if (singleView!=null){
               singleView.showProgress();
           }
           getSingleInIntractor.getSingleUserInfoData(this);
    }
}
