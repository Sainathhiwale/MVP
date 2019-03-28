package com.example.mvp.ui.get_user;

import android.content.Context;

import com.example.mvp.data.model.SingleUsers;
import com.example.mvp.data.network.AzureApiInterface;
import com.example.mvp.data.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleUserIntractorImpl implements SingleContract.GetSingleInIntractor {
    private Context context;
    private int id;
    public SingleUserIntractorImpl(Context context,int id) {
        this.context = context;
        this.id =id;
    }

    @Override
    public void getSingleUserInfoData(final OnSUFinishedListener OnSUFinishedListener) {
        AzureApiInterface azureApiInterface = RetrofitInstance.getRetrofitInstance().create(AzureApiInterface.class);
        Call<SingleUsers> singleUsersCall = azureApiInterface.getSingleUser(id);
        singleUsersCall.enqueue(new Callback<SingleUsers>() {
            @Override
            public void onResponse(Call<SingleUsers> call, Response<SingleUsers> response) {
                OnSUFinishedListener.onSUFinished(response.body());
            }

            @Override
            public void onFailure(Call<SingleUsers> call, Throwable t) {
                OnSUFinishedListener.onSUFailure(t);
            }
        });
    }
}
