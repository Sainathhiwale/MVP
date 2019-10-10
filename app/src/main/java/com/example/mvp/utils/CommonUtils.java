package com.example.mvp.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

public class CommonUtils {
    private static ProgressDialog mProgressDialog;
     static Toast mToast;


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

    public static void showToast(Context context,String statusMsg){
          if (mToast!=null)
              mToast.cancel();
          mToast = Toast.makeText(context,statusMsg,Toast.LENGTH_SHORT);
          mToast.show();
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
