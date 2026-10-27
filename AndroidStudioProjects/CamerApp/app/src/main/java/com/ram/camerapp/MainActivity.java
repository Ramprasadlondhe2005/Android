package com.ram.camerapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    int CAMERA_REQEST = 10;
    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
                Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(in, CAMERA_REQEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQEST && resultCode == RESULT_OK)
        {
            Bitmap bm = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(bm);
        }

    }

}