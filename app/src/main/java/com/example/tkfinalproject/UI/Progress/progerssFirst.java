package com.example.tkfinalproject.UI.Progress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.tkfinalproject.R;
import com.example.tkfinalproject.UI.FirstPage.FirstPage;

public class progerssFirst extends AppCompatActivity implements View.OnClickListener {
    ProgressBar progressBar;
    private static final long TOTAL_TIME_MILLIS = 7000;
    Intent intent;
    private CountDownTimer countDownTimer;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progerss_first);
        progressBar = findViewById(R.id.progressBar);
        btn = findViewById(R.id.progrssbtn);
        btn.setOnClickListener(this);
        // Initialize the CountDownTimer
        countDownTimer = new CountDownTimer(TOTAL_TIME_MILLIS, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Calculate progress percentage
                int progress = (int) (((TOTAL_TIME_MILLIS - millisUntilFinished) * 100) / TOTAL_TIME_MILLIS);
                progressBar.setProgress(progress);
            }

            @Override
            public void onFinish() {
                // Do something when the timer finishes (if needed)
                intent = new Intent(progerssFirst.this,progressSecond.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        };

        // Start the timer
        countDownTimer.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cancel the timer to avoid memory leaks
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    public void onClick(View view) {
        intent = new Intent(progerssFirst.this, FirstPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}