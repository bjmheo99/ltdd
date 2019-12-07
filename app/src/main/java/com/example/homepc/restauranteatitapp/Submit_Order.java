package com.example.homepc.restauranteatitapp;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;



public class Submit_Order extends Fragment {

    DatabaseHelper mydb;
    String email = "lamphamit09@gmail.com";

    public Submit_Order() {
        // Required empty public constructor;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Intent chooser = null;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("Gửi thư:"));
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, "App Food  ");
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }

        return inflater.inflate(R.layout.fragment_submit__order2, container, false);

    }



}
