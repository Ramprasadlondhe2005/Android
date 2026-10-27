package com.example.receivemessage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start ReceiveSMSActivity directly
        Intent intent = new Intent(this, ReceiveSMSActivity.class);
        startActivity(intent);

        // Finish MainActivity
        finish();
    }
}
