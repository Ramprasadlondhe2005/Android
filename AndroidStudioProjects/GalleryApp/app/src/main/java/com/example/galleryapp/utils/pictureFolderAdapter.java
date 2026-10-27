package com.example.galleryapp.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galleryapp.MainActivity;

import java.util.ArrayList;

public class pictureFolderAdapter extends RecyclerView.Adapter<pictureFolderAdapter.FolderViewHolder> {
    private ArrayList<com.example.galleryapp.utils.imageFolder> folders;
    private com.example.galleryapp.utils.itemClickListener clickListener;

    public pictureFolderAdapter(ArrayList<imageFolder> folds, MainActivity mainActivity, MainActivity mainActivity1) {
    }

    @NonNull
    @Override
    public pictureFolderAdapter.FolderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull pictureFolderAdapter.FolderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FolderViewHolder extends RecyclerView.ViewHolder {
        public FolderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    // Constructor, onCreateViewHolder, onBindViewHolder, getItemCount methods
}
