package com.example.instagramclone.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

public class GridImageAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<String> imgURLs;
    private int layoutResource;

    public GridImageAdapter(Context mContext, LayoutInflater mLayoutInflater, ArrayList<String> imgURLs, int layoutResource) {
        this.mContext = mContext;
        this.mLayoutInflater = mLayoutInflater;
        this.imgURLs = imgURLs;
        this.layoutResource = layoutResource;
    }

    @Override
    public int getCount() {
        return imgURLs.size();
    }

    @Override
    public Object getItem(int position) {
        return imgURLs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /**
         * ViewHolder build pattern
         */
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder();
            holder.profilePhoto = (SquareImageView) convertView.findViewById(R.id.gridImageView);
            holder.mProgressBar = (ProgressBar) convertView.findViewById(R.id.gridImageProgressbar);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        String imgURL = imgURLs.get(position);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(imgURL, holder.profilePhoto, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if (holder.mProgressBar != null) {
                    holder.mProgressBar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if (holder.mProgressBar != null) {
                    holder.mProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (holder.mProgressBar != null) {
                    holder.mProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if (holder.mProgressBar != null) {
                    holder.mProgressBar.setVisibility(View.GONE);
                }
            }
        });

        return convertView;
    }

    static class ViewHolder {
        SquareImageView profilePhoto;
        ProgressBar mProgressBar;
    }
}
