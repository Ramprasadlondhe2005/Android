package com.example.myloginwindow;

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
    EditText uname,pass;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.activity_main);
        uname=findViewById(R.id.uname);
        pass=findViewById(R.id.pass);
        btnlogin=findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUser=uname.getText().toString();
                String strPass=pass.getText().toString();

                if(strUser.equals("abc") && strPass.equals("abc@123"))
                {
                    Toast.makeText(MainActivity.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Loin Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}