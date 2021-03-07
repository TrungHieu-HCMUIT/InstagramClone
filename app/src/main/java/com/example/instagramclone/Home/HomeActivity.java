package com.example.instagramclone.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.instagramclone.Login.LoginActivity;
import com.example.instagramclone.R;
import com.example.instagramclone.Utils.BottomNavViewExHelper;
import com.example.instagramclone.Utils.SectionsPagerAdapter;
import com.example.instagramclone.Utils.UniversalImageLoader;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

public class HomeActivity extends AppCompatActivity {

    private Context mContext = HomeActivity.this;
    private static final String TAG = HomeActivity.class.getSimpleName();
    private int ACTIVITY_NUM = 0;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        setupBottomNavigationViewEx();

        setupViewPager();

        initImageLoader();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null)
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Log.d(TAG, "signed_in" + currentUser.getUid());
        } else {
            Intent intent = new Intent(mContext, LoginActivity.class);
            startActivity(intent);
            Log.d(TAG, "signed_out");
        }
    }

    /**
     * Responsible for adding 3 tabs: Camera, Home, Messages
     */
    private void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());

        //Add fragments to adapter
        adapter.addFragment(new CameraFragment());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new MessagesFragment());

        //Bind view pager and set up adapter for it
        ViewPager viewPager = (ViewPager) findViewById(R.id.centerViewPager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_instagram);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_messages);
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

    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

}