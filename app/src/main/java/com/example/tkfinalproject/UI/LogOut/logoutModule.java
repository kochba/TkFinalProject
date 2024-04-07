package com.example.tkfinalproject.UI.LogOut;

import android.content.Context;
import android.widget.Toast;

import com.example.tkfinalproject.RePostry.Repostry;
import com.example.tkfinalproject.RePostry.User;
import com.example.tkfinalproject.Utility.UtilityClass;

public class logoutModule {
    private Repostry repostry;
    Context myContex;
    UtilityClass utilityClass;
    public logoutModule(Context context)
    {
        repostry = new Repostry(context);
        utilityClass = new UtilityClass(context);
        myContex = context;
    }
    public void makeLogout(){
        if (utilityClass.isConected()){
            Toast.makeText(myContex, "עבד יזונה", Toast.LENGTH_SHORT).show();
        }
    }
}
