package com.example.tkfinalproject.UI.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.braintreepayments.cardform.view.CardForm;
import com.example.tkfinalproject.R;
import com.example.tkfinalproject.Utility.UtilityClass;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link creditCard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class creditCard extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    UtilityClass utilityClass;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public creditCard() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment creditCard.
     */
    // TODO: Rename and change types and number of parameters
    public static creditCard newInstance(String param1, String param2) {
        creditCard fragment = new creditCard();
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
        View view = inflater.inflate(R.layout.fragment_credit_card, container, false);
        utilityClass = new UtilityClass(getActivity());
        CardForm cardForm = view.findViewById(R.id.card_form);
        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .cardholderName(CardForm.FIELD_REQUIRED)
                .actionLabel("purchase")
                .setup(getActivity());
//        cardForm.getCvvEditText().setHintTextColor(R.color.black);
//        cardForm.getCardEditText().setFieldHint(R.string.numberhint);
//        cardForm.getExpirationDateEditText().setFieldHint(R.string.exphint);
//        cardForm.getCardholderNameEditText().setFieldHint(R.string.namehint);
        cardForm.getCvvEditText().setFieldHint(R.string.cvvhint);
        EditText cardNumberEditText = cardForm.getCardEditText();
        EditText expirationDateEditText = cardForm.getExpirationDateEditText();
        EditText cvvEditText = cardForm.getCvvEditText();
        EditText cardholderNameEditText = cardForm.getCardholderNameEditText();
        cardNumberEditText.setGravity(Gravity.RIGHT);
        expirationDateEditText.setGravity(Gravity.RIGHT);
        cvvEditText.setGravity(Gravity.RIGHT);
        cardholderNameEditText.setGravity(Gravity.RIGHT);
        cardholderNameEditText.setTextDirection(view.TEXT_DIRECTION_RTL);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}