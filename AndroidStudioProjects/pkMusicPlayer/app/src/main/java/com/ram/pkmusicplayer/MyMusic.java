package com.ram.pkmusicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyMusic extends Service
{
    MediaPlayer oMp;
    @Override
    public void onCreate()
    {
        super.onCreate();
        oMp=MediaPlayer.create(getApplicationContext(),R.raw.pk);
        oMp.setLooping(true);
    }

    @Override
    public void onStart(Intent intent, int startId)
    {
        super.onStart(intent, startId);
        oMp.start();
        Toast.makeText(getBaseContext(), "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        oMp.stop();
        Toast.makeText(getBaseContext(), "Start", Toast.LENGTH_SHORT).show();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
