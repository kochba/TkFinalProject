package com.example.tkfinalproject.UI.SignUp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import com.example.tkfinalproject.R;
import com.example.tkfinalproject.RePostry.User;
import com.example.tkfinalproject.UI.FirstPage.FirstPage;
import com.example.tkfinalproject.UI.Login.login;

import java.util.jar.Attributes;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText name , pass ,eqpass;
    private Button btn;
    SharedPreferences sp;
    String Un,Up;
    Boolean PV = true;
    Boolean Pveq = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn = findViewById(R.id.Submit);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.passowrd);
        eqpass = findViewById(R.id.passowrdeq);
        btn.setOnClickListener(this);
        sp = getSharedPreferences("MyUserPerfs" , Context.MODE_PRIVATE);
        pass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=pass.getRight()-pass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=pass.getSelectionEnd();
                        if(PV){
//set drawable image here
                            pass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_off_24,0);
//for hide password
                            pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            PV=false;
                        }else {
//set drawable image here
                            pass.setCompoundDrawablesRelativeWithIntrinsicBounds( 0, 0, R.drawable.baseline_visibility_24, 0);
//for show password
                            pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            PV=true;
                        }
                        pass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });
        eqpass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=eqpass.getRight()-eqpass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=eqpass.getSelectionEnd();
                        if(Pveq){
//set drawable image here
                            eqpass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_off_24,0);
//for hide password
                            eqpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            Pveq=false;
                        }else {
//set drawable image here
                            eqpass.setCompoundDrawablesRelativeWithIntrinsicBounds( 0, 0, R.drawable.baseline_visibility_24, 0);
//for show password
                            eqpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            Pveq=true;
                        }
                        eqpass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

    }




    @Override
    public void onClick(View v) {
        if (name.getText().length() < 8){
            //aletr קצר משמונה
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("יש בעיה חבר!");
            adb.setMessage("שם משתמש קצר משמונה");
            adb.setCancelable(false);
            adb.setPositiveButton("הבנתי", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            adb.create().show();
        }
        else if (pass.getText().length() < 6){
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("יש בעיה חבר!");
            adb.setMessage("סיסמה קצרה מ6");
            adb.setCancelable(false);
            adb.setPositiveButton("הבנתי", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            adb.create().show();
        }
        else if (!pass.getText().toString().equals(eqpass.getText().toString())) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("יש בעיה חבר!");
            adb.setMessage("האימות והסיסמה לא זהים");
            adb.setCancelable(false);
            adb.setPositiveButton("הבנתי", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            adb.create().show();
        }
        else {
            ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            if (isConnected){
                User user = new User(name.getText().toString().trim(),pass.getText().toString().trim());
                Intent intent = new Intent(this, login.class);
                startActivity(intent);
            }
            else {
                AlertDialog.Builder adb = new AlertDialog.Builder(this);
                adb.setTitle("יש בעיה חבר!");
                adb.setMessage("אין אינטרנט חבר אי אפשר להירשם");
                adb.setCancelable(false);
                adb.setPositiveButton("הבנתי", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                adb.create().show();

            }


        }
    }
}