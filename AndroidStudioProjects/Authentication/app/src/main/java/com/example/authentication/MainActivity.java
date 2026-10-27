

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText et_username, et_password;
    CheckBox chk_showpassword;
    Button btn_login;
    TextView tv_new_user;
    FirebaseDatabase database;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        // Initialize Firebase Database
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("User_Profile");

        et_username = findViewById(R.id.la_et_username);
        et_password = findViewById(R.id.la_et_password);
        chk_showpassword = findViewById(R.id.chk_pass_show_hide);
        btn_login = findViewById(R.id.login_btn);
        tv_new_user = findViewById(R.id.new_user_tv);

        // Show/Hide Password Toggle
        chk_showpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        // Login Button Click Listener
        btn_login.setOnClickListener(v -> {
            String username = et_username.getText().toString().trim();
            String password = et_password.getText().toString().trim();

            Log.d("UserLoginActivity", "Login Button Clicked");

            if (username.isEmpty()) {
                et_username.setError("Enter Username");
            } else if (username.length() < 5) {
                et_username.setError("Username Must Be Greater Than 5 Characters");
            } else if (password.isEmpty()) {
                et_password.setError("Enter Password");
            } else if (password.length() < 5) {
                et_password.setError("Password Must Be Greater Than 5 Characters");
            } else {
                LoginUser(username, password);
            }
        });

        // Register New User
        tv_new_user.setOnClickListener(v -> {
            Intent i = new Intent(UserLoginActivity.this, UserRegistrationActivity.class);
            startActivity(i);
            finish();
        });
    }

    private void LoginUser(String username, String password) {
        Query checkUserData = reference.orderByChild("username").equalTo(username);

        Log.d("UserLoginActivity", "Querying Firebase for username: " + username);

        checkUserData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("UserLoginActivity", "onDataChange called");

                if (snapshot.exists()) {
                    Log.d("UserLoginActivity", "User found: " + snapshot.getChildrenCount());

                    // Loop through the results if multiple users with the same username exist
                    for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                        String passwordFromDB = userSnapshot.child("password").getValue(String.class);

                        Log.d("UserLoginActivity", "Password from DB: " + passwordFromDB);

                        if (passwordFromDB != null && passwordFromDB.equals(password)) {
                            Log.d("UserLoginActivity", "Password matched!");
                            Toast.makeText(UserLoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                            // Redirect to Homepage Activity
                            Intent intent = new Intent(UserLoginActivity.this, HomepageActivity.class);
                            startActivity(intent);
                            finish();
                            return;
                        } else {
                            Log.d("UserLoginActivity", "Password mismatch");
                        }
                    }
                    et_password.setError("Invalid Password");
                    et_password.requestFocus();
                } else {
                    Log.d("UserLoginActivity", "User does not exist");
                    et_username.setError("User Does Not Exist");
                    et_username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("UserLoginActivity", "Database Error: " + error.getMessage());
                Toast.makeText(UserLoginActivity.this, "Database Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
