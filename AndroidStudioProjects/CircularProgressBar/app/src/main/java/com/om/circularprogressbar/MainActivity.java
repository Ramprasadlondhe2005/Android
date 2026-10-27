package com.om.circularprogressbar;


import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
ProgressBar pbar;
int iProgress=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbar=findViewById(R.id.pbar);
        new Thread(new Runnable() {
            @Override
            public void run()
            {
                while (iProgress<pbar.getMax())
                {
                    iProgress+=5;
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {}
                    pbar.setProgress(iProgress);
                    }
                }
            }).start();

    }
}