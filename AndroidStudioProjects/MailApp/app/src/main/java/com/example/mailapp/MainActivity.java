package com.example.mailapp;

import android.content.Intent;
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
    EditText etTo,etSub,etmsg;
    Button btnMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTo=findViewById(R.id.etTo);
        etSub=findViewById(R.id.etSub);
        etmsg=findViewById(R.id.etMsg);
        btnMail=findViewById(R.id.btnSend);

        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               String strTo=etTo.getText().toString();
               String strSub=etSub.getText().toString();
               String strMsg=etmsg.getText().toString();

                Intent OI=new Intent(Intent.ACTION_SEND);
                OI.putExtra(Intent.EXTRA_EMAIL, new String[]{strTo});
                OI.putExtra(Intent.EXTRA_EMAIL, new String[]{strSub});
                OI.putExtra(Intent.EXTRA_EMAIL, new String[]{strMsg});

                OI.setType("message/rfc822");
                startActivity(OI);


            }
        });

    }
}