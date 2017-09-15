package com.example.sunrin.sunrin02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static User []user=new User[200];
    static int user_num=0;
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user[0]=new User("asdf","asdf");
        user_num++;

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
    }
    public void onLoginClicked(View v){
        for(int i=0; i<user_num; i++){
            if(user[i].id.equals(username.getText().toString()) &&
                    user[i].password.equals(password.getText().toString())){
                Intent intent = new Intent(MainActivity.this, LoginedActivity.class);
                startActivity(intent);
                return ;
            }
        }
        Toast.makeText(getApplicationContext(), "Check your ID and Password", Toast.LENGTH_SHORT).show();
    }
    public void onSignupClicked(View v){
        Intent intent = new Intent(MainActivity.this, SignupActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==0){
            String username_str=data.getStringExtra("USERNAME");
            username.setText(username_str);
        }
    }

}
