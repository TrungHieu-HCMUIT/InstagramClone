package com.example.instagramclone.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.instagramclone.R;

public class SignOutFragment extends Fragment {
    private static final String TAG = SignOutFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (ViewGroup) inflater.inflate(R.layout.fragment_sign_out, container, false);
    }
}
