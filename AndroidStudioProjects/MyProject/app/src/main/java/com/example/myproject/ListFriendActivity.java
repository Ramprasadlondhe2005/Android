package com.example.myproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Queue;

public class ListFriendActivity extends AppCompatActivity {
    ListView lView;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friend);

        lView=findViewById(R.id.lView);
        database = openOrCreateDatabase("friendbook", MODE_PRIVATE, null);
        String query="SELECT name,mobileno FROM friends";
        ArrayList<String>friends=new ArrayList<>();
        Cursor cursor=database.rawQuery(query,null);
        while(cursor.moveToNext())
        {
            String friend = cursor.getString(0) + "-" + cursor.getString(1);
            friends.add(friend);

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, friends);
        lView.setAdapter(adapter);
    }
}