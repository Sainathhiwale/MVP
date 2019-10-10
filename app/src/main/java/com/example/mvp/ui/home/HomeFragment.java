package com.example.mvp.ui.home;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mvp.R;
import com.example.mvp.ui.authers.authersList.AuthersListFragment;
import com.example.mvp.ui.book.BookFragment;
import com.example.mvp.ui.user.UsersFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    @Bind(R.id.llBook)
    LinearLayout llBook;
    @Bind(R.id.llUser)
    LinearLayout llUser;
    @Bind(R.id.llAuthers)
    LinearLayout llAuthers;
    @Bind(R.id.llActivities)
    LinearLayout llActivities;
    @Bind(R.id.llCoverPhto)
    LinearLayout llCoverPhto;
    private int REQUEST_ID_MULTIPLE_PERMISSIONS =101;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        checkAndRequestPermissions();
        return view;
    }

    private boolean checkAndRequestPermissions() {
        int permissionSendMessage = ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_SMS);
        int contactpermission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.GET_ACCOUNTS);

        int writepermission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

        int callpermission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE);

        int receivepermission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.RECEIVE_SMS);
        int locationpermission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (locationpermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        if (contactpermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.GET_ACCOUNTS);
        }
        if (writepermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (permissionSendMessage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_SMS);
        }
        if (receivepermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.RECEIVE_SMS);
        }

        if (callpermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CALL_PHONE);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            requestPermissions(listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_ID_MULTIPLE_PERMISSIONS){

            if (grantResults.length>0){
                for (int i=0;i<grantResults.length;i++){

                    if (permissions[i].equals(Manifest.permission.GET_ACCOUNTS)){
                        if (grantResults[i]== PackageManager.PERMISSION_GRANTED){
                            Log.e("msg", "accounts granted");
                        }
                    }else if (permissions[i].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                            Log.e("msg", "storage granted");
                        }
                    }else if (permissions[i].equals(Manifest.permission.CALL_PHONE)){
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                            Log.e("msg", "call granted");
                        }
                    }else if (permissions[i].equals(Manifest.permission.RECEIVE_SMS)){
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                            Log.e("msg", "sms granted");

                        }
                    }else if (permissions[i].equals(Manifest.permission.ACCESS_FINE_LOCATION)){
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                            Log.e("msg", "location granted");
                        }
                    }

                }
            }
        }
    }

    @OnClick({R.id.llUser, R.id.llBook, R.id.llAuthers})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llUser:
                UsersFragment userALLFragment = new UsersFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,userALLFragment );
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
                break;
            case R.id.llBook:
                BookFragment bookFragment = new BookFragment();
                FragmentTransaction fragmentTransaction1 = getFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.main_container,bookFragment);
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();

                break;
            case R.id.llAuthers:
                AuthersListFragment authersFragment = new AuthersListFragment();
                FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.main_container, authersFragment);
                fragmentTransaction2.commit();
                fragmentTransaction2.addToBackStack(null);
                break;


        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
