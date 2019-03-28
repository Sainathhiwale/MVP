package com.example.mvp.ui.get_user;

import com.example.mvp.data.model.SingleUsers;

public interface SingleContract {
    interface SinglePresenter{
        void onDestroy();
        void requestDataForSingleUser();
    }


    interface SingleView{
        void showProgress();
        void hideProgress();
        void setSingleUserInfoData(SingleUsers singleUsers);
        void onResponseFailure(Throwable throwable);
    }
    interface GetSingleInIntractor{
        interface OnSUFinishedListener{
            void onSUFinished(SingleUsers singleUsers);
            void onSUFailure(Throwable throwable);
        }
        void getSingleUserInfoData(OnSUFinishedListener OnSUFinishedListener);
    }


}

