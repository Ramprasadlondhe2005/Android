package com.om.progressdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    ProgressBar Pbar;
    Button btnShow;
    int progress=0;

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        Pbar=findViewById(R.id.Pbar);
        btnShow=findViewById(R.id.btnShow);

        btnShow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        while(progress < Pbar.getMax())
                        {
                            progress+=10;
                            try
                            {
                                Thread.sleep(100);
                            }
                            catch (InterruptedException e){}
                            Pbar.setProgress(progress);
                        }
                    }
                }).start();
            }
        });
    }
}