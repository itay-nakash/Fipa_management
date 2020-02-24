package com.example.itay.fipamanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent myIntent;
    String userName = "", password = "";
    TextView userNameTv, passwordTv, errorTv;
    EditText userNameET, passwordET;
    Button loginBtn;
    Boolean isSuperAdmin = false;// Ofir and Shahak

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVariables();
        initializeListener(loginBtn);
    }

    public void initializeVariables() {
        myIntent = new Intent(MainActivity.this,PartiesActivity.class);
        userNameTv = findViewById(R.id.username_tv);
        passwordTv = findViewById(R.id.password_tv);
        errorTv = findViewById(R.id.error_tv);
        userNameET = findViewById(R.id.username_editText);
        passwordET = findViewById(R.id.password_editText);
        loginBtn = findViewById(R.id.login_btn);
    }

    public void initializeListener(Button loginBtn) {

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEditTextData();
                if (checkUserLogin()) {
                    sendIntent();
                }else{
                    errorTv.setText(getString(R.string.wrong_login));
                }
            }
        });
    }

    public void getEditTextData() {
        userName = userNameET.getText().toString();
        password = passwordET.getText().toString();
    }

    public boolean checkUserLogin() {
        //isUser(String userName,String password) - will give me 0,1,2/Enum 0-not a user, 1-user, 2-superAdmin
        int answer = 1;
        boolean isUser = false;
        switch (answer) {
            case 0:
                isUser = false;
                isSuperAdmin = false;
                break;
            case 1:
                isUser = true;
                isSuperAdmin = false;
                break;
            case 2:
                isUser = true;
                isSuperAdmin = true;
                break;
        }
        return isUser;
    }

    public void sendIntent(){
        myIntent.putExtra("isSuperAdmin", isSuperAdmin);
        MainActivity.this.startActivity(myIntent);
    }
}
