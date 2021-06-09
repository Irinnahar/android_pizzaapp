package com.example.irinnahar_comp304sec001_lab2;
//Author: Irin Nahar
//id:301173198
//project: Pizza app

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    public static final String STORAGE_NAME = "MenuSharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        SharedPreferences sharedPreferences = getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("pizzaName1", "");
        String ing = sharedPreferences.getString("pizzaIngredient1", "");

        TextView pizzaCrust = (TextView) findViewById(R.id.crustType);
        TextView pizzaSize = (TextView) findViewById(R.id.sizeType);
        TextView pizzaName = (TextView) findViewById(R.id.pizzaType);
        TextView pizzaIng = (TextView) findViewById(R.id.pizzaIngredient);

        Intent intent = getIntent();
        String selectedRadioValue = intent.getStringExtra("checkedCrust");
        String selectedSpinnerValue = intent.getStringExtra("spinnerSize");

        pizzaSize.setText( "Pizza Size: " + selectedSpinnerValue);
        pizzaCrust.setText( "Crust type: " + selectedRadioValue);
        pizzaName.setText( "Pizza Name: " + name);
        pizzaIng.setText( "Pizza Ingredients: " + ing);

    }

    public void onClickCheckout (View view){
        Intent checkoutIntent = new Intent(this,PaymentActivity.class);
        startActivity(checkoutIntent);
    }
}