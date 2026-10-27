package com.om.timepickerdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnShow;
    TimePicker oTime1;
    TextView tvTime1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);
        oTime1 = findViewById(R.id.oTime1);
        tvTime1 = findViewById(R.id.tvTime1);
        oTime1.setIs24HourView(true);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTime1.setText(convertTime(oTime1.getCurrentHour(), oTime1.getCurrentMinute()));
            }
        });
    }

    public String convertTime(int iH, int iM) {
        String strTime = "Current Time=";
        String strAmPM = " AM";
        if (iH > 12)
        {
            iH = iH - 12;
            strAmPM = " PM";
        }
        else if (iH == 12)
        {
            strAmPM = " PM";
        }
        else if (iH == 0)
        {
            iH = 12;
        }

        String strMinute = "";
        if (iM <= 9)
        {
            strMinute = "0" + iM;
        }
        else
        {
            strMinute = "" + iM;
        }
        return (strTime += iH + ":" + strMinute + strAmPM);

    }
}
