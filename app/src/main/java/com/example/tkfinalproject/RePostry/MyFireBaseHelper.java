package com.example.tkfinalproject.RePostry;

import android.content.Context;
import android.icu.lang.UScript;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.dynamic.IFragmentWrapper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyFireBaseHelper {
    FirebaseDatabase database;
    DatabaseReference reference;
    Context myContext;

    public MyFireBaseHelper(Context context) {
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users");
        myContext = context;
    }
    public void addUser(User user){
        reference.child(user.getUsername()).setValue(user);
    }
    public void update(User user){
        Map<String, Object> updates = new HashMap<>();
        updates.put("username", user.getUsername());
        updates.put("pass", user.getPass());
        reference.child(user.getUsername()).updateChildren(updates);
    }

    public interface checkUser
    {
        void onCheckedUser(boolean flag);
    }
    public void userNameExsIts(String username , checkUser checkUser){
        reference.child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    checkUser.onCheckedUser(true);
                }
                else {
                    checkUser.onCheckedUser(false);
                }
            }
        });
    }
    public void userExsits(User user,checkUser checkUser){
        reference.child(user.getUsername()).child(user.getUsername()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                User user1 = null;
                if (task.getResult().exists() && task.isSuccessful()){
                    if (task.getResult().child("pass").getValue(String.class).equals(user.getPass())){
                        checkUser.onCheckedUser(true);
                    }
                    else {
                        checkUser.onCheckedUser(false);
                    }
                }
                else {
                    checkUser.onCheckedUser(false);
                }

            }
        });
    }

//    public boolean userNameExist(String userName){
//        User user = getUserByName(userName)
//        return user != null && user.getUsername().equals(userName);
//    }
//    public boolean checkUserExistence(User user , checkUser) {
//            @Override
//            public void onCheckedUser(User user) {
//
//            }
//        });
//        boolean b = user1 != null;
//        boolean x = user1.getUsername().equals(user.getUsername());
//        boolean u =  user1.getPass().equals(user.getPass());
//        return user1 != null && user1.getUsername().equals(user.getUsername()) && user1.getPass().equals(user.getPass());
//    }
//    private User getUserByName(String username, checkUser callback){
//        reference.child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (!task.isSuccessful()) {
//                    callback.onCheckedUser(null);
//                }
//                else {
//                    callback.onCheckedUser(task.getResult().getValue(User.class));
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//
//            }
//        });
//        return null;
//    }
//    private ArrayList<User> getUsers(){
//        ArrayList<User> list = new ArrayList<>();
//        reference.child("users").child(userId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (!task.isSuccessful()) {
//                    Log.e("firebase", "Error getting data", task.getException());
//                }
//                else {
//                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                }
//            }
//        });
//        return  list;
//    }

//    public boolean isExsist(User user){
//        reference.child("Users").orderByChild("username").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        })
//    }

}
