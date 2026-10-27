package com.om.implicitdemo;

import android.annotation.SuppressLint;
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

    Button btnShow;
    EditText et1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow=findViewById(R.id.btnShow);
        et1=findViewById(R.id.et1);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String strUrl=et1.getText().toString();
                if(!strUrl.isEmpty())
                {
                    Intent oI=new Intent(Intent.ACTION_VIEW, Uri.parse(strUrl));
                    startActivity(oI);
                }
                else
                {
                    et1.setError("Enter Proper URL");
                }

            }
        });
    }
}