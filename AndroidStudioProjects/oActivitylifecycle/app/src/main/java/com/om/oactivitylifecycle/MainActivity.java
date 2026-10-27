package com.om.oactivitylifecycle;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        Log.d("Method1","I am in onCreate");

    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("Method2","I am in onStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("Method3","I am in onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("Method4","I am in onPause");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("Method5","I am in onStop");

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("Method6","I am in onDestroy");
    }
}