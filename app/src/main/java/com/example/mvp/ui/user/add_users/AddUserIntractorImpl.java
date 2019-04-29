package com.example.mvp.ui.user.add_users;

import android.content.Context;

import com.example.mvp.data.model.AddUser;
import com.example.mvp.data.network.AzureApiInterface;
import com.example.mvp.data.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUserIntractorImpl implements AddUserContract.GetAddUserInIntractor {
    private int id;
    private Context context;
    private int userid;
    private String userName;
    private String password;

    public AddUserIntractorImpl( Context context,int id, int userid, String userName, String password) {
        this.id = id;
        this.context = context;
        this.userid = userid;
        this.userName = userName;
        this.password = password;
    }

    /*public AddUserIntractorImpl( Context context,int id,userid,) {
        this.id = id;
        this.context = context;
    }*/

    @Override
    public void getAddUserInfoData(final OnAddUserFinishedListener onAddUserFinishedListener) {
        AzureApiInterface azureApiInterface = RetrofitInstance.getRetrofitInstance().create(AzureApiInterface.class);
        Call<AddUser> addUserCall = azureApiInterface.addUsers(id,userid,userName,password);
        addUserCall.enqueue(new Callback<AddUser>() {
            @Override
            public void onResponse(Call<AddUser> call, Response<AddUser> response) {
                onAddUserFinishedListener.onAUFinished(response.body());
            }

            @Override
            public void onFailure(Call<AddUser> call, Throwable t) {
              onAddUserFinishedListener.onAUFailure(t);
            }
        });
    }
}
