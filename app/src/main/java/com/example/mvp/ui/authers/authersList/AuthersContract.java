package com.example.mvp.ui.authers.authersList;

import com.example.mvp.data.model.authers.AuthorsList;

import java.util.List;

public class AuthersContract {
    interface AuthersPresenter{
        void onDestory();
        void requestDataForAuthersList();
    }
    interface AuthersView{
        void showProgress();
        void hideProgress();
        void setAuthersListData(List<AuthorsList> authersListData);
        void onResponseFailure(Throwable throwable);
    }
    interface GetAuthersInIntractor{
        interface OnAuthersFinishedListener{
            void onASFinished(List<AuthorsList> authersListData);
            void onASFailure(Throwable throwable);
        }
        void getAuthersListInfoData(OnAuthersFinishedListener OnAuthersFinishedListener);

    }
}
