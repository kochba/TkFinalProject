package com.example.tkfinalproject.UI.UpdateUser;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.example.tkfinalproject.RePostry.Repostry;
import com.example.tkfinalproject.RePostry.User;

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

    public int updateUser(EditText editTextName, EditText editTextPass){
        user = new User(editTextName.getText().toString().trim(),editTextPass.getText().toString().trim());
        x = repostry.Updateuser(user);
        if (x == 0){
            repostry.setCurrentUser(user);
            return 0;
        }
        return x;
    }
}
