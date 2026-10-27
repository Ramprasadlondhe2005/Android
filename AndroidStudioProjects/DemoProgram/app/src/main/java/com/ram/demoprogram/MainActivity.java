package com.ram.demoprogram;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    GridView gridView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);
        imageView = findViewById(R.id.imageView);

        // Setting up data for ListView
        String[] lvItems = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        ArrayAdapter<String> lvAdapter = new ArrayAdapter<>(this, R.layout.simple_item2 , lvItems);
        listView.setAdapter(lvAdapter);

        // Setting up data for GridView
        String[] gvItems = new String[16]; // 4x4 grid
        for (int i = 0; i < 16; i++)
        {
            gvItems[i] = "Grid " + (i + 1);
        }
        ArrayAdapter<String> gridAdapter = new ArrayAdapter<>(this, R.layout.simple_item2, gvItems);
        gridView.setAdapter(gridAdapter);
    }
}
