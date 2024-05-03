package com.example.tkfinalproject.Utility;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;

import com.example.tkfinalproject.RePostry.MyDataBaseHelper;
import com.example.tkfinalproject.RePostry.MyFireBaseHelper;
import com.example.tkfinalproject.RePostry.User;

public class FireBaseService extends Service {
    MyFireBaseHelper myFireBaseHelper;
    MyDataBaseHelper myDataBaseHelper;
    SaveIon ionComplete;
    int code;
    User user;
    public FireBaseService(Context context) {
        myFireBaseHelper = new MyFireBaseHelper(context);
        myDataBaseHelper = new MyDataBaseHelper(context);
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Your code to start asynchronous tasks should go here
        performBackgroundTask();
        code = intent.getIntExtra("code",99);
        user = (User) intent.getSerializableExtra("user");
        ionComplete = (SaveIon) intent.getSerializableExtra("ionCompleteInt");
        // Ensure service keeps running until work is complete
        return START_STICKY;
    }
    private void performBackgroundTask() {
        // Implement your asynchronous task here
        switch (code){
            case 1:
                adduser();
                break;
            case 2:
                update();
                break;
            case 3:
                userNameExsIts();
                break;
            case 4:
                userExsits();
                break;
            case 5:
                getUserByName();
                break;
        }
        AsyncTask.execute(() -> {
            // Code for your asynchronous task
            // Example: fetching data from a remote server
            fetchDataFromServer();
        });
    }


    private void fetchDataFromServer() {
        // Simulate fetching data from a server (e.g., using Retrofit, Volley, etc.)
        // For demonstration, we'll use a simple delay
        try {
            Thread.sleep(5000); // Simulate 5 seconds delay
            // Task completed, you can send a broadcast or update UI here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void adduser() {
        myFireBaseHelper.addUser(user, new IonComplete() {
            @Override
            public void onCompleteBool(boolean flag) {
                if (flag){
                    ionComplete.onCompleteInt(0);
                }
                else {
                    myDataBaseHelper.removeUser(user);
                    ionComplete.onCompleteInt(1);
                }
            }
        });
    }

    private void update() {
    }

    private void getUserByName() {
    }

    private void userExsits() {

    }

    private void userNameExsIts() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Clean up resources if needed
    }
}