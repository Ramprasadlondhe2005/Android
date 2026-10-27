package com.om.wifiapp;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
    public void onClick(View v)
    {
        if(v.getId()==R.id.btnstart)
        {
            WifiManager owm=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            owm.setWifiEnabled(true);
            Toast.makeText(this, "Wifi is Started", Toast.LENGTH_SHORT).show();



        }
        else if(v.getId()==R.id.btnstop)
        {
            WifiManager owm=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            owm.setWifiEnabled(false);
            Toast.makeText(this, "Wifi is stopped", Toast.LENGTH_SHORT).show();

        }

    }
}