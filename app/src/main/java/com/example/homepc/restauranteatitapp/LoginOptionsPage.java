package com.example.homepc.restauranteatitapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class LoginOptionsPage extends AppCompatActivity {
    Button sign_in,sign_up,details,orderdetails;
    DatabaseHelper myDB;
    LinearLayout l1,l2;
    Animation uptodown,downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dien);
        sign_in = (Button) findViewById(R.id.signin);
        sign_up = (Button) findViewById(R.id.signup);
        details = (Button) findViewById(R.id.userinfo);
        orderdetails = (Button) findViewById(R.id.order_details);

        l1 = (LinearLayout) findViewById(R.id.layout1);
        l2 = (LinearLayout) findViewById(R.id.layout2);

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);

        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);



        myDB = new DatabaseHelper(this);
        User_info();
        Order_data();
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinpage = new Intent(getApplicationContext(), dangnhap.class);
                startActivity(signinpage);
                finish();

            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signuppage = new Intent(getApplicationContext(), dangki.class);
                startActivity(signuppage);
                finish();

            }
        });


    }

    public void User_info(){

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDB.GetData();
                if(res.getCount() == 0) {
                    showmessage("lỗi", "không tìm thấy");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){

                    buffer.append("Id : " + res.getString(0) + "\n");
                    buffer.append("Tên tài khoản : " + res.getString(1) + "\n");
                    buffer.append("Mật khẩu : " + res.getString(2)+ "\n");

                }
                showmessage("dữ liệu",buffer.toString());


            }
        });

    }
    public void Order_data(){
        orderdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res =   myDB.Get_OrderDetails();
                if(res.getCount() == 0) {
                    showmessage("lỗi", "không tìm thấy");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){

                    buffer.append("Id : " + res.getString(0) + "\n");
                    buffer.append("Tên mục : " + res.getString(1) + "\n");
                    buffer.append("số lượng : " + res.getString(2)+ "\n");
                    buffer.append("giá : " + res.getString(3)+ "\n");

                }
                showmessage("dữ liệu",buffer.toString());


            }
        });
    }
    public void showmessage(String title,String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

}

