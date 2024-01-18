package com.example.tkfinalproject.UI.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tkfinalproject.R;
import com.example.tkfinalproject.UI.FirstPage.FirstPage;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText name , pass ,eqpass;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn = findViewById(R.id.Submit);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.passowrd);
        eqpass = findViewById(R.id.passowrdeq);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, FirstPage.class);
        startActivity(intent);
    }
}