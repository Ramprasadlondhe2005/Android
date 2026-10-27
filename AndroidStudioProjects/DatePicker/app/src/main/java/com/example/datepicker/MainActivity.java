package com.example.datepicker;

import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    DatePicker date;
    TextView tvdate;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.date);
        tvdate = findViewById(R.id.tvdate);

        date.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int iY, int iM, int
                    iD) {
                tvdate.setText("Date: " + iD + "/" + (iM + 1) + "/" + iY);
            }
        });
    }
}