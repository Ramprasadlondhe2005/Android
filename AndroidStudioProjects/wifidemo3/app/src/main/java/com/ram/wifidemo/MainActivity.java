package com.ram.wifidemo;

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
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.button);
        btnStop = (Button) findViewById(R.id.button2);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       if(v.getId()==R.id.button)
       {
           WifiManager oWiFi=(WifiManager) getApplicationContext().getSystemService(getApplicationContext().WIFI_SERVICE);
           oWiFi.setWifiEnabled(true);
           Toast.makeText(this,"WIFI Start",Toast.LENGTH_LONG).show();
       }
       else if(v.getId()==R.id.button2)
       {
           WifiManager oWiFi=(WifiManager) getApplicationContext().getSystemService(getApplicationContext().WIFI_SERVICE);
           oWiFi.setWifiEnabled(false);
           Toast.makeText(this,"WIFI Stop",Toast.LENGTH_LONG).show();
       }
    }
}