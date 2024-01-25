package com.example.tkfinalproject.UI.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.tkfinalproject.R;
import com.example.tkfinalproject.UI.FirstPage.FirstPage;
import com.example.tkfinalproject.UI.mainactivity.MainActivity;

public class login extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private CheckBox checkBox;
    private EditText username,userpass;
    Boolean Pveq = true;
    SharedPreferences sp;
    String Un,Up;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //לעשות תהליך של התחבורת אוטמוטית לפי הshared prefernce
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn = findViewById(R.id.approve);
        checkBox = findViewById(R.id.stayconnected);
        username = findViewById(R.id.usered);
        userpass = findViewById(R.id.passed);
        btn.setOnClickListener(this);
        sp = getSharedPreferences("MyUserPerfs" , Context.MODE_PRIVATE);
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
        //לעשות בדיקת אינטרנט ולבדוק שהנתונים קיימים במערכת
        //ניתן להתחבר אם כבר הייתה כניסה והוא קיים בDb
        if (checkBox.isChecked()){
            Un = username.getText().toString().trim();
            Up = userpass.getText().toString().trim();
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("UserName",Un);
            editor.putString("UserName",Up);
            editor.commit();
            Intent intent = new Intent(this, login.class);
            startActivity(intent);

        }
        Intent intent = new Intent(this, FirstPage.class);
        startActivity(intent);
    }
}