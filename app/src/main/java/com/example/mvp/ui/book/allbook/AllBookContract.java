package com.example.mvp.ui.book.allbook;

import com.example.mvp.data.model.book.BookInfoList;

public interface AllBookContract {

    interface GetAllBookView{
        void showProgress();
        void hideProgress();
        void setAllBookInfoData(BookInfoList bookInfoData);
        void onFailure(Throwable throwable);
    }

    interface GetAllBookPresenter{
        void onDestory();
        void getAllbookInfoData();
    }

    interface GetAllBookIntractor{
        interface  OnAllBKFinishedListener{
            void onAllBkFinished(BookInfoList bookInfoList);
            void onAllBkFailure(Throwable throwable);
        }
        void getAllBookInfoData(OnAllBKFinishedListener onAllBKFinishedListener);
    }
}
