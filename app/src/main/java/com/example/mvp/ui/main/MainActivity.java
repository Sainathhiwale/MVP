package com.example.mvp.ui.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.data.DataManager;
import com.example.mvp.myapp.AppController;
import com.example.mvp.ui.home.HomeFragment;
import com.example.mvp.ui.user.login.LoginActivity;
import com.example.mvp.ui.user.UsersActivity;
import com.example.mvp.utils.AppConstants;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataManager = ((AppController)getApplication()).getDataManager();
        dataManager.setLoggedIn();
        dataManager.getUserName();
        String getUserName = getIntent().getStringExtra(AppConstants.USERNAME);
        dataManager.setUserName(getUserName);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        navMenuView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        TextView tvName = (TextView)header.findViewById(R.id.navUser);
        tvName.setText(getUserName);
        initView();
    }

    private void initView() {
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container,homeFragment);
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
         int ids = menuItem.getItemId();
         if (ids ==R.id.nav_alluser){
             Intent intent = new Intent(MainActivity.this, UsersActivity.class);
             startActivity(intent);
         }else if (ids == R.id.nav_logout){
             dataManager.clear();
             Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
             startActivity(loginIntent);
             finish();
         }else if (ids == R.id.nav_coverphoto){

         }else if(ids == R.id.nav_authers){

         }
        return false;
    }
}
