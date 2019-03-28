package com.example.mvp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.mvp.data.DataManager;
import com.example.mvp.myapp.AppController;
import com.example.mvp.ui.all_users.UserALLFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataManager = ((AppController)getApplication()).getDataManager();
        dataManager.setLoggedIn();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
         int ids = menuItem.getItemId();
         if (ids ==R.id.nav_alluser){
             UserALLFragment userALLFragment = new UserALLFragment();
             FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
             fragmentTransaction.replace(R.id.main_container,userALLFragment);
             fragmentTransaction.commit();
             fragmentTransaction.addToBackStack(null);
         }
        return false;
    }
}
