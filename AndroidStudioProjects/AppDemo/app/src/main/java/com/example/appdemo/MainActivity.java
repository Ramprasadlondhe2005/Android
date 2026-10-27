package com.example.appdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num1,num2;
    Button btn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        btn=findViewById(R.id.btn);
        result=findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int a = Integer.parseInt(num1.getText().toString());
                int b = Integer.parseInt(num2.getText().toString());
                int c = a + b;
                result.setText(Integer.toString(c));

            }
        });
    }
}