package com.example.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.instagramclone.R;
import com.example.instagramclone.Utils.BottomNavViewExHelper;
import com.example.instagramclone.Utils.GridImageAdapter;
import com.example.instagramclone.Utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private Context mContext = ProfileActivity.this;
    private static final String TAG = ProfileActivity.class.getSimpleName();
    private int ACTIVITY_NUM = 4;

    private ProgressBar mProgressBar;
    private ImageView profilePhoto;
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setupActivityWidgets();

        tempGridSetup();

        setProfilePhoto();

        setupToolbar();

        setupBottomNavigationViewEx();
    }

    private void setupActivityWidgets() {
        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        profilePhoto = (ImageView) findViewById(R.id.profile_photo);
        mGridView = (GridView) findViewById(R.id.gridView);
    }

    private void tempGridSetup() {
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");
        imgURLs.add("https://instagram.fhan3-2.fna.fbcdn.net/v/t51.2885-19/s320x320/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fhan3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX9u1W4u&oh=9cac7f6f0de406676f73de0cc0a1adba&oe=606B89C8");

        setupGridImageView(imgURLs);
    }

    private void setupGridImageView(ArrayList<String> imgURLs) {
        GridImageAdapter adapter = new GridImageAdapter(mContext, getLayoutInflater(), imgURLs, R.layout.layout_grid_imageview);
        mGridView.setAdapter(adapter);
    }

    private void setProfilePhoto() {
        String imgURL = "instagram.fdad3-2.fna.fbcdn.net/v/t51.2885-19/s150x150/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fdad3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX96_zh0&oh=53813b6307bf9722f8231d5af518d4da&oe=606A2AB8";
        UniversalImageLoader.setImage(imgURL, profilePhoto, null, "https://");
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