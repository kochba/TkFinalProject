package com.example.tkfinalproject.RePostry;

import android.content.Context;

public class Repostry {
    MyDataBaseHelper myDatabaseHelper;
    Context Mycontext;
    private static User currentUser;
    public Repostry(Context context)
    {
        myDatabaseHelper = new MyDataBaseHelper(context);
        Mycontext = context;
    }

//    public Repostry(Context context , User myuser)
//    {
//        myDatabaseHelper = new MyDataBaseHelper(context);
//        Mycontext = context;
//        currentUser = myuser;
//    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        Repostry.currentUser = currentUser;
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

    public int Updateuser(User user)  {
        if (!user.getUsername().equals(getCurrentUser().getUsername())){
            if (!myDatabaseHelper.DoesUserNameExisit(user.getUsername())){
                if (myDatabaseHelper.updateData(user,getCurrentUser())) {
                    return 0;
                } else {
                    return 1;
                }
            }
            else {
                return 2;
            }
        }
        else {
            if (myDatabaseHelper.uptadePass(user)) {
                return 0;
            } else {
                return 1;
            }
        }

//        if (!myDatabaseHelper.DoesUserNameExisit(user.getUsername())){
//            if (myDatabaseHelper.updateData(user)) {
//                return 0;
//            } else {
//                return 1;
//            }
//        }
//        else {
//            return 2;
//        }
    }

    public boolean IsExisit(String name,String pass){
        if (myDatabaseHelper.IsExist(name,pass)){
            setCurrentUser(new User(name,pass));
            return true;
        }
        else {
            return false;
        }
    }
}