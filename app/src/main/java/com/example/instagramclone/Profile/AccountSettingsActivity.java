package com.example.instagramclone.Profile;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.instagramclone.R;
import com.example.instagramclone.Utils.SectionsStatePagerAdapter;

import java.util.ArrayList;

public class AccountSettingsActivity extends AppCompatActivity {
    private static final String TAG = AccountSettingsActivity.class.getSimpleName();

    private Context mContext;

    private SectionsStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        mContext = AccountSettingsActivity.this;

        //Bind view by id
        mViewPager = (ViewPager) findViewById(R.id.centerViewPager);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relLayout1);

        setupFragments();

        setupSettingsList();

        //Set up the back arrow navigating back to ProfileActivity
        ImageView backArrow = (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setupFragments() {
        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile)); //Fragment #0
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out)); //Fragment #1
    }

    private void setupViewPager(int fragmentNumber) {
        mRelativeLayout.setVisibility(View.GONE);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }

    private void setupSettingsList() {
        ListView listView = (ListView) findViewById(R.id.lvAccountSettings);
        ArrayList<String> options = new ArrayList<>();

        //Add options to list view
        options.add(getString(R.string.edit_profile)); //Fragment #0
        options.add(getString(R.string.sign_out)); //Fragment #1

        //Initialize adapter and set it to list view
        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setupViewPager(position);
            }
        });
    }
}
