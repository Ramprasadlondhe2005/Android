package com.om.dialerapp;

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

public class MainActivity extends AppCompatActivity {
    EditText etcall;
    Button btnDialer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etcall=findViewById(R.id.etcall);
        btnDialer=findViewById(R.id.btnDialer);

        btnDialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String strcall=etcall.getText().toString();
                if(strcall.isEmpty())
                {
                    etcall.setError("Please Enter Mobile Num");
                }
                else
                {
                    Intent oI=new Intent(Intent.ACTION_CALL);
                    oI.setData(Uri.parse("tel:"+strcall));
                    startActivity(oI);
                }

            }
        });

    }
}