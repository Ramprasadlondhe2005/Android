package com.ram.togglebutton;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ToggleButton tgButton;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        tgButton = findViewById(R.id.tgButton);
        tgButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    tgButton.setBackgroundResource(R.drawable.on);
                    Toast.makeText(MainActivity.this, "Bluetooth is On", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    tgButton.setBackgroundResource(R.drawable.off);
                    Toast.makeText(MainActivity.this, "Bluetooth is Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
