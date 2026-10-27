package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addFriendClick(View view) {
        Intent intent=new Intent(this,AddFriendActivity.class);
        startActivity(intent);
    }

    public void friendListClick(View view) {
        Intent intent=new Intent(this,ListFriendActivity.class);
        startActivity(intent);
    }
}