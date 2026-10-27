package com.example.temp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String a=null;
    EditText etTemp;
    ToggleButton tgButton;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTemp=findViewById(R.id.etTemp);
        tgButton=findViewById(R.id.tgButton);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(tgButton.isChecked())
                {
                    a=Double.parseDouble(String.valueOf(etTemp.getText()));
                    Double b=a*9/5+32;
                    String r= String.valueOf(b);
                    Toast.makeText(MainActivity.this, r+"F", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    a=Double.parseDouble(String.valueOf(etTemp.getText()));
                    Double b=a-32;
                    Double c=b*5/9;
                    String r=String.valueOf(c);
                    Toast.makeText(MainActivity.this, r+"C", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}