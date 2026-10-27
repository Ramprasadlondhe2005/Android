package com.example.largestnumber;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txt1,txt2,txt3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int iNum1 = Integer.parseInt(txt1.getText().toString());
                int iNum2 = Integer.parseInt(txt2.getText().toString());
                int iNum3 = Integer.parseInt(txt3.getText().toString());

                int iLarge = 0;
                if (iNum1 > iNum2 && iNum1 > iNum3) {
                    iLarge = iNum1;
                } else if (iNum2 > iNum1 && iNum2 > iNum3) {
                    iLarge = iNum2;
                } else {
                    iLarge = iNum3;
                }
                Toast.makeText(MainActivity.this, "Largest Number"+iLarge, Toast.LENGTH_LONG).show();
            }
        });

    }
}