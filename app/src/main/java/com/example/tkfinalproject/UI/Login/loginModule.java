package com.example.tkfinalproject.UI.Login;

import android.content.Context;

import com.example.tkfinalproject.RePostry.Repostry;
import com.example.tkfinalproject.RePostry.User;

public class loginModule {
    Repostry repostry;
    public loginModule(Context context){
        repostry = new Repostry(context);
    }

    public boolean Checkuser(User user){
       return repostry.IsExisit(user.getUsername(),user.getPass());
    }
}
