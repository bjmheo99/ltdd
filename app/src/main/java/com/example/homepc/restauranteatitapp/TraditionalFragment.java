package com.example.homepc.restauranteatitapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class TraditionalFragment extends Fragment {


    public TraditionalFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_traditional, container, false);

        ArrayList<TraditionalfoodClass> trad_food = new ArrayList<TraditionalfoodClass>();
        trad_food.add(new TraditionalfoodClass("Cà ri", "125000 vnd", R.drawable.karahi,"0"));
        trad_food.add(new TraditionalfoodClass("Nước xốt gà", "80000 vnd", R.drawable.tikka,"0"));
        trad_food.add(new TraditionalfoodClass("Gà nướng nguyên con", "100000 vnd", R.drawable.sajjione,"0"));

        TraditionalFoodAdapter tradfoodadapter = new TraditionalFoodAdapter(getActivity(),trad_food);

        ListView listView = (ListView) view.findViewById(R.id.listview_traditional);
        listView.setAdapter(tradfoodadapter);

        return view;
    }

}
