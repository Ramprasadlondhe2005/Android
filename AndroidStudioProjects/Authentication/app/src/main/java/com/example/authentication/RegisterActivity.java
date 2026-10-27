
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hostel_and_room_finder.FirebaseClasses.RegisterUserHelperClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRegistrationActivity extends AppCompatActivity {

    EditText user_et_name,user_et_mobile_no,user_et_email_id,user_et_username,user_et_password;
    Button user_register_btn;
    CheckBox user_chk_pass_show_hide;
    TextView user_tv_go_login_page,new_user_tv;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_regestration);


        user_chk_pass_show_hide = findViewById(R.id.user_chk_pass_show_hide);
        user_register_btn = findViewById(R.id.user_register_btn);
        user_et_name = findViewById(R.id.user_et_name);
        user_et_mobile_no = findViewById(R.id.user_et_mobile_no);
        user_et_email_id = findViewById(R.id.user_et_email_id);
        user_et_username = findViewById(R.id.user_et_username);
        user_et_password = findViewById(R.id.user_et_password);
        user_tv_go_login_page = findViewById(R.id.user_tv_go_login_page);

        user_chk_pass_show_hide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    user_et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    user_et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });



        user_register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_et_name.getText().toString().isEmpty()) {
                    user_et_name.setError("Please Enter Your Name");
                } else if (user_et_mobile_no.getText().toString().isEmpty()) {
                    user_et_mobile_no.setError("Please Enter Your Mobile NO");
                } else if (user_et_mobile_no.getText().toString().length()<10 || user_et_mobile_no.getText().toString().length()>10) {
                    user_et_mobile_no.setError("Mobile No Must Be 10 Digit");
                } else if (user_et_email_id.getText().toString().isEmpty()) {
                    user_et_email_id.setError("Please Enter Your Email Id");
                } else if (!user_et_email_id.getText().toString().contains("@") || !user_et_email_id.getText().toString().contains(".com")) {
                    user_et_email_id.setError("Invaild Email Id");
                } else if (user_et_username.getText().toString().isEmpty()) {
                    user_et_username.setError("Please Enter Your Username");
                } else if (user_et_username.getText().toString().length()<8) {
                    user_et_username.setError("Username Must Be Grater Than 8 Character");
                } else if (!user_et_username.getText().toString().matches( "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*+=?-]).{8,15}$")) {
                    user_et_username.setError("username must contain Upper case and Lower Case latter and number and special symbol");
                } else if (user_et_password.getText().toString().isEmpty()) {
                    user_et_password.setError("PLease Enter Your Password");
                } else if (user_et_password.getText().toString().length()<8) {
                    user_et_password.setError("Password Must Be Grater 8 Character");
                }else
                {
                    registerUser();
                }
            }
        });

    }

    private void registerUser() {
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("User_Profile");

        String fullName = user_et_name.getText().toString();
        String userName = user_et_username.getText().toString();
        String password = user_et_password.getText().toString();
        String mobileNo = user_et_mobile_no.getText().toString();
        String emailId = user_et_email_id.getText().toString();

        RegisterUserHelperClass registerUserHelperClass = new RegisterUserHelperClass(fullName,userName,password,mobileNo,emailId);
        databaseReference.child(userName).setValue(registerUserHelperClass)
                .addOnSuccessListener(aVoid ->{
                    Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show();
                    Intent i1 = new Intent(UserRegistrationActivity.this, UserLoginActivity.class);
                    startActivity(i1);
                    finish();
                })
                .addOnFailureListener(e ->{
                    Toast.makeText(this, "Unable To Register User", Toast.LENGTH_SHORT).show();
                });
    }

}