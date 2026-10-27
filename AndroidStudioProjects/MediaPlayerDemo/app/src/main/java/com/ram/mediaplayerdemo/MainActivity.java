package com.ram.mediaplayerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        if (view.getId()==R.id.btnStart)
        {
            Intent in = new Intent(this, MyMedia.class);
            startService(in);

        }
        else if (view.getId()==R.id.btnStop)
        {
            Intent in = new Intent(this, MyMedia.class);
            stopService(in);
        }
    }
}