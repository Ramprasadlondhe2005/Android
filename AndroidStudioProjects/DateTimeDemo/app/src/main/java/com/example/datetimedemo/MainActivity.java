package com.example.datetimedemo;

import android.os.Build;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker;
    TextView txtDate,txtTime;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        datePicker=findViewById(R.id.datepicker);
        timePicker=findViewById(R.id.timepicker);
        txtDate=findViewById(R.id.txtDate);
        txtTime=findViewById(R.id.txtTime);


        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int iH, int iM)
            {
                txtTime.setText("Time: "+iH+":"+iM);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int iY, int iM, int iD)
                {
                        txtDate.setText("Date= "+iD+"/"+(iM+1)+"/"+iY);
                }
            });
        }
    }
}