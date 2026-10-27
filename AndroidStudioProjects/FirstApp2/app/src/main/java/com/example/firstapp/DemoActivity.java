package com.example.firstapp;

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

public class DemoActivity extends AppCompatActivity {
    TextView txtName;
    EditText etxtName;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        txtName=findViewById(R.id.txtName);
        etxtName=findViewById(R.id.etxtName);
        btnSubmit=findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=etxtName.getText().toString();
                txtName.setText(" "+name);

                Toast.makeText(DemoActivity.this,"Your Name is  "+name, Toast.LENGTH_LONG).show();
            }
        });
    }
}