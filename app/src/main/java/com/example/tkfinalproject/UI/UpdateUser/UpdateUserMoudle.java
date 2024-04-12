package com.example.tkfinalproject.UI.UpdateUser;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.example.tkfinalproject.RePostry.Repostry;
import com.example.tkfinalproject.RePostry.User;
import com.example.tkfinalproject.Utility.IonComplete;

public class UpdateUserMoudle {
    int x;
    private Repostry repostry;
    User user;
    public UpdateUserMoudle(Context context)
    {
        repostry = new Repostry(context);
    }

    public void showdata(EditText ed1,EditText ed2){
        ed1.setText(repostry.getCurrentUser().getUsername());
        ed2.setText(repostry.getCurrentUser().getPass());
    }
    public void setUser(EditText editTextName, EditText editTextPass){
        user = new User(editTextName.getText().toString().trim(),editTextPass.getText().toString().trim());
        repostry.setCurrentUser(user);
    }

    public void updateUser(EditText editTextName, EditText editTextPass, IonComplete.IonCompleteInt ionCompleteInt){
        user = new User(editTextName.getText().toString().trim(),editTextPass.getText().toString().trim());
        repostry.Updateuser(user,ionCompleteInt);
//        x = repostry.Updateuser(user);
//        if (x == 0){
//            repostry.setCurrentUser(user);
//            return 0;
//        }
//        return x;
    }
}
