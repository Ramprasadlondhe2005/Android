package com.example.backcolor;

import static android.graphics.Color.*;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    FrameLayout backColor;
    Button btnRed,btnBlack,btnGreen,btnBlue,btnYellow,btnCyan,btnMagenta,btnPink,btnBrown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backColor = findViewById(R.id.backColor);
        btnRed = findViewById(R.id.btnRed);
        btnBlack = findViewById(R.id.btnBlack);
        btnGreen = findViewById(R.id.btnGreen);
        btnBlue = findViewById(R.id.btnBlue);
        btnYellow = findViewById(R.id.btnYellow);
        btnCyan = findViewById(R.id.btnCyan);
        btnMagenta = findViewById(R.id.btnMagenta);
        btnPink = findViewById(R.id.btnPink);
        btnBrown = findViewById(R.id.btnBrown);

    }

    void changeBackgroundColor(View v)
        {
            if (v.getId() == R.id.btnRed)
            {
                backColor.setBackgroundColor(RED);
            }
            else if (v.getId() == R.id.btnBlack)
            {
                backColor.setBackgroundColor(BLACK);
            }
            else if (v.getId() == R.id.btnGreen)
            {
                backColor.setBackgroundColor(GREEN);
            }
            else if (v.getId() == R.id.btnBlue)
            {
                backColor.setBackgroundColor(BLUE);
            }
            else if (v.getId() == R.id.btnYellow)
            {
                backColor.setBackgroundColor(YELLOW);
            }
            else if (v.getId() == R.id.btnCyan)
            {
                backColor.setBackgroundColor(CYAN);
            }
            else if (v.getId() == R.id.btnMagenta)
            {
                backColor.setBackgroundColor(MAGENTA);
            }
            else if (v.getId() == R.id.btnPink)
            {
                backColor.setBackgroundColor(rgb(234,54,128));
            }
            else if (v.getId() == R.id.btnBrown)
            {
                backColor.setBackgroundColor(rgb(120,67,21));
            }
        }
    }
