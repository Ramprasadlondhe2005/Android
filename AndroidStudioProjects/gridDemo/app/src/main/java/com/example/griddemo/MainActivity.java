package com.example.griddemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=findViewById(R.id.gridview);
        
        String[] gridItems=new String[16];
        for (int i=0;i<16;i++)
        {
            gridItems[i]="Grid"+(i+1);
        }

        ArrayAdapter <String> gvAdapter=new ArrayAdapter<>(this,R.layout.simple_item,gridItems);
        gridView.setAdapter(gvAdapter);

    }
}