package com.example.mvp.myapp;

import android.app.Application;

import com.example.mvp.data.DataManager;
import com.example.mvp.data.prefs.SharedPrefsHelper;

public class AppController extends Application {
    private DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefsHelper);
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
