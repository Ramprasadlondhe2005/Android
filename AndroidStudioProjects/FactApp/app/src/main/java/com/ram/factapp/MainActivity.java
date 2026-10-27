package com.ram.factapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    EditText etNo;
    Button btnFact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNo=findViewById(R.id.editNo1);
        btnFact=findViewById(R.id.button);
        btnFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int iNo=Integer.parseInt(etNo.getText().toString());
                Intent intent=new Intent(MainActivity.this,DisplayFact.class);
                intent.putExtra("Fact",iNo);
                startActivity(intent);
            }
        });
    }
}
