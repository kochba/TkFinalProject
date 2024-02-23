package com.example.tkfinalproject.UI.UpdateUser;

import android.content.Context;

import com.example.tkfinalproject.RePostry.Repostry;

public class UpdateUserMoudle {
    Repostry repostry;
    public UpdateUserMoudle(Context context)
    {
        repostry = new Repostry(context);
    }
}
