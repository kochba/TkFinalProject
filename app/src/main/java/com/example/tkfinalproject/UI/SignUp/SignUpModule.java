package com.example.tkfinalproject.UI.SignUp;


import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;


import com.example.tkfinalproject.RePostry.MyDataBaseHelper;
import com.example.tkfinalproject.RePostry.Repostry;
import com.example.tkfinalproject.RePostry.User;
import com.example.tkfinalproject.UI.Login.login;


public class SignUpModule {
    Repostry repostry;
    public SignUpModule(Context context){
        repostry = new Repostry(context);
    }


    public int NewSignUp(User user)  {
        return repostry.RNewSignUp(user);
    }

}
