package com.om.progressdialog;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog oPD=new ProgressDialog(MainActivity.this);
                oPD.setMax(1000);
                oPD.setMessage("downloading File..");
                oPD.setIndeterminate(false);
                oPD.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                oPD.show();

                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        int iProgress=0;
                        while (iProgress<oPD.getMax())
                        {
                            iProgress+=5;
                            try
                            {
                                Thread.sleep(100);
                            }
                            catch (InterruptedException e) {}
                            oPD.setProgress(iProgress);
                        }
                        oPD.dismiss();

                    }
                }).start();

            }
        });



    }
}