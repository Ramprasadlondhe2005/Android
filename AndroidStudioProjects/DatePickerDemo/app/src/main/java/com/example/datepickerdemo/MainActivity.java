package com.example.datepickerdemo;

import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TextView txtDate;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        datePicker=findViewById(R.id.datepicker);
        txtDate=findViewById(R.id.txtDate);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int iY, int iM, int iD) {

                    txtDate.setText("Date : "+iD+"/"+(iM+1)+"/"+iY);

                }
            });
        }

    }
}