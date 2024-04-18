package com.example.tkfinalproject.UI.SelectPhone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tkfinalproject.R;
import com.example.tkfinalproject.UI.FirstPage.FirstPage;
import com.example.tkfinalproject.UI.LogOut.LogOut1;
import com.example.tkfinalproject.UI.Progress.progerssFirst;
import com.example.tkfinalproject.UI.UpdateUser.UpdateUser;

import java.util.Objects;

public class SelectNewPhone extends AppCompatActivity implements View.OnClickListener {
    com.google.android.material.textfield.TextInputLayout inputModel,inputcapacity;
    private AutoCompleteTextView autoCompleteBrand, autoCompleteModel, autoCompleteCapacity;
    ImageView updateicon,logouticon;
    selectNewPhoneMoudle moudle;
    String s1,s2;
    Intent intent;
    Button btn;
    private ArrayAdapter<String> brandAdapter, modelAdapter, capacityAdapter;
    private String[] brands = {"apple", "samsung"};
    private String[][] models = {
            {"iphone 15 pro max", "iphone 15 pro","iphone 15","iphone 16"},
            {"Model B1", "Model B2"},
    };
    private String[][][] capacities = {
            {{"32GB", "64GB", "128GB","256Gb"}, {"16GB", "32GB", "64GB"}, {"64GB", "128GB", "256GB"},{"64GB", "128GB", "256GB","512GB"}},
            {{"32GB", "64GB", "128GB"}, {"16GB", "32GB", "64GB"}, {"64GB", "128GB", "256GB"}},
            {{"32GB", "64GB", "128GB"}, {"16GB", "32GB", "64GB"}, {"64GB", "128GB", "256GB"}}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_new_phone);
        inputModel = findViewById(R.id.inputmoudle);
        inputcapacity = findViewById(R.id.inputcapcity);
        autoCompleteBrand = findViewById(R.id.autoCompleteBrand);
        autoCompleteModel = findViewById(R.id.autoCompleteModel);
        autoCompleteCapacity = findViewById(R.id.autoCompleteCapacity);
        btn = findViewById(R.id.confirmphone);
        updateicon = findViewById(R.id.updatepassnp);
        logouticon = findViewById(R.id.logouticonnp);
        moudle = new selectNewPhoneMoudle(this,inputModel,inputcapacity,autoCompleteBrand,autoCompleteModel,autoCompleteCapacity,btn);
        btn.setOnClickListener(this);
        updateicon.setOnClickListener(this);
        logouticon.setOnClickListener(this);
        inputModel.setEnabled(false);
        inputcapacity.setEnabled(false);

        // Set up adapters for each dropdown
        brandAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, brands);
        autoCompleteBrand.setAdapter(brandAdapter);


        // Brand selection listener
        autoCompleteBrand.setOnItemClickListener((parent, view, position, id) -> {
            modelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,models[position]);
            autoCompleteModel.setAdapter(modelAdapter);
//            modelAdapter.clear();
//            modelAdapter.addAll(models[position]);
            inputModel.setEnabled(true);
        });

        // Model selection listener
        autoCompleteModel.setOnItemClickListener((parent, view, position, id) -> {
            int brandPosition = autoCompleteBrand.getText().toString().isEmpty() ? -1 : brandAdapter.getPosition(autoCompleteBrand.getText().toString());
            if (brandPosition != -1) {
                int modelPosition = position;
//                capacityAdapter.clear();
//                capacityAdapter.addAll(capacities[brandPosition][modelPosition]);
                capacityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,capacities[brandPosition][modelPosition]);
                autoCompleteCapacity.setAdapter(capacityAdapter);
                inputcapacity.setEnabled(true);
            }
        });

        autoCompleteCapacity.setOnItemClickListener((parent, view, position, id) -> {
//            modelAdapter.clear();
//            modelAdapter.addAll(models[position]);
            btn.setEnabled(true);
        });

//        // Clear model and capacity dropdowns if brand is changed
//        autoCompleteBrand.setOnDismissListener(() -> {
//            if (!flag){
//            autoCompleteModel.setText("");
//            autoCompleteCapacity.setText("");
//                inputModel.setEnabled(false);
//                inputcapacity.setEnabled(false);
//            }
//            flag = false;
//        });
//
//        // Clear capacity dropdown if model is changed
//        autoCompleteModel.setOnDismissListener(() -> {
//            if (!flag) {
//                autoCompleteCapacity.setText("");
//                inputcapacity.setEnabled(false);
//            }
//            flag = false;
//        });
        autoCompleteBrand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                s1 = charSequence.toString();
                // This method is called before the text changes
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {;
            }

            @Override
            public void afterTextChanged(Editable editable) {
                s2 = editable.toString();
                moudle.handleModelTextChanged(s1,s2,1);
            }
        });
        autoCompleteModel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                s1 = charSequence.toString();
                // This method is called before the text changes
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {;
            }

            @Override
            public void afterTextChanged(Editable editable) {
                s2 = editable.toString();
                moudle.handleModelTextChanged(s1,s2,2);
            }
        });
        autoCompleteCapacity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                s1 = charSequence.toString();
                // This method is called before the text changes
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {;
            }

            @Override
            public void afterTextChanged(Editable editable) {
                s2 = editable.toString();
                moudle.handleModelTextChanged(s1,s2,3);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (updateicon == v) {
            intent = new Intent(SelectNewPhone.this, UpdateUser.class);
            startActivity(intent);
        } else if (logouticon == v) {
            intent = new Intent(SelectNewPhone.this, LogOut1.class);
            startActivity(intent);
        }
        else {
            intent = new Intent(SelectNewPhone.this, progerssFirst.class);
            startActivity(intent);
        }
//        } else if (btn == v) {
//            intent = new Intent(SelectNewPhone.this, SelectNewPhone.class);
//            startActivity(intent);
//        }
    }
}