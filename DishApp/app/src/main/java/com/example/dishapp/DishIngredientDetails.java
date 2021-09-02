package com.example.dishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DishIngredientDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_ingredient_details);

        // we get the intent
        // through the intent we get the extras that were sent from another activity
        // and set them to our TextViews
        Intent  i = getIntent();
        String dishName = i.getExtras().getString("dishName");
        String dishIngredient = i.getExtras().getString("dishIngredients");
        int dishPrice = i.getExtras().getInt("dishPrice");
        String dishPriceStr = Integer.toString(dishPrice);
        TextView dishNameView = findViewById(R.id.DishNameDetail);
        TextView dishIngredientView = findViewById(R.id.DishIngredientDetail);
        TextView dishPriceView = findViewById(R.id.dishPriceDetail);
        dishNameView.setText(dishName);
        dishIngredientView.setText(dishIngredient);
        dishPriceView.setText(dishPriceStr);
    }
}