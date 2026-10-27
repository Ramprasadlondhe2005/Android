package com.ram.callingintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    EditText etxtNum;
    Button btnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxtNum = findViewById(R.id.etxtNum);
        btnCall = findViewById(R.id.btnCall);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String MobileNumber = etxtNum.getText().toString();
                Intent oI = new Intent(Intent.ACTION_DIAL);
                oI.setData(Uri.parse("tel:" + MobileNumber));
                startActivity(oI);
            }
        });


    }
}