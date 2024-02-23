package com.example.tkfinalproject.UI.FirstPage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tkfinalproject.R;

public class FirstPage extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        imageView = findViewById(R.id.userphoto);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "AAA", Toast.LENGTH_SHORT).show();
    }
}