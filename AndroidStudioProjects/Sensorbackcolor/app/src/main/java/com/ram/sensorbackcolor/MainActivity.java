package com.ram.sensorbackcolor;

import android.hardware.*;
import android.os.Bundle;
import android.graphics.Color;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager osmg;
    LinearLayout linearLayout;
    boolean isColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout=findViewById(R.id.linearlayout);
        osmg=(SensorManager)this.getSystemService(SENSOR_SERVICE);

    }


    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }
    }
    private void getAccelerometer(SensorEvent event)
    {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        float accelationSquareRoot = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        if (accelationSquareRoot >= 2)
        {
            if (isColor)
            {
                linearLayout.setBackgroundColor(Color.CYAN);
            } else
            {
                linearLayout.setBackgroundColor(Color.MAGENTA);
            }
            isColor = !isColor;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        osmg.registerListener(this,osmg.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        osmg.unregisterListener(this);
    }
}

