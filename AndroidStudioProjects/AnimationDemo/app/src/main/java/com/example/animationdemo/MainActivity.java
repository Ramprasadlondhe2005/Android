package com.example.animationdemo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    Button btnZI, btnZO;
    ImageView img;
    Animation oanim;
    boolean bZoom=true;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        btnZO=findViewById(R.id.btnZO);
        btnZI=findViewById(R.id.btnZI);
        img=findViewById(R.id.img);

        btnZO.setOnClickListener(this);
        btnZI.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v == btnZI)
        {
            oanim = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
            img.startAnimation(oanim);
            bZoom = false;
        }
        else if (v == btnZO)
        {
            oanim = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
            img.startAnimation(oanim);
            bZoom = true;
        }
    }
}
