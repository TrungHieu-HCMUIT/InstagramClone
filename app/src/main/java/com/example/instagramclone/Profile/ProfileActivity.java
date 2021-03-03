package com.example.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.instagramclone.R;
import com.example.instagramclone.Utils.BottomNavViewExHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class ProfileActivity extends AppCompatActivity {

    private Context mContext = ProfileActivity.this;
    private static final String TAG = ProfileActivity.class.getSimpleName();
    private int ACTIVITY_NUM = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setupToolbar();
        setupBottomNavigationViewEx();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to account settings.");
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });
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