package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.instagramclone.Utils.BottomNavViewExHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {

    private Context mContext = HomeActivity.this;
    private static final String TAG = HomeActivity.class.getSimpleName();
    private int ACTIVITY_NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupBottomNavigationViewEx();
    }

    private void setupBottomNavigationViewEx () {
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewEx);

        //Create bottom navigation view
        BottomNavViewExHelper.setupBottomNavView(bottomNavigationViewEx);

        //Set up on navigation item selected
        BottomNavViewExHelper.enableNavigation(mContext, bottomNavigationViewEx);

        //Set the icon of selected item on menu highlight
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}