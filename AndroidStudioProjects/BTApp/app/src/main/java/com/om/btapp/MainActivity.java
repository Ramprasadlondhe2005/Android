package com.om.btapp;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ToggleButton Tbtest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Tbtest=findViewById(R.id.toggleButton);
        Tbtest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                {
                    Tbtest.setBackgroundResource(R.drawable.on);
                    Toast.makeText(MainActivity.this, "Bluetooth is ON.", Toast.LENGTH_SHORT).show();
                } else {
                    Tbtest.setBackgroundResource(R.drawable.off);
                    Toast.makeText(MainActivity.this, "Bluetooth is OFF.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}