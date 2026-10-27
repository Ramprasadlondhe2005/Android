package com.example.galleryapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.galleryapp.ImageAdapter;
import com.example.galleryapp.R;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 100;
    private String[] mImagePaths;
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Image URL to load
        String imageUrl = "https://example.com/image.jpg"; // Replace this with your image URL

        // Find the ImageView in your layout
        ImageView imageView = findViewById(R.id.imageView);

        // Load image into ImageView dynamically with Glide
        Glide.with(this)
                .load(imageUrl)
                .into(imageView);
    }


    private void loadImages() {
        mImagePaths = getImagePathsFromMediaStore();
        if (mImagePaths != null) {
            ImageAdapter adapter = new ImageAdapter(this, mImagePaths);
            mGridView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "Failed to load images", Toast.LENGTH_SHORT).show();
        }
    }

    private String[] getImagePathsFromMediaStore() {
        String[] projection = {MediaStore.Images.Media.DATA};
        Uri imagesUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = getContentResolver().query(imagesUri, projection, null, null, null);

        if (cursor != null) {
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            String[] imagePaths = new String[cursor.getCount()];
            int i = 0;
            while (cursor.moveToNext()) {
                imagePaths[i++] = cursor.getString(columnIndex);
            }
            cursor.close();
            return imagePaths;
        } else {
            Toast.makeText(this, "Failed to query images from MediaStore", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadImages();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
