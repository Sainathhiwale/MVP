package com.example.mvp.ui.user.login;

import com.example.mvp.data.model.User;

public interface LoginContract {

    interface LoginView{
        void showProgress();
        void hideProgress();
        void setLoginInData(User user);
        void onResponseFailure(Throwable throwable);
    }

    interface LoginPresenter{
       void onDestory();
       void validateLoginInFromServer();
    }

   interface GetLoginInIntractor{
        interface OnLoginInFinishedListener{
            void onFinished(User user);
            void onFailure(Throwable throwable);
        }
        void getLoginInfoData(OnLoginInFinishedListener OnLoginInFinishedListener);
   }
}
