package com.example.tkfinalproject.RePostry;

import android.content.Context;

public class Repostry {
    MyDataBaseHelper myDatabaseHelper;
    MyFireBaseHelper fireBaseHelper;
    Context Mycontext;
    private static User currentUser;
    public Repostry(Context context)
    {
        myDatabaseHelper = new MyDataBaseHelper(context);
        fireBaseHelper = new MyFireBaseHelper(context);
        Mycontext = context;
        //database = FirebaseDatabase.getInstance();
        //reference = database.getReference("Users");
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
       // if (!myDatabaseHelper.DoesUserNameExisit(user.getUsername())){
        if (!doesUserNameExisit(user.getUsername())){
            if (myDatabaseHelper.AddUser(user)) {
                fireBaseHelper.addUser(user);
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
            if (!doesUserNameExisit(user.getUsername())){
                if (updatedata(user,1)) {
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
            if (updatedata(user,2)) {
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
    private boolean updatedata(User user, int code){
        if (code == 1){
            if (myDatabaseHelper.updateData(user,currentUser)){
                fireBaseHelper.update(user);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (myDatabaseHelper.uptadePass(user)) {
                fireBaseHelper.update(user);
                return true;
            } else {
                return false;
            }
        }
    }
    private boolean doesUserNameExisit(String userName){
        return !fireBaseHelper.userNameExist(userName);

    }

    public boolean IsExisit(String name,String pass){
//        Boolean X = fireBaseHelper.checkUserExistence(new User(name,pass));
//        Boolean Y = myDatabaseHelper.IsExist(name,pass);
        if (fireBaseHelper.checkUserExistence(new User(name,pass))){
            setCurrentUser(new User(name,pass));
            return true;
        }
        else {
            return false;
        }
    }
}