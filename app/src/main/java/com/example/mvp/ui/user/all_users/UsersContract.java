package com.example.mvp.ui.user.all_users;

import com.example.mvp.data.model.UserList;

import java.util.List;

public interface UsersContract {
    interface UsersPresenter{
         void onDestroy();
         void requestDataForUserList();
    }

    interface UsersView{
        void showProgress();
        void hideProgress();
       void setUsersListData(List<UserList> userList);
        void onResponseFailure(Throwable throwable);
    }

    interface GetUsersInIntractor{
        interface OnUserFinishedListener{
            void onUFinished(List<UserList> userList);
            void onUFailure(Throwable throwable);
        }
        void getUserListInfoData(OnUserFinishedListener onUserFinishedListener);
    }
}
