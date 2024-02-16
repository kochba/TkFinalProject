package com.example.tkfinalproject.UI.Login;

import android.content.Context;

import com.example.tkfinalproject.RePostry.Repostry;

public class loginModule {
    Repostry repostry;
    public loginModule(Context context){
        repostry = new Repostry(context);
    }
}
