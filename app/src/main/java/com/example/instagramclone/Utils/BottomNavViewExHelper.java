package com.example.instagramclone.Utils;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.instagramclone.Home.HomeActivity;
import com.example.instagramclone.Like.LikeActivity;
import com.example.instagramclone.Profile.ProfileActivity;
import com.example.instagramclone.R;
import com.example.instagramclone.Search.SearchActivity;
import com.example.instagramclone.Share.ShareActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavViewExHelper {
    public static void setupBottomNavView(BottomNavigationViewEx bottomNavigationViewEx) {
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx bottomNavigationViewEx) {
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.ic_home: //ACTIVITY_NUM = 0
                        Intent home_activity_intent = new Intent(context, HomeActivity.class);
                        context.startActivity(home_activity_intent);
                        break;

                    case R.id.ic_search: //ACTIVITY_NUM = 1
                        Intent search_activity_intent = new Intent(context, SearchActivity.class);
                        context.startActivity(search_activity_intent);
                        break;

                    case R.id.ic_add: //ACTIVITY_NUM = 2
                        Intent share_activity_intent = new Intent(context, ShareActivity.class);
                        context.startActivity(share_activity_intent);
                        break;

                    case R.id.ic_favorite: //ACTIVITY_NUM = 3
                        Intent like_activity_intent = new Intent(context, LikeActivity.class);
                        context.startActivity(like_activity_intent);
                        break;

                    case R.id.ic_person: //ACTIVITY_NUM = 4
                        Intent profile_activity_intent = new Intent(context, ProfileActivity.class);
                        context.startActivity(profile_activity_intent);
                        break;
                }
                return false;
            }
        });
    }
}
