package com.example.mvp.ui.user;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.adapter.PagerViewAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UsersActivity extends AppCompatActivity  {
    @Bind(R.id.tab_layout)
  LinearLayout tab_layout;
    @Bind(R.id.tvAddUser)
  TextView tvAddUser;
    @Bind(R.id.tvAllUsers)
  TextView tvAllUsers;
    @Bind(R.id.tvSingleUser)
  TextView tvSingleUser;
    @Bind(R.id.mainPager)
    ViewPager mainPager;
    PagerViewAdapter pagerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        ButterKnife.bind(this);
       initView();
    }

    private void initView() {
        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
        mainPager.setAdapter(pagerViewAdapter);
        mainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onPageSelected(int position) {
                changeTabs(position);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void changeTabs(int position) {
        if (position==0){
            tvAddUser.setTextColor(getColor(R.color.colorBlack));
            tvAddUser.setTextSize(18);

            tvAllUsers.setTextColor(getColor(R.color.colorBlack));
            tvAllUsers.setTextSize(16);

            tvSingleUser.setTextColor(getColor(R.color.colorBlack));
            tvSingleUser.setTextSize(16);
        }if (position ==1){
            tvAllUsers.setTextColor(getColor(R.color.colorBlack));
            tvAllUsers.setTextSize(18);

            tvSingleUser.setTextColor(getColor(R.color.colorBlack));
            tvSingleUser.setTextSize(16);

            tvAddUser.setTextColor(getColor(R.color.colorBlack));
            tvAddUser.setTextSize(16);

        }if (position ==2){
            tvSingleUser.setTextColor(getColor(R.color.colorBlack));
            tvSingleUser.setTextSize(18);

            tvAddUser.setTextColor(getColor(R.color.colorBlack));
            tvAddUser.setTextSize(16);

            tvAllUsers.setTextColor(getColor(R.color.colorBlack));
            tvAllUsers.setTextSize(16);

        }
    }

    @OnClick({R.id.tvAddUser,R.id.tvAllUsers,R.id.tvSingleUser})
    public void onViewClicked(View view){
        if (view.getId()==R.id.tvAddUser){
         mainPager.setCurrentItem(0);

        }else if (view.getId()==R.id.tvAllUsers){
            mainPager.setCurrentItem(1);

        }else if (view.getId() == R.id.tvSingleUser){
            mainPager.setCurrentItem(2);
        }
    }

}
