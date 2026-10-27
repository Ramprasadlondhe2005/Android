package com.om.genderdemo;

import android.os.Bundle;
import android.widget.RadioButton;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioButton rbMale,rbFemale;
    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rbMale=findViewById(R.id.rbMale);
        rbFemale=findViewById(R.id.rbFemale);

    }
    public void showGender(View view)
    {
        if(rbMale.isChecked())
        {
            Toast.makeText(this, "You selected male", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "YOu selected Female", Toast.LENGTH_SHORT).show();
        }
    }
}