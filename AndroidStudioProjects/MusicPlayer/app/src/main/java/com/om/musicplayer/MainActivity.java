package com.om.musicplayer;

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

    Button btnstart,btnstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnstart=findViewById(R.id.btnstart);
        btnstop=findViewById(R.id.btnstop);

        btnstart.setOnClickListener(this);
        btnstop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btnstart)
        {
            Intent oI = new Intent(this, mediaplayer.class);
            startService(oI);

        }
        else if (v.getId()==R.id.btnstop)
        {
            Intent oI=new Intent(this, mediaplayer.class);
            stopService(oI);
        }

    }
}