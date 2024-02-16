package com.example.tkfinalproject.UI.mainactivity;

import android.content.Context;

import com.example.tkfinalproject.RePostry.Repostry;

public class MainActivityModule {
    Repostry repostry;
    public MainActivityModule(Context context){
        repostry = new Repostry(context);
    }

    public boolean StartLogin(){
        return true;
    }

}
