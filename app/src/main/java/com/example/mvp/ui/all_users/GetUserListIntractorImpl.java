package com.example.mvp.ui.all_users;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.example.mvp.data.model.UserList;
import com.example.mvp.data.network.AzureApiInterface;
import com.example.mvp.data.network.RetrofitInstance;
import com.example.mvp.utils.CommonUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetUserListIntractorImpl implements UsersContract.GetUsersInIntractor {
     private Context context;
    public GetUserListIntractorImpl(Context activity) {
        this.context = activity;
    }

    @Override
    public void getUserListInfoData( final OnUserFinishedListener onUserFinishedListener) {
        AzureApiInterface azureApiInterface = RetrofitInstance.getRetrofitInstance().create(AzureApiInterface.class);
        Call<UserList> userListCall = azureApiInterface.getUserList();
        userListCall.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                onUserFinishedListener.onUFinished(response.body());
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
              onUserFinishedListener.onUFailure(t);
            }
        });

    }
}
