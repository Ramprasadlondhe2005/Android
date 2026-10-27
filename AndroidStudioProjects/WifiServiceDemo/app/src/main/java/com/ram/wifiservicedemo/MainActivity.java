package com.ram.wifiservicedemo;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnStart,btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart=findViewById(R.id.button1);
        btnStop=findViewById(R.id.button2);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.button1)
        {
            WifiManager oWifi=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            oWifi.setWifiEnabled(true);
            Toast.makeText(this, "Wi-Fi Started", Toast.LENGTH_LONG).show();
        }
        else if(v.getId()==R.id.button2)
        {
            WifiManager oWifi=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            oWifi.setWifiEnabled(true);
            Toast.makeText(this, "Wi-Fi Stopped", Toast.LENGTH_LONG).show();

        }
    }
}