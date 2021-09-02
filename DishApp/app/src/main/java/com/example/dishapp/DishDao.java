package com.example.dishapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

// the Dao annotations serves here as a repository to access our crud operations
@Dao
public interface DishDao {

    // give me the list of all data in the database
    @Query("Select * from dish")
    List<Dish> getDishList();

    // to inset to the database
    @Insert
    void insertDish(Dish dish);

    // to update the database
    @Update
    void updateDish(Dish dish);

    // to delete from the database
    @Delete
    void deleteDish(Dish dish);
}
