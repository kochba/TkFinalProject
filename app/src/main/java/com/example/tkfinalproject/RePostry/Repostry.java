package com.example.tkfinalproject.RePostry;

import android.content.Context;

import com.example.tkfinalproject.Utility.IonComplete;

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

    public void RNewSignUp(User user,IonComplete.IonCompleteInt ionCompleteInt)  {
       // if (!myDatabaseHelper.DoesUserNameExisit(user.getUsername())){
        doesUserNameExisit(user.getUsername(), new MyFireBaseHelper.checkUser() {
            @Override
            public void onCheckedUser(boolean flag) {
                if (!flag){
                    if (myDatabaseHelper.AddUser(user)) {
                        fireBaseHelper.addUser(user);
                        ionCompleteInt.onCompleteInt(0);
                    }
                    else {
                        ionCompleteInt.onCompleteInt(1);
                    }
                }
                else {
                    ionCompleteInt.onCompleteInt(2);
                }
            }
        });
    }
    public void Updateuser(User user , IonComplete.IonCompleteInt ionCompleteInt)  {
        if (!user.getUsername().equals(getCurrentUser().getUsername())){
            doesUserNameExisit(user.getUsername(), new MyFireBaseHelper.checkUser() {
                @Override
                public void onCheckedUser(boolean flag) {
                    if (!flag){
                        if (updatedata(user,1)) {
                            ionCompleteInt.onCompleteInt(0);
                        } else {
                            ionCompleteInt.onCompleteInt(1);
                        }
                    }
                    else {
                        ionCompleteInt.onCompleteInt(2);
                    }
                }
            });
        }
        else {
            if (updatedata(user,2)) {
                ionCompleteInt.onCompleteInt(0);
            } else {
                ionCompleteInt.onCompleteInt(1);
            }
        }
    }
//    public void Updateuser(User user , IonComplete.IonCompleteInt ionCompleteInt)  {
//        if (!user.getUsername().equals(getCurrentUser().getUsername())){
//            if (!doesUserNameExisit(user.getUsername())){
//                if (updatedata(user,1)) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            }
//            else {
//                return 2;
//            }
//        }
//        else {
//            if (updatedata(user,2)) {
//                return 0;
//            } else {
//                return 1;
//            }
//        }
//
////        if (!myDatabaseHelper.DoesUserNameExisit(user.getUsername())){
////            if (myDatabaseHelper.updateData(user)) {
////                return 0;
////            } else {
////                return 1;
////            }
////        }
////        else {
////            return 2;
////        }
//    }
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
    public void doesUserNameExisit(String userName , com.example.tkfinalproject.RePostry.MyFireBaseHelper.checkUser checkUser){
        fireBaseHelper.userNameExsIts(userName, checkUser);
    }

    public void IsExisit(String name, String pass, com.example.tkfinalproject.RePostry.MyFireBaseHelper.checkUser checkUser){
//        Boolean X = fireBaseHelper.checkUserExistence(new User(name,pass));
//        Boolean Y = myDatabaseHelper.IsExist(name,pass);
        fireBaseHelper.userExsits(new User(name,pass),checkUser);
//        if (fireBaseHelper.checkUserExistence(new User(name,pass)),checkuser){
//            setCurrentUser(new User(name,pass));
//            return true;
//        }
//        else {
//            return false;
//        }
    }
}