package com.example.tkfinalproject.UI.SelectPhone;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tkfinalproject.RePostry.Repostry;
import com.google.android.material.textfield.TextInputLayout;

import java.nio.Buffer;

public class selectNewPhoneMoudle {
    Repostry repostry;
    String s1,s2;
    Context myContext;
    com.google.android.material.textfield.TextInputLayout inputModel,inputcapacity;
    EditText editText;
    private AutoCompleteTextView autoCompleteBrand, autoCompleteModel, autoCompleteCapacity;

    Button btn;
    public selectNewPhoneMoudle(Context context, TextInputLayout inputModel, TextInputLayout inputcapacity, AutoCompleteTextView autoCompleteBrand, AutoCompleteTextView autoCompleteModel, AutoCompleteTextView autoCompleteCapacity, Button btn, EditText editText) {
        this.myContext = context;
        this.repostry = new Repostry(context);
        this.inputModel = inputModel;
        this.inputcapacity = inputcapacity;
        this.autoCompleteBrand = autoCompleteBrand;
        this.autoCompleteModel = autoCompleteModel;
        this.autoCompleteCapacity = autoCompleteCapacity;
        this.btn = btn;
        this.editText = editText;
//        autoCompleteModel.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                s1 = charSequence.toString();
//                // This method is called before the text changes
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {;
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                s2 = editable.toString();
//                handleModelTextChanged(s1,s2,2);
//            }
//        });
    }
    public void handleModelTextChanged(String oldText, String newText,int code) {
        if (newText != null && !oldText.equals(newText)){
            if (code == 1){

                autoCompleteModel.setText("");
                autoCompleteCapacity.setText("");
                editText.setText("");
                inputModel.setEnabled(false);
                inputcapacity.setEnabled(false);
            }
            else if (code == 2){
                autoCompleteCapacity.setText("");
                editText.setText("");
                inputcapacity.setEnabled(false);
            }
            else {
                editText.setText("");
                btn.setEnabled(false);
            }
        }
    }
//    public createphone(View v, com.google.android.material.textfield.TextInputLayout inputModel, com.google.android.material.textfield.TextInputLayout inputcapcity, AutoCompleteTextView autoCompleteBrand, AutoCompleteTextView autoCompleteModel, AutoCompleteTextView autoCompleteCapacity){
//        autoCompleteBrand.setOnItemClickListener((parent, view, position, id) -> {
//            modelAdapter.clear();
//            modelAdapter.addAll(models[position]);
//            autoCompleteModel.setEnabled(
//    }
}
