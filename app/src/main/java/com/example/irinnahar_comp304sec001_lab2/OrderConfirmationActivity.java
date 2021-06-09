package com.example.irinnahar_comp304sec001_lab2;
//Author: Irin Nahar
//id:301173198
//project: Pizza app

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class OrderConfirmationActivity extends AppCompatActivity {
    public static final String STORAGE_NAME1 = "MenuSharedPreferences";
    public static final String STORAGE_NAME2 = "UserSharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);


        TextView pizzaName = (TextView) findViewById(R.id.pizzaName);
        TextView pizzaIng = (TextView) findViewById(R.id.ingredient);
        TextView uname = (TextView) findViewById(R.id.name);
        TextView uaddress = (TextView) findViewById(R.id.address);
        TextView uphone = (TextView) findViewById(R.id.phone);

        SharedPreferences sharedPreferences = getSharedPreferences(STORAGE_NAME1, Context.MODE_PRIVATE);
        SharedPreferences sharedUserPreferences = getSharedPreferences(STORAGE_NAME2, Context.MODE_PRIVATE);

        String pizzaname = sharedPreferences.getString("pizzaName1", "");
        String ing = sharedPreferences.getString("pizzaIngredient1", "");
        String username = sharedUserPreferences.getString("customer_name", "");
        String userPhone = sharedUserPreferences.getString("customer_phone", "");
        String userStreet = sharedUserPreferences.getString("customer_street", "");
        String userCity = sharedUserPreferences.getString("customer_city", "");
        String userpostal = sharedUserPreferences.getString("customer_post", "");


        pizzaName.setText( "Pizza Name: " + pizzaname);
        pizzaIng.setText( "Pizza Ingredients: " + ing);
        uname.setText( "Name: " + username);
        uphone.setText( "Phone No: " + userPhone);
        uaddress.setText( "Delivery Address: " + userStreet + ", " + userCity + ", " + userpostal);

    }
}