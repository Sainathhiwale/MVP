package com.example.mvp.ui.authers.add_authers;

import com.example.mvp.data.model.authers.AddAuthers;

public class AddAutherContract {
    interface AddAutherPresenter{
        void onDestory();
        void validateAddAutherfromServer();
    }

    interface AddAutherView{
        void showProgress();
        void hideProgress();
        void setAutherInData(AddAuthers addAuthers);
        void onResponseFailure(Throwable throwable);
    }
    interface  GetAddAutherInIntractor{
        interface OnAddAutherFinishedListener{
            void onAAFinished(AddAuthers addAuthers);
            void onAAFailure(Throwable throwable);
        }
        void getAddAutherInfoData(OnAddAutherFinishedListener onAddAutherFinishedListener);
    }
}
