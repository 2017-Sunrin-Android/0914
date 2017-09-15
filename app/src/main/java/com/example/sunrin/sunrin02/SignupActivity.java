package com.example.sunrin.sunrin02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Sunrin on 2017-09-14.
 */

public class SignupActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText passwordCheck;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        passwordCheck=(EditText)findViewById(R.id.passwordCheck);
    }

    public void signupClick(View v){
        String username_str=username.getText().toString();
        String password_str=password.getText().toString();
        String passwordCheck_str=passwordCheck.getText().toString();
        if(password_str.equals(passwordCheck_str)){
            User user = new User(username_str,password_str);
            MainActivity.user[MainActivity.user_num++]=user;
            Intent intent =new Intent();
            intent.putExtra("USERNAME", username_str);
            setResult(200,intent);
            finish();
        }else{
            Toast.makeText(getApplicationContext(),"Check your password", Toast.LENGTH_SHORT).show();
        }
    }
}