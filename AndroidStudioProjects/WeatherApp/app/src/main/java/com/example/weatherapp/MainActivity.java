package com.example.weatherapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DrawingView drawingView;
    private Button btnClear, btnRed, btnBlue, btnGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawingView = findViewById(R.id.drawing_view);
        btnClear = findViewById(R.id.btn_clear);
        btnRed = findViewById(R.id.btn_red);
        btnBlue = findViewById(R.id.btn_blue);
        btnGreen = findViewById(R.id.btn_green);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.clear();
            }
        });

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setColor(Color.RED);
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setColor(Color.BLUE);
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setColor(Color.GREEN);
            }
        });
    }
}
