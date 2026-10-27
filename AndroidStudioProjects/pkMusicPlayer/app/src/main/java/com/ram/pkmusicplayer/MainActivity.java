package com.ram.pkmusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button btnStart,btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart=findViewById(R.id.btnstart);
        btnStop=findViewById(R.id.btnstop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.btnstart)
        {
            Intent oIn = new Intent(this, MyMusic.class);
            startService(oIn);
        }
        else if(v.getId() == R.id.btnstop)
        {
            Intent oIn=new Intent(this,MyMusic.class);
            stopService(oIn);
        }
    }
}
