package com.example.tkfinalproject.UI.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tkfinalproject.R;
import com.example.tkfinalproject.RePostry.User;
import com.example.tkfinalproject.UI.FirstPage.FirstPage;
import com.example.tkfinalproject.UI.Login.login;
import com.example.tkfinalproject.UI.SignUp.SignUp;
import com.example.tkfinalproject.Utility.LocaleHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button log,sin;
    MainActivityModule mainActivityModule;
    Intent intent;
    User user;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        closeContextMenu();
        LocaleHelper.setLocale(this, "iw");
        log = findViewById(R.id.login);
        sin = findViewById(R.id.signup);
        mainActivityModule = new MainActivityModule(this);
        intent = new Intent(MainActivity.this, FirstPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        sp = getApplicationContext().getSharedPreferences("MyUserPerfs", Context.MODE_PRIVATE);
        user = new User(sp.getString("UserName",""),sp.getString("UserPass",""));
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if (isConnected){
            mainActivityModule.StartLogin(user, new com.example.tkfinalproject.RePostry.MyFireBaseHelper.checkUser() {
                @Override
                public void onCheckedUser(boolean flag) {
                    if (flag){
                        mainActivityModule.setUser(user);
                        startActivity(intent);
                    }
                    else {
                        setClickTrue();
                    }
                }
            });
        }
        else {
            setClickTrue();
        }
        log.setOnClickListener(this);
        sin.setOnClickListener(this);
    }
    private void setClickTrue(){
        log.setEnabled(true);
        sin.setEnabled(true);
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