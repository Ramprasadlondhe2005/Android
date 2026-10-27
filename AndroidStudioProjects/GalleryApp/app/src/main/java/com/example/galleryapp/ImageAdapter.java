package com.example.galleryapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mImages; // Array to store image paths

    public ImageAdapter(Context context, String[] images) {
        mContext = context;
        mImages = images;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public Object getItem(int position) {
        return mImages[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300)); // Adjust size as needed
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        // Load image into ImageView using BitmapFactory
        String imagePath = mImages[position];
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        imageView.setImageBitmap(bitmap);

        return imageView;
    }
}
