package com.example.dishapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

// entity annotation for the database
@Entity
public class Dish {
    // primary key for the entity
    @PrimaryKey(autoGenerate = true)
    private int id;
    // we set our model variables
    @ColumnInfo(name = "dish name")
    public String dishName;

    @ColumnInfo(name = "dish price")
    public int dishPrice;

    @ColumnInfo(name = "ingredients")
    public String ingredients;

    // constructor with the required data
    public Dish(String dishName, int dishPrice, String ingredients) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.ingredients = ingredients;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
