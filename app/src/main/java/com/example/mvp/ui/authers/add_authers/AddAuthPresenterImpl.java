package com.example.mvp.ui.authers.add_authers;

import com.example.mvp.data.model.authers.AddAuthers;

public class AddAuthPresenterImpl implements AddAutherContract.AddAutherPresenter,AddAutherContract.GetAddAutherInIntractor.OnAddAutherFinishedListener {
     private AddAutherContract.AddAutherView addAutherView;
     private AddAutherContract.GetAddAutherInIntractor getAddAutherInIntractor;

    public AddAuthPresenterImpl(AddAutherContract.AddAutherView addAutherView, AddAutherContract.GetAddAutherInIntractor getAddAutherInIntractor) {
        this.addAutherView = addAutherView;
        this.getAddAutherInIntractor = getAddAutherInIntractor;
    }

    @Override
    public void onDestory() {
        addAutherView =null;
    }

    @Override
    public void validateAddAutherfromServer() {
        if (addAutherView!=null){
            addAutherView.showProgress();
        }
        getAddAutherInIntractor.getAddAutherInfoData(this);
    }

    @Override
    public void onAAFinished(AddAuthers addAuthers) {
         if (addAuthers!=null){
             addAutherView.hideProgress();
             addAutherView.setAutherInData(addAuthers);
         }
    }

    @Override
    public void onAAFailure(Throwable throwable) {
      if (addAutherView!=null){
          addAutherView.hideProgress();
          addAutherView.onResponseFailure(throwable);
      }
    }
}
