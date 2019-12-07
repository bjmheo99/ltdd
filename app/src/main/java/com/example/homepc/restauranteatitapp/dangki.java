package com.example.homepc.restauranteatitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dangki extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText signupName, signupPassword;
    Button addAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        myDB = new DatabaseHelper(this);
        signupName = (EditText) findViewById(R.id.signup_id);
        signupPassword = (EditText) findViewById(R.id.signup_password);
        addAccount = (Button) findViewById(R.id.add_account);

        Add_User();

    }


    public void Add_User() {


        addAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if ((signupName.getText().toString().equals("")) && (signupPassword.getText().toString().equals("")))
                {

                    Toast.makeText(dangki.this, "Vui lòng nhập tên tài khoản và mật khẩu", Toast.LENGTH_SHORT).show();

                }

                else if ((signupName.getText().toString().equals(""))) {
                    Toast.makeText(dangki.this, "vui lòng nhập tên tài khoản", Toast.LENGTH_SHORT).show();

                }
                else if(signupPassword.getText().toString().equals(""))
                {    Toast.makeText(dangki.this, "vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();

                }
                else
                {

                    boolean isinserted = myDB.Add_Account(signupName.getText().toString(), signupPassword.getText().toString());

                    if (isinserted)
                    {
                        Toast.makeText(dangki.this, "Đăng kí thành công !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), dangnhap.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                        Toast.makeText(dangki.this, "Vui lòng thử lại", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
    }

