package com.om.imageviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    Button btn;
    int iPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.iv);
        btn=findViewById(R.id.btn);

        final int RoseID[]={ R.drawable.rose1,R.drawable.rose2,R.drawable.rose3,R.drawable.rose4,R.drawable.rose5,R.drawable.rose6,R.drawable.rose7};

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(iPos==7)
                {
                    iPos=0;
                }
                iv.setImageResource(RoseID[iPos++]);
            }
        });

    }
}