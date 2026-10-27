package com.example.identiauthentication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.usernameSignUp);
        password = findViewById(R.id.passwordSignUp);
        Button btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(v -> {
            String user = username.getText().toString().trim();
            String pass = password.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Fields can't be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save username and password in SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Username", user);
            editor.putString("Password", pass);
            editor.apply();

            Toast.makeText(SignUpActivity.this, "Sign-Up Successful! Please sign in.", Toast.LENGTH_LONG).show();

            // Redirect to Sign-In page
            Intent intent = new Intent(SignUpActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
