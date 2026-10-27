package com.example.student;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    EditText name,mark;
    TextView result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        name = findViewById(R.id.name);
        mark = findViewById(R.id.mark);
        btn = findViewById(R.id.btn);


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String n1 = (name.getText().toString());
                    int b = Integer.parseInt(mark.getText().toString());

                    result.setText("Name=" +n1);

                }

            });

        }

    }
