package com.example.bcolor;

import static android.graphics.Color.rgb;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    FrameLayout oBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oBack=findViewById(R.id.oBack);

    }

    public void BackColor(View v)
    {
        if(v.getId()==R.id.btnRed)
        {
            oBack.setBackgroundColor(Color.RED);
        }
        else if(v.getId()==R.id.btnBlack)
        {
            oBack.setBackgroundColor(Color.BLACK);
        }
        else if(v.getId()==R.id.btnBlue)
        {
            oBack.setBackgroundColor(Color.BLUE);
        }
        else if(v.getId()==R.id.btnCyan)
        {
            oBack.setBackgroundColor(Color.CYAN);
        }
        else if(v.getId()==R.id.btnGreen)
        {
            oBack.setBackgroundColor(Color.GREEN);
        }
        else if(v.getId()==R.id.btnMagenta)
        {
            oBack.setBackgroundColor(Color.MAGENTA);
        }
        else if (v.getId() == R.id.btnPink)
        {
            oBack.setBackgroundColor(Color.rgb(234,54,128));
        }
        else if(v.getId()==R.id.btnWhite)
        {
            oBack.setBackgroundColor(Color.WHITE);
        }
        else if(v.getId()==R.id.btnYellow)
        {
            oBack.setBackgroundColor(Color.YELLOW);
        }
    }
}