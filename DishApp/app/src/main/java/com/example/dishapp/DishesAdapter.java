package com.example.dishapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.DishViewHolder> {
    // create a list of our model that we wanna read from
    List<Dish> allDishes = new ArrayList<>();

    public DishesAdapter(List<Dish> allDishes) {
        this.allDishes = allDishes;
    }

    // view holder class that extends the recyclerview
    public static class DishViewHolder extends RecyclerView.ViewHolder {
        // instance of our model
        public Dish dish;
        // instance of the view(here we have access to all the items inside the fragment)
        View itemView;

        public DishViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            // on click listener for each fragment created
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // create an intent to take me from the current location and send me to DishIngredientDetails Activity
                    Intent i = new Intent(view.getContext(),DishIngredientDetails.class);
                    //i send the current dishname and ingredient using putExtra
                    i.putExtra("dishName",dish.dishName);
                    i.putExtra("dishIngredients",dish.ingredients);
                    i.putExtra("dishPrice",dish.dishPrice);
                    view.getContext().startActivity(i);
                }
            });
        }
    }

    @NonNull
    @NotNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        //Magic
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dishes, parent, false);
        DishViewHolder dishViewHolder = new DishViewHolder(view);
        return dishViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DishesAdapter.DishViewHolder holder, int position) {
        // here we hold and bind each instance of our model to the items on each fragment
        holder.dish = allDishes.get(position);

        TextView dishName = holder.itemView.findViewById(R.id.DishNameFragment);
        TextView dishPrice = holder.itemView.findViewById(R.id.DishPriceFragment);

        dishName.setText(holder.dish.dishName);
        dishPrice.setText(Integer.toString(holder.dish.dishPrice));

    }

    @Override
    public int getItemCount() {
        return allDishes.size();
    }
}
