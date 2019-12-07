package com.example.homepc.restauranteatitapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ContinentalFragment extends Fragment {


    public ContinentalFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_continental, container, false);

        ArrayList<ContinentalClass> conti_food = new ArrayList<ContinentalClass>();
        conti_food.add(new ContinentalClass("Kem", "30000 vnd", R.drawable.coneone,"0"));
        conti_food.add(new ContinentalClass("Pizza", "85000 vnd", R.drawable.ctwo,"0"));
        conti_food.add(new ContinentalClass("Mì ống", "65000 vnd", R.drawable.cthree,"0"));
        conti_food.add(new ContinentalClass("nấm", "50000 vnd", R.drawable.cfive,"0"));


        ContinentalAdapter continentaladapter = new ContinentalAdapter(getActivity(),conti_food);

        ListView listView = (ListView) view.findViewById(R.id.listview_continental);
        listView.setAdapter(continentaladapter);

        return view;
    }

}
