package com.example.dishapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MenuScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        // Instance of our database
        DishDatabase dishDb =  Room.databaseBuilder(getApplicationContext(), DishDatabase.class, "DishDatabase").allowMainThreadQueries().build();
        // through the instance we access the Dao interface methods
        DishDao dishDao = dishDb.dishDao();
        // we get all dishes and place them inside our List
        List<Dish> allDishesData = dishDao.getDishList();

        // find the recyclerview
        RecyclerView allDishesRecyclerView = findViewById(R.id.DishListRecyclerView);
        // set layout manager
        allDishesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // set adapter and send the list of dishes we gonna read from
        allDishesRecyclerView.setAdapter(new DishesAdapter(allDishesData));


        // find home button and give it a listener to traverse us from this screen back to the main activity
        Button goToHomeButton = findViewById(R.id.HomeButton);
        goToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMainActivity = new Intent(MenuScreenActivity.this,MainActivity.class);
                startActivity(goToMainActivity);
            }
        });
        ///////////////////////////
        ///////////////////////////
        ////////////////////////////
        //////////////////////////////











        // Don't read further codes !
        Button secretBtn = findViewById(R.id.GoToSecretActivityButton);
        secretBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSecretActivity = new Intent(MenuScreenActivity.this,SecretActivity.class);
                startActivity(goToSecretActivity);
            }
        });
    }
}