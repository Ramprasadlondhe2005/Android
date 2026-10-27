package com.om.framedemo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
FrameLayout oBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oBack=findViewById(R.id.oBack);

    }
    public void show(View view)
    {
        if(view.getId()==R.id.btn1)
        {
            oBack.setBackgroundColor(Color.RED);
        }
        else if(view.getId()==R.id.btn2)
        {
            oBack.setBackgroundColor(Color.GREEN);
        }
        else if(view.getId()==R.id.btn3)
        {
            oBack.setBackgroundColor(Color.BLUE);
        }
    }
}