package com.example.instagramclone.Utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Class that stores fragments for tabs
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private final static String TAG = SectionsPagerAdapter.class.getSimpleName();
    private final List<Fragment> mFragmentList = new ArrayList<>();

    public SectionsPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }
}
