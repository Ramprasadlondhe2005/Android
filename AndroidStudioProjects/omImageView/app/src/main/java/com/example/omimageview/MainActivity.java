package com.example.omimageview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button button;
    int ipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.img);
        button=findViewById(R.id.button);

        final int RoseId[]={R.drawable.bappa,R.drawable.bappa1};

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ipos==2)
                {
                    ipos=0;
                }
                img.setImageResource(RoseId[ipos++]);
            }
        });

    }
}