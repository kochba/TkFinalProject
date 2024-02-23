package com.example.tkfinalproject.RePostry;

import android.content.Context;

import com.example.tkfinalproject.UI.SignUp.SignUp;

public class Repostry {
    MyDataBaseHelper myDatabaseHelper;
    Context Mycontext;
    public Repostry(Context context)
    {
        myDatabaseHelper = new MyDataBaseHelper(context);
        Mycontext = context;
    }

    public int RNewSignUp(User user)  {
        if (!myDatabaseHelper.DoesUserNameExisit(user.getUsername())){
            if (myDatabaseHelper.AddUser(user)) {
                return 0;
            } else {
                return 1;
            }
        }
        else {
            return 2;
        }

    }
    public boolean IsExisit(String name,String pass){
       return myDatabaseHelper.IsExist(name,pass);
    }
}
