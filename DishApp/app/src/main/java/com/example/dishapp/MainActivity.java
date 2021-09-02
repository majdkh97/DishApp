package com.example.dishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the button on the main activity screen and set onclick listeners to each button
        // go from main activity to Add dish screen
        Button addDishButton = findViewById(R.id.AddDishButton);
        addDishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToAddDishScreenActivity = new Intent(MainActivity.this,AddDishScreenActivity.class);
                startActivity(goToAddDishScreenActivity);
            }
        });

        // go from main activity to Menu Screen activity
        Button menuButton = findViewById(R.id.MenuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMenuScreenActivity = new Intent(MainActivity.this,MenuScreenActivity.class);
                startActivity(goToMenuScreenActivity);
            }
        });
    }
}