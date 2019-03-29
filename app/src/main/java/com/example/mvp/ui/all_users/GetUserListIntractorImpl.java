package com.example.mvp.ui.all_users;

import android.content.Context;

import com.example.mvp.data.model.UserList;
import com.example.mvp.data.network.AzureApiInterface;
import com.example.mvp.data.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetUserListIntractorImpl implements UsersContract.GetUsersInIntractor {
    private static final String TAG = "GetUserListIntractorImp";
    private Context context;
    public GetUserListIntractorImpl(Context activity) {
        this.context = activity;
    }

    @Override
    public void getUserListInfoData( final OnUserFinishedListener onUserFinishedListener) {
        AzureApiInterface azureApiInterface = RetrofitInstance.getRetrofitInstance().create(AzureApiInterface.class);
        Call<List<UserList>> userListCall = azureApiInterface.getUserList();
         userListCall.enqueue(new Callback<List<UserList>>() {
             @Override
             public void onResponse(Call<List<UserList>> call, Response<List<UserList>> response) {
                 onUserFinishedListener.onUFinished(response.body());
             }

             @Override
             public void onFailure(Call<List<UserList>> call, Throwable t) {
                 onUserFinishedListener.onUFailure(t);
             }
         });

    }
}
