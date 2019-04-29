package com.example.mvp.ui.user.add_users;

import com.example.mvp.data.model.AddUser;

public interface AddUserContract {
    interface AddUserView{
        void showProgress();
        void hideProgress();
        void setAdduserInData(AddUser addUser);
        void onResponseFailure(Throwable throwable);
    }

    interface AddUserPresenter{
        void onDestory();
        void validateAddUserInFromServer();
    }
    interface GetAddUserInIntractor{
        interface OnAddUserFinishedListener{
            void onAUFinished(AddUser addUser);
            void onAUFailure(Throwable throwable);
        }
        void getAddUserInfoData(OnAddUserFinishedListener onAddUserFinishedListener);
    }
}
