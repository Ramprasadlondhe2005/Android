package com.om.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDate, btnTime;
    EditText etTime, etDate;
    Calendar oCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        etTime = findViewById(R.id.etTime);
        etDate = findViewById(R.id.etDate);

        oCal = Calendar.getInstance();
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int iHour = oCal.get(Calendar.HOUR);
                int iMinute = oCal.get(Calendar.MINUTE);

                TimePickerDialog oTimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener()
                {
                    @Override
                    public void onTimeSet(TimePicker view, int iHour, int iMinute)
                    {
                        etTime.setText(convertTime(iHour, iMinute));
                    }
                }, iHour, iMinute, false);
                oTimePicker.show();

            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int iYear = oCal.get(Calendar.YEAR);
                int iMonth = oCal.get(Calendar.MONTH);
                int iDay = oCal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog oDatePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int iY, int iM, int iD) {
                        etDate.setText(iD + "-" + (iM + 1) + "-" + iYear);
                    }
                }, iYear, iMonth, iDay);
                oDatePicker.show();
            }
        });
    }

    public String convertTime(int iH, int iM) {
        String strTime = "";
        String strAmPM = " AM";
        if (iH > 12) {
            iH = iH - 12;
            strAmPM = " PM";
        } else if (iH == 12) {
            strAmPM = " PM";
        } else if (iH == 0) {
            iH = 12;
        }
        String strMinute = "";
        if (iM <= 9) {
            strMinute = "0" + iM;
        } else {
            strMinute = "" + iM;
        }
        return (strTime = iH + ":" + strMinute + strAmPM);
    }

}
