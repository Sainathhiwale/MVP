package com.example.mvp.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class CommonUtils {
    private static ProgressDialog mProgressDialog;

    public static void startProgressBarDialog(Context context,String message){
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(message);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    public static void stopProgressBarDialog(){
        mProgressDialog.dismiss();
    }
 /* private ProgressDialog mProgressDialog;

    public ProgressDialog startProgressBarDialog(Context context,String message) {
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(message);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        return mProgressDialog;
    }
    public void stopProgressBarDialog(){
      mProgressDialog.dismiss();
    }*/
}
