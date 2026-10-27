package com.example.galleryapp.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.galleryapp.R;

public class MarginDecoration extends RecyclerView.ItemDecoration {
    private final int margin;

    public MarginDecoration(Context context) {
        margin = context.getResources().getDimensionPixelSize(R.dimen.item_margin);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(margin, margin, margin, margin);
    }
}
