package com.example.identiauthentication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.usernameSignIn);
        password = findViewById(R.id.passwordSignIn);
        Button btnSignIn = findViewById(R.id.btnSignIn);
        TextView signUpLink = findViewById(R.id.signUpLink);

        btnSignIn.setOnClickListener(v -> {
            String user = username.getText().toString().trim();
            String pass = password.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(MainActivity.this, "Fields can't be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            // Retrieve saved credentials from SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            String savedUsername = sharedPreferences.getString("Username", null);
            String savedPassword = sharedPreferences.getString("Password", null);

            if (user.equals(savedUsername) && pass.equals(savedPassword)) {
                // Display a success message and keep user on the same screen
                Toast.makeText(MainActivity.this, "Welcome, " + user + "!", Toast.LENGTH_LONG).show();
            } else {
                // Invalid credentials
                Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
            }
        });

        signUpLink.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}
