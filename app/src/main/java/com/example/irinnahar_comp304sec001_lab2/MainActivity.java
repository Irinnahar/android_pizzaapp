package com.example.irinnahar_comp304sec001_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //    Called when the user taps the order button
    public void orderBtn(View view) {
        SharedPreferences mainActivity = getPreferences(MODE_PRIVATE);

        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}