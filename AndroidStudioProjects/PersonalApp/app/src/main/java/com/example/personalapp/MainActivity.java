package com.example.PersonalApp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name,mark;
    Button btn,btn2;
    TextView result;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        mark = findViewById(R.id.mark);
        btn = findViewById(R.id.btn);
        result = findViewById(R.id.result);
        btn2=findViewById(R.id.btn2);
    }
    public void Data(View v)
    {

        String nm=name.getText().toString();
        float m=Float.parseFloat(mark.getText().toString());

        result.setText("Name="+nm+"    Mark="+m);

        Toast.makeText(MainActivity.this, "Name=" + nm + " Marks=" + m, Toast.LENGTH_LONG).show();
    }
    public void Reset(View v)
    {
        result.setText(" ");

    }
}
