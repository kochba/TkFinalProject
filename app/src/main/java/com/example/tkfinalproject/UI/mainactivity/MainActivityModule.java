package com.example.tkfinalproject.UI.mainactivity;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tkfinalproject.RePostry.Repostry;
import com.example.tkfinalproject.RePostry.User;

public class MainActivityModule {
    Repostry repostry;
    public MainActivityModule(Context context){
        repostry = new Repostry(context);
    }


    public boolean StartLogin(User user){
        return repostry.IsExisit(user.getUsername(),user.getPass());
    }

}
