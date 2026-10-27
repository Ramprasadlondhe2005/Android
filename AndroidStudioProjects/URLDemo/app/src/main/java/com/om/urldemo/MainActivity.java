package com.om.urldemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnNavigate;
    EditText eturl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNavigate=findViewById(R.id.btnNavigate);
        eturl=findViewById(R.id.eturl);

        btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String strurl=eturl.getText().toString();
                if(strurl.isEmpty())
                {
                    eturl.setError("Please Enter Url");
                }
                else
                {
                    Intent oI=new Intent(Intent.ACTION_VIEW, Uri.parse(strurl));
                    startActivity(oI);

                }

            }
        });


    }
}