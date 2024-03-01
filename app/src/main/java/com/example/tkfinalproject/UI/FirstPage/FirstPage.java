package com.example.tkfinalproject.UI.FirstPage;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tkfinalproject.R;
import com.example.tkfinalproject.UI.UpdateUser.UpdateUser;

public class FirstPage extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Intent intent;
    OnBackPressedCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        imageView = findViewById(R.id.userphoto);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent(FirstPage.this, UpdateUser.class);
        startActivity(intent);
    }
}