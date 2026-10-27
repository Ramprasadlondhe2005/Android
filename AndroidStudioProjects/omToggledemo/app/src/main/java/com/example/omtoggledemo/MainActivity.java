package com.example.omtoggledemo;

import android.graphics.Color;
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
    ToggleButton tTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tTest=findViewById(R.id.toggleButton);

        tTest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton b, boolean isChecked)
            {
                if(tTest.isChecked())
                {
                    //tTest.setBackgroundResource(R.drawable.on);
                    Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_LONG).show();
                    tTest.setTextColor(Color.RED);
                }
                else
                {
                    //tTest.setBackgroundResource(R.drawable.off);
                    Toast.makeText(MainActivity.this, "Off", Toast.LENGTH_LONG).show();
                    tTest.setTextColor(Color.GREEN);
                }

            }
        });


    }

}
