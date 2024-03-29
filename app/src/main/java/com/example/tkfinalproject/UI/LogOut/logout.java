package com.example.tkfinalproject.UI.LogOut;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tkfinalproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link logout#newInstance} factory method to
 * create an instance of this fragment.
 */
public class logout extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button btn;

    logoutModule module;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public logout() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment logout.
     */
    // TODO: Rename and change types and number of parameters
    public static logout newInstance(String param1, String param2) {
        logout fragment = new logout();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_logout, container, false);
       btn = view.findViewById(R.id.logout);
       module = new logoutModule(getContext());
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
               adb.setTitle("התנתקות");
               adb.setMessage("האם את בטוח שאתה רוצה להתנתק");
               adb.setCancelable(false);
               adb.setPositiveButton("כן", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       //makeLogout();
                   }
               });
               adb.setPositiveButton("לא", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });
               adb.create().show();
           }
       });
       return view;
    }

    //private Void makeLogout(){

      //  module.userlogout();

    //}
}