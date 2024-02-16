package com.example.tkfinalproject.UI.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tkfinalproject.R;
import com.example.tkfinalproject.RePostry.User;
import com.example.tkfinalproject.UI.Login.login;
import com.example.tkfinalproject.UI.SignUp.SignUp;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button log,sin;
    MainActivityModule mainActivityModule;
    User user;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);closeContextMenu();
        mainActivityModule = new MainActivityModule(this);
        sp = getApplicationContext().getSharedPreferences("MyUserPerfs", Context.MODE_PRIVATE);
        user = new User(sp.getString("UserName",""),sp.getString("UserPass",""));
        if (mainActivityModule.StartLogin()){

        }
        log = findViewById(R.id.login);
        sin = findViewById(R.id.signup);
        log.setOnClickListener(this);
        sin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == log){
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(MainActivity.this, SignUp.class);
            startActivity(intent);        }
    }
}