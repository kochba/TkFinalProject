package com.example.tkfinalproject.Utility;

import com.example.tkfinalproject.RePostry.User;

import java.io.Serializable;

public class SaveIon implements IonComplete,IonComplete.IonCompleteInt,IonComplete.IonCompleteUser, Serializable {

    public SaveIon() {
    }

    @Override
    public void onCompleteBool(boolean flag) {

    }

    @Override
    public void onCompleteInt(int flag) {

    }

    @Override
    public void onCompleteUser(User user) {

    }
    public interface IonCompleteInt
    {
        void onCompleteInt(int flag);
    }
}
