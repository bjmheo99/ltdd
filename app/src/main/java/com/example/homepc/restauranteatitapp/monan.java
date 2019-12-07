package com.example.homepc.restauranteatitapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;




public class monan extends Fragment {
    DatabaseHelper mydb;

    public monan() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mon_han, container, false);
        this.mydb = new DatabaseHelper(getContext());
        ArrayList<ComClass> c_food = new ArrayList<ComClass>();
        c_food.add(new ComClass("Cơm chiên", "20000 vnd", R.drawable.friedrice,"0"));
        c_food.add(new ComClass("Sushi", "50000 vnd", R.drawable.sushi,"0"));
        c_food.add(new ComClass("Mì Quảng", "20000 vnd", R.drawable.haka,"0"));
        c_food.add(new ComClass("Súp", "25000 vnd", R.drawable.soup,"0"));

        Cơm cadapter = new Cơm(getActivity(),c_food);


        ListView listView = (ListView) view.findViewById(R.id.listview_chinese);
        listView.setAdapter(cadapter);



        return view;
    }





}
