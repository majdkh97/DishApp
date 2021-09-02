package com.example.dishapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDishScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish_screen);


        // find the submit button and set on click listener
        Button submitDishDetails = AddDishScreenActivity.this.findViewById(R.id.SubmitDishDetailsButton);
        submitDishDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // on add dish activity we have 3 edit texts that the user will enter as an input
                //and each input we will store them in variables

                EditText dishNameField = AddDishScreenActivity.this.findViewById(R.id.DishNameEditText);
                String dishName = dishNameField.getText().toString();

                EditText dishPriceField = AddDishScreenActivity.this.findViewById(R.id.DishPriceEditText);
                String dishPriceStr = dishPriceField.getText().toString();
                int dishPrice = Integer.parseInt(dishPriceStr);

                EditText dishIngredientField = AddDishScreenActivity.this.findViewById(R.id.DishIngredientsEditText);
                String dishIngredient = dishIngredientField.getText().toString();

                // here we create an instance from the database so we can access it
                DishDatabase dishDb =  Room.databaseBuilder(getApplicationContext(), DishDatabase.class, "DishDatabase").allowMainThreadQueries().build();
                // instance from our model and we set the 3 input variables that the user enters
                Dish dish = new Dish(dishName,dishPrice,dishIngredient);
                // here we access the Dao class through our Db instance and use the Insert method
                dishDb.dishDao().insertDish(dish);
                // go from here to main activity upon submission
                Intent goToMainActivity = new Intent(AddDishScreenActivity.this,MainActivity.class);
                startActivity(goToMainActivity);
            }
        });
    }
}