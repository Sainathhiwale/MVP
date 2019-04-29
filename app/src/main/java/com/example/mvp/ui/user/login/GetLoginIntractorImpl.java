package com.example.mvp.ui.user.login;

import com.example.mvp.data.model.User;
import com.example.mvp.data.network.AzureApiInterface;
import com.example.mvp.data.network.RetrofitInstance;
import com.example.mvp.utils.CommonUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetLoginIntractorImpl implements LoginContract.GetLoginInIntractor {
    private String userName, password;
    private int  iD;

    public GetLoginIntractorImpl(String userName, String password, int iD) {
        this.userName = userName;
        this.password = password;
        this.iD = iD;
    }



    @Override
    public void getLoginInfoData(final OnLoginInFinishedListener OnLoginInFinishedListener) {
        AzureApiInterface azureApiInterface = RetrofitInstance.getRetrofitInstance().create(AzureApiInterface.class);
        Call<User> infoCall = azureApiInterface.loginUser(new User(userName,password,iD));
        infoCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                CommonUtils.stopProgressBarDialog();
                OnLoginInFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                CommonUtils.stopProgressBarDialog();
               OnLoginInFinishedListener.onFailure(t);
            }
        });
    }
}
