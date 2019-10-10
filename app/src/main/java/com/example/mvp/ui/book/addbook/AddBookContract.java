package com.example.mvp.ui.book.addbook;

import com.example.mvp.data.model.book.PostBook;

public interface AddBookContract {

    interface  AddBookView{
        void showProgress();
        void hideProgress();
        void setAddBookInfoData(PostBook postBook);
        void onFailure(Throwable throwable);
    }

    interface AddBookPresenter{
        void onDestory();
        void validateAddBookInFromServer();
    }

    interface GetAddBookInIntractor{
        interface OnAddBkInFinishedListener{
            void onAddBkFinished(PostBook postBook);
            void onAddBkFailure(Throwable throwable);
        }
     void getAddBkInfoData(OnAddBkInFinishedListener onAddBkInFinishedListener);
    }
}
