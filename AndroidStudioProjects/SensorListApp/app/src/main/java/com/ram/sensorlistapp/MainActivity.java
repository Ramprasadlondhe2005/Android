package com.ram.sensorlistapp;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tvlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvlist=findViewById(R.id.tvlist);

        SensorManager osmg=(SensorManager)this.getSystemService(SENSOR_SERVICE);
        List<Sensor>allsensor=osmg.getSensorList(Sensor.TYPE_ALL);

        String strVal="";
        for(Sensor s:allsensor)
        {
            strVal+=s.getName()+"\n";
        }
        tvlist.setText(strVal);

    }
}