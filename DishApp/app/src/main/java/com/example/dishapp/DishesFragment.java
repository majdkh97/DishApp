package com.example.dishapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DishesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DishesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    // here the params must have the same naming as our model
    // here all must be string
    private static final String ARG_PARAM1 = "dishName";
    private static final String ARG_PARAM2 = "dishPrice";
    private static final String ARG_PARAM3 = "ingredients";

    // TODO: Rename and change types of parameters
    // here we give the actual datatypes that corresponds with our model
    private String mDishName;
    private int mDishPrice;
    private String mIngredients;

    public DishesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mDishName Parameter 1.
     * @param mDishPrice Parameter 2.
     * @return A new instance of fragment DishesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DishesFragment newInstance(String mDishName, int mDishPrice, String mIngredients) {
        DishesFragment fragment = new DishesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mDishName);
        args.putInt(ARG_PARAM2, mDishPrice);
        args.putString(ARG_PARAM3,mIngredients);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDishName = getArguments().getString(ARG_PARAM1);
            mDishPrice = getArguments().getInt(ARG_PARAM2);
            mIngredients= getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dishes, container, false);
    }
}