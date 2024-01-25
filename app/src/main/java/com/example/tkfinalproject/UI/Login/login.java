package com.example.tkfinalproject.UI.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tkfinalproject.R;
import com.example.tkfinalproject.UI.FirstPage.FirstPage;
import com.example.tkfinalproject.UI.mainactivity.MainActivity;

public class login extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private EditText username,userpass;
    Boolean Pveq = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn = findViewById(R.id.approve);
        username = findViewById(R.id.usered);
        userpass = findViewById(R.id.passed);
        btn.setOnClickListener(this);
        userpass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=userpass.getRight()-userpass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=userpass.getSelectionEnd();
                        if(Pveq){
                            userpass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_off_24,0);
                            userpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            Pveq=false;
                        }else {
                            userpass.setCompoundDrawablesRelativeWithIntrinsicBounds( 0, 0, R.drawable.baseline_visibility_24, 0);
                            userpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            Pveq=true;
                        }
                        userpass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, FirstPage.class);
        startActivity(intent);
    }
}