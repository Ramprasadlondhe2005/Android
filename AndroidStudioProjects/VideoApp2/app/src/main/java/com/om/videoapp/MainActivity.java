package com.om.videoapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
public class MainActivity extends Activity implements OnClickListener{
    Button btnVideo;
    VideoView recordView;
    Intent oin;
    Uri videoUri;
    final static int VIDEO_REQUEST = 1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVideo=(Button)findViewById(R.id.button1);
        recordView=(VideoView)findViewById(R.id.videoView1);

        btnVideo.setOnClickListener(this);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==VIDEO_REQUEST && resultCode==RESULT_OK)
        {
            recordView.setVisibility(View.VISIBLE);
            assert recordView!=null;
            videoUri=data.getData();
            recordView.setVideoURI(videoUri);
            recordView.setMediaController(new MediaController(getApplicationContext()));
            recordView.requestFocus();
            recordView.start();

        }
    }
    @Override
    public void onClick(View arg0)
    {
        oin =new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
        if(oin.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(oin, VIDEO_REQUEST);
        }
    }
}
