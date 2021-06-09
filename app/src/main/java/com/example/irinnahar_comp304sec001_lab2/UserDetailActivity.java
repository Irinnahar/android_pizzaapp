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
import android.widget.EditText;
import android.widget.Toast;

public class UserDetailActivity extends AppCompatActivity {
    public static final String STORAGE_NAME = "UserSharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
    }

    private void saveFromEditText() {


    }

    public void onClickUserDetail(View view){
        EditText name = (EditText)findViewById(R.id.u_name);
        EditText house = (EditText)findViewById(R.id.u_house);
        EditText street = (EditText)findViewById(R.id.u_street);
        EditText city = (EditText)findViewById(R.id.u_city);
        EditText postal = (EditText)findViewById(R.id.u_post);
        EditText phone = (EditText)findViewById(R.id.u_phone);
        EditText email = (EditText)findViewById(R.id.u_email);
        EditText pizza = (EditText)findViewById(R.id.u_pizza);
        EditText side = (EditText)findViewById(R.id.u_extra);
        //   set data to shared prefference

        SharedPreferences sharedUserPref = getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedUserPref.edit();

        editor.putString("customer_name", name.getText().toString());
        editor.putString("customer_house", house.getText().toString());
        editor.putString("customer_street", street.getText().toString());
        editor.putString("customer_city", city.getText().toString());
        editor.putString("customer_post", postal.getText().toString());
        editor.putString("customer_phone", phone.getText().toString());
        editor.putString("customer_email", email.getText().toString());
        editor.putString("customer_pizza", pizza.getText().toString());
        editor.putString("customer_side", side.getText().toString());
        editor.apply();

        if( TextUtils.isEmpty(name.getText())){
            name.setError( "Name is required!" );
        } else if(TextUtils.isEmpty(phone.getText())){
            phone.setError( "Phone is required!" );
        } else if(TextUtils.isEmpty(street.getText())){
            street.setError( "Street is required!" );
        }else if(TextUtils.isEmpty(house.getText())){
            house.setError( "House is required!" );
        }else if(TextUtils.isEmpty(city.getText())){
            city.setError( "City is required!" );
        } else if(TextUtils.isEmpty(postal.getText())){
            postal.setError( "Postal Code is required!" );
        }
        else{
            Intent orderIntent = new Intent(this,OrderConfirmationActivity.class);
            startActivity(orderIntent);
        }
    }
}