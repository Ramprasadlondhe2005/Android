package com.om.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class mediaplayer extends service
{

    MediaPlayer omp;
    @Override
    public void onCreate()
    {
        super.onCreate();
        oMP=MediaPlayer.create(getApplicationContext(),R.raw.rang);
        oMP.setLooping(true);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        oMP.stop();
        Toast.makeText(getBaseContext(), "Music Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart(Intent intent, int startId)
    {
        super.onStart(intent, startId);
        oMP.start();
        Toast.makeText(getBaseContext(), "Music Started", Toast.LENGTH_SHORT).show();
    }

}
