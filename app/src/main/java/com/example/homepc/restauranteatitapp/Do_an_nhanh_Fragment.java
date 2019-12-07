package com.example.homepc.restauranteatitapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class Do_an_nhanh_Fragment extends Fragment {


    public Do_an_nhanh_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.do_an_nhanh, container, false);

        ArrayList<Do_an_nhanh_Class> fastfood = new ArrayList<Do_an_nhanh_Class>();
        fastfood.add(new Do_an_nhanh_Class("Bánh mỳ kẹp thịt", "40000 vnd", R.drawable.beef,"0"));
        fastfood.add(new Do_an_nhanh_Class("hamburger", "100000 vnd", R.drawable.chicken,"0"));
        fastfood.add(new Do_an_nhanh_Class("Kim chi", "70000 vnd", R.drawable.fries,"0"));
        fastfood.add(new Do_an_nhanh_Class("Khoai tây chiên", "120000 vnd", R.drawable.roll,"0"));
        fastfood.add(new Do_an_nhanh_Class("bánh Sandwich", "30000 vnd", R.drawable.club,"0"));
        fastfood.add(new Do_an_nhanh_Class("Cánh gà", "70000 vnd", R.drawable.wings,"0"));
        fastfood.add(new Do_an_nhanh_Class("Thịt gà nướng", "55000 vnd", R.drawable.broast,"0"));
        fastfood.add(new Do_an_nhanh_Class("Gà chiên cốm", "120000 vnd", R.drawable.nuggets,"0"));

        Do_an_nhanh_Adapter fastfoodadapter = new Do_an_nhanh_Adapter(getActivity(),fastfood);

        ListView listView = (ListView) view.findViewById(R.id.listview_fastfood);
        listView.setAdapter(fastfoodadapter);
        return view;

    }

}
