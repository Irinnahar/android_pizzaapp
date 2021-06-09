package com.example.irinnahar_comp304sec001_lab2;
//Author: Irin Nahar
//id:301173198
//project: Pizza app

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.provider.Contacts.SettingsColumns.KEY;

public class PaymentActivity extends AppCompatActivity {
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroupPayment);
        LinearLayout layout = (LinearLayout)findViewById((R.id.paymentlayout));


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_cash:
                        layout.setVisibility(View.GONE);
                        break;
                    case  R.id.radio_credit:
                    case  R.id.radio_debit:
                        layout.setVisibility(View.VISIBLE);
                        break;
                }
            }

        });
        }
//        set data to shared prefference
    private void saveFromEditText() {
        EditText fName = (EditText)findViewById(R.id.firstName);
        EditText lName = (EditText)findViewById(R.id.lastName);
        EditText card = (EditText)findViewById(R.id.cardNumber);
        EditText expDate = (EditText)findViewById(R.id.expiryDate);
        EditText cvv = (EditText)findViewById(R.id.cvv);

        SharedPreferences sharedPaymentPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPaymentPref.edit();
        editor.putString("first_name", fName.getText().toString());
        editor.putString("last_name", lName.getText().toString());
        editor.putString("expDate", card.getText().toString());
        editor.putString("card", expDate.getText().toString());
        editor.putString("cvv", cvv.getText().toString());
        editor.apply();

        if( TextUtils.isEmpty(fName.getText())){
            fName.setError( "First name is required!" );
        } else if(TextUtils.isEmpty(lName.getText())){
            lName.setError( "Last name is required!" );
        } else if(TextUtils.isEmpty(card.getText())){
            card.setError( "Card no is required!" );
        }else if(TextUtils.isEmpty(expDate.getText())){
            expDate.setError( "Expiry date is required!" );
        }else if(TextUtils.isEmpty(cvv.getText())){
            cvv.setError( "City is required!" );
        } else {
            intent();
        }
    }

//    button click intent
    public void onClickPayment(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != R.id.radio_cash) saveFromEditText();
        else intent();
    }

    public void intent(){
        Intent paymentIntent = new Intent(this,UserDetailActivity.class);
        startActivity(paymentIntent);
    }
}