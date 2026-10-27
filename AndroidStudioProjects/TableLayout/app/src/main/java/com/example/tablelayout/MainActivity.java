package com.example.tablelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPass);
        btn = findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String pass = etPass.getText().toString();

                if (name.equals("ram") && pass.equals("ram@123")) {
                    Toast.makeText(MainActivity.this, "Login Successfully..!!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed..!!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}



