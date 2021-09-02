package com.example.dishapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// Database annotation crucial for the creation of our database
// we have to list our entities
// and call the Dao interface for each model
@Database(entities = {Dish.class},exportSchema = false, version = 1)
public abstract class DishDatabase extends RoomDatabase {
    public abstract DishDao dishDao();
}
