package com.example.tkfinalproject.UI.FirstPage;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.tkfinalproject.R;
import com.example.tkfinalproject.UI.LogOut.LogOut1;
import com.example.tkfinalproject.UI.UpdateUser.UpdateUser;

public class FirstPage extends AppCompatActivity implements View.OnClickListener {
    ImageView userPhoto;
    Intent intent;
    Button btn;
    OnBackPressedCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        userPhoto = findViewById(R.id.userphoto);
        btn = findViewById(R.id.newphone);
        btn.setOnClickListener(this);
        userPhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //getSupportFragmentManager().beginTransaction().add(R.id.logoutlayout,log,null).commit();
        if (userPhoto == v) {
            showMenu(v);
        }
    }

    private void showMenu(View v){
        PopupMenu menu = new PopupMenu(FirstPage.this,v);
        menu.getMenuInflater().inflate(R.menu.popup_menu_firstpage,menu.getMenu());
        menu.show();
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.updatebutton){
                    intent = new Intent(FirstPage.this, UpdateUser.class);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(FirstPage.this, LogOut1.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }
}