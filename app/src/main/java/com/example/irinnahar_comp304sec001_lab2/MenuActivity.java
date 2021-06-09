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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView title, ing_details;
    ImageView img;
    Button addBtn;
    public static final String STORAGE_NAME = "MenuSharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    // checkbox click functionality
    public void onCheckboxClicked(View view) {
        //   Declare all the necessary items here
        title = (TextView) findViewById(R.id.ingredientsTitle);
        img = (ImageView) findViewById(R.id.pizza_img);
        ing_details = (TextView) findViewById(R.id.ingredient_details);
        addBtn = (Button) findViewById(R.id.addToCartBtn);
        CheckBox checkbox1 = ((CheckBox)findViewById(R.id.checkBox1));
        CheckBox checkbox2 = ((CheckBox)findViewById(R.id.checkBox2));
        CheckBox checkbox3 = ((CheckBox)findViewById(R.id.checkBox3));
        CheckBox checkbox4 = ((CheckBox)findViewById(R.id.checkBox4));
        CheckBox checkbox5 = ((CheckBox)findViewById(R.id.checkBox5));

        // check if the view now checked
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBox1:
                if (checked){
                    // show title, image and ingredient
                    onClickShowFunction(checkbox1, img, ing_details, title, addBtn, R.drawable.canada_pizza, R.string.canadian_pizza);
                } else {
                    onClickHideFunction(img, ing_details, addBtn, title);
                }
                break;
            case R.id.checkBox2:
                if (checked){
                    // show title, image and ingredient
                    onClickShowFunction(checkbox2, img, ing_details, title, addBtn, R.drawable.chicken_ceaser_pizza, R.string.chicken_ceaser);
                } else {
                    onClickHideFunction(img, ing_details, addBtn, title);
                }
                break;
            case R.id.checkBox3:
                if (checked){
                    // show title, image and ingredient
                    onClickShowFunction(checkbox3, img, ing_details, title, addBtn, R.drawable.hawaiian_pizza, R.string.hawaiian_pizza);
                } else {
                    onClickHideFunction(img, ing_details,addBtn, title);

                }
                break;
            case R.id.checkBox4:
                if (checked){
                    // show title, image and ingredient
                    onClickShowFunction(checkbox4, img, ing_details, title, addBtn, R.drawable.maple_bacon_pizza, R.string.maple_bacon);
                } else {
                    onClickHideFunction(img, ing_details, addBtn, title);
                }
                break;
            case R.id.checkBox5:
                if (checked){
                    // show title, image and ingredient
                    onClickShowFunction(checkbox5, img, ing_details, title, addBtn, R.drawable.vaggie_pizza, R.string.veggie_lover);
                } else {
                    onClickHideFunction(img, ing_details,addBtn, title);
                }
                break;
        }

    }

    //    show and set texts according to click the checkbox
    private void onClickShowFunction(CheckBox checkbox, ImageView img, TextView ing_details, TextView title, Button addBtn, int imgId, int textId) {
        img.setImageDrawable(getResources().getDrawable(imgId));
        ing_details.setText(getResources().getString(textId));

        img.setVisibility(View.VISIBLE);
        ing_details.setVisibility(View.VISIBLE);
        title.setVisibility(View.VISIBLE);
        addBtn.setVisibility(View.VISIBLE);

        SharedPreferences sharedPreferences = getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(checkbox.isChecked()) {
            editor.putString("pizzaName1", checkbox.getText().toString());
            editor.putString("pizzaIngredient1", ing_details.getText().toString());
            editor.apply();
        }
    }

    //    hide texts according to click the checkbox
    private void onClickHideFunction(ImageView img, TextView ing_details, Button addBtn, TextView title) {
        img.setVisibility(View.GONE);
        ing_details.setVisibility(View.GONE);
        title.setVisibility(View.GONE);
        addBtn.setVisibility(View.GONE);
    }

    //    Add to cart functionality
    public void onClickAddToCart(View view) {
        Intent menuIntent = new Intent(this, ToppingActivity.class);
        startActivity(menuIntent);
    }
}