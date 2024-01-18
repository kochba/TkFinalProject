package com.example.tkfinalproject.UI.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tkfinalproject.R;
import com.example.tkfinalproject.UI.FirstPage.FirstPage;
import com.example.tkfinalproject.UI.mainactivity.MainActivity;

public class login extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private EditText username,userpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn = findViewById(R.id.approve);
        username = findViewById(R.id.usered);
        username = findViewById(R.id.passed);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, FirstPage.class);
        startActivity(intent);
    }
}