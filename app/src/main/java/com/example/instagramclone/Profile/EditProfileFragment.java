package com.example.instagramclone.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.instagramclone.R;
import com.example.instagramclone.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

public class EditProfileFragment extends Fragment {
    private static final String TAG = EditProfileFragment.class.getSimpleName();

    private ImageView mProfilePhoto;

    private ImageView backArrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        mProfilePhoto = (ImageView) view.findViewById(R.id.profile_photo);

        //Set up back navigation to ProfileActivity for icon back arrow
        backArrow = (ImageView) view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        setProfilePhoto();

        return view;
    }

    private void setProfilePhoto(){
        String imgURL = "instagram.fdad3-2.fna.fbcdn.net/v/t51.2885-19/s150x150/151371215_702610807102333_477374507086313980_n.jpg?tp=1&_nc_ht=instagram.fdad3-2.fna.fbcdn.net&_nc_ohc=YPQpMPZn3jwAX96_zh0&oh=53813b6307bf9722f8231d5af518d4da&oe=606A2AB8";
        UniversalImageLoader.setImage(imgURL, mProfilePhoto, null, "https://");
    }
}
