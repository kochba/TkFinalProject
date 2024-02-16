package com.example.tkfinalproject.Utility;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class UtilityClass {
    Context Mycontext;
    public UtilityClass(Context context){
        Mycontext = context;
    }
    //לשים לב
//    public Boolean isConected(){
//        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
//        return isConnected;
//    }
}
