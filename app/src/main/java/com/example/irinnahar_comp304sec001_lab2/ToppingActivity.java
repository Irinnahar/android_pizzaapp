package com.example.irinnahar_comp304sec001_lab2;
//Author: Irin Nahar
//id:301173198
//project: Pizza app

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class ToppingActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    RadioButton radioThin, radioThick;
    String selectedRadioValue;
    String spinnerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topping);

        Spinner spinner = (Spinner) findViewById(R.id.pizza_size_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pizza_size_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinnerText = spinner.getSelectedItem().toString();

        radioThin = (RadioButton) findViewById(R.id.radio_thin);
        radioThick = (RadioButton) findViewById(R.id.radio_thick);

    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        spinnerText = parent.getItemAtPosition(pos).toString();

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


    //    proceed to cart button functionality
    public void onClickAddToCart(View view){
        if (radioThick.isChecked()) {
            selectedRadioValue = radioThick.getText().toString();
        } else if (radioThin.isChecked()) {
            selectedRadioValue = radioThin.getText().toString();
        }

        Intent toppingIntent = new Intent(this,CheckoutActivity.class);
        toppingIntent.putExtra("checkedCrust",selectedRadioValue);
        toppingIntent.putExtra("spinnerSize", spinnerText);

        startActivity(toppingIntent);
    }
}