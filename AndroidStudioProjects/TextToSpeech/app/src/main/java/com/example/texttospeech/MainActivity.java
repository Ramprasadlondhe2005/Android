package com.example.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener
{
    EditText etxt;
    TextToSpeech tts;
    Button btn;

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        etxt = findViewById(R.id.etxt);
        btn = findViewById(R.id.btn);
        tts = new TextToSpeech(this, this);
    }

    public void btnClick(View v)
    {
        String message = etxt.getText().toString().trim();
        if (message.equals(""))
        {
            etxt.setError("Enter Message to read.");
            return;
        }
        tts.speak(message, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int i)
    {
        tts.setLanguage(Locale.US);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        tts.stop();
        tts.shutdown();
    }
}
