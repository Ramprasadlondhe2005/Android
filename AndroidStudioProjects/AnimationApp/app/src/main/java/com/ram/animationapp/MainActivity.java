package com.ram.animationapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnClock,btnAnti,btnZI,btnZO,btnFIO,btnSUD;
    Animation oAnim;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClock=findViewById(R.id.btnClock);
        btnAnti=findViewById(R.id.btnAnti);
        btnZI=findViewById(R.id.btnZI);
        btnZO=findViewById(R.id.btnZO);
        btnFIO=findViewById(R.id.btnFIO);
        btnSUD=findViewById(R.id.btnSUD);
        img=findViewById(R.id.img);

        btnClock.setOnClickListener(this);
        btnAnti.setOnClickListener(this);
        btnZI.setOnClickListener(this);
        btnZO.setOnClickListener(this);
        btnFIO.setOnClickListener(this);
        btnSUD.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v==btnClock)
        {
            oAnim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clockwise);
            img.startAnimation(oAnim);
        }
    }
}