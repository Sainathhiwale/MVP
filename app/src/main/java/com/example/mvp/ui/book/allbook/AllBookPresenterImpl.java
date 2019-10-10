package com.example.mvp.ui.book.allbook;

import com.example.mvp.data.model.book.BookInfoList;

public class AllBookPresenterImpl implements AllBookContract.GetAllBookPresenter, AllBookContract.GetAllBookIntractor.OnAllBKFinishedListener{
     private AllBookContract.GetAllBookView getAllBookView;
     private AllBookContract.GetAllBookIntractor getAllBookIntractor;

    public AllBookPresenterImpl(AllBookContract.GetAllBookView getAllBookView, AllBookContract.GetAllBookIntractor getAllBookIntractor) {
        this.getAllBookView = getAllBookView;
        this.getAllBookIntractor = getAllBookIntractor;
    }

    public AllBookPresenterImpl(AllBookContract.GetAllBookView getAllBookView) {
        this.getAllBookView = getAllBookView;
    }

    @Override
    public void onDestory() {
       getAllBookView = null;
    }

    @Override
    public void getAllbookInfoData() {
       if (getAllBookView!=null){
           getAllBookView.showProgress();
           getAllBookIntractor.getAllBookInfoData(this);
       }
    }

    @Override
    public void onAllBkFinished(BookInfoList bookInfoList) {
            if (getAllBookView!=null){
                getAllBookView.hideProgress();
                getAllBookView.setAllBookInfoData(bookInfoList);
            }
    }

    @Override
    public void onAllBkFailure(Throwable throwable) {
        if (getAllBookView!=null){
            getAllBookView.hideProgress();
            getAllBookView.onFailure(throwable);
        }
    }
}
