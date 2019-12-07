package com.example.homepc.restauranteatitapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Do_an_nhanh_Adapter extends ArrayAdapter<Do_an_nhanh_Class> {

    int quantity = 0; int i = 0;
    int value = 0; String hold = "";
    int pos = 0, counter = 1;
    String [] order_details = new String[1000];
    DatabaseHelper mydb;
    String Number,Name,Quantity,Price = "";


    public Do_an_nhanh_Adapter(Activity context, ArrayList<Do_an_nhanh_Class> fastfood) {
        super(context, 0, fastfood);
        this.mydb = new DatabaseHelper(context.getApplicationContext());

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.menu_design, parent, false);
        }

        Do_an_nhanh_Class currentfastfood = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.item_image);
        imageView.setImageResource(currentfastfood.getImageResourceId());


        TextView nameTextView = (TextView) listItemView.findViewById(R.id.item_name);
        nameTextView.setText(currentfastfood.getItemName());

        TextView priceTextView = (TextView) listItemView.findViewById(R.id.item_price);
        priceTextView.setText("Giá " + currentfastfood.getItemPrice());


        Button plus = (Button) listItemView.findViewById(R.id.plus_btn);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = quantity + 1;

            }
        });

        Button minus = (Button) listItemView.findViewById(R.id.minus_btn);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (quantity > 0) quantity = quantity + 1;
                else quantity = quantity;

            }
        });


        hold = currentfastfood.getItemquantity();
        value = Integer.parseInt(hold);
        quantity = value + quantity;

        TextView quantityTextView = (TextView) listItemView.findViewById(R.id.quantity);
        quantityTextView.setText(String.valueOf(quantity));

        Button cart_btn = (Button) listItemView.findViewById(R.id.cart_btn);
        cart_btn.setTag(position);

        cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cart_btn.setEnabled(false);
                pos = (Integer)view.getTag();
                if(quantity != 0) { //if quan < 0 or equals to 0
                    if (pos == 0) {
                        boolean isinserted = mydb.Add_to_Cart("Bánh mỳ kẹp thịt",String.valueOf(quantity),String.valueOf(250*quantity));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id " + counter + " Giá bánh my kẹp thịt " + 40000 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Đã thêm đơn hàng thành công !", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getContext(), "\n" +
                                    "Vui lòng thử lại", Toast.LENGTH_SHORT).show();




                    }
                    if (pos == 1) {
                        boolean isinserted =  mydb.Add_to_Cart("hamburger",String.valueOf(quantity),String.valueOf(220*quantity));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id " + counter + " giá hamburger " + 100000 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Đã thêm đơn hàng thành công !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Vui lòng thử lại", Toast.LENGTH_SHORT).show();




                    }
                    if (pos == 2) {
                        boolean isinserted = mydb.Add_to_Cart("Kim chi",String.valueOf(quantity),String.valueOf(350*quantity));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id : " + counter + " Giá kim chi " + 70000 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Đã thêm đơn hàng thành công !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Vui lòng thử lại", Toast.LENGTH_SHORT).show();





                    }
                    if (pos == 3) {

                        boolean isinserted = mydb.Add_to_Cart("Khoai tây chiên",String.valueOf(quantity),String.valueOf(120*quantity));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id " + counter + " giá khoai tây chiên " + 120000 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Đã thêm đơn hàng thành công !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Vui lòng thử lại", Toast.LENGTH_SHORT).show();

                    }
                    if (pos == 4) {

                        boolean isinserted = mydb.Add_to_Cart("bánh Sandwich",String.valueOf(quantity),String.valueOf(250*quantity));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id " + counter + " Giá bánh Sandwich " + 30000 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Đã thêm đơn hàng thành công !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Vui lòng thử lại", Toast.LENGTH_SHORT).show();

                    }

                    if (pos == 5) {

                        boolean isinserted = mydb.Add_to_Cart("Cánh gà",String.valueOf(quantity),String.valueOf(170*quantity));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id " + counter + "Giá cánh gà " + 70000 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Đã thêm đơn hàng thành công !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Vui lòng thử lại", Toast.LENGTH_SHORT).show();

                    }

                    if (pos == 6) {

                        boolean isinserted = mydb.Add_to_Cart("Thịt gà nướng",String.valueOf(quantity),String.valueOf(550*quantity));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id " + counter + " Giá thịt gà nướng " + 55000 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Đã thêm đơn hàng thành công !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Vui lòng thử lại", Toast.LENGTH_SHORT).show();

                    }

                    if (pos == 7) {

                        boolean isinserted = mydb.Add_to_Cart("Gà chiên cốm",String.valueOf(quantity),String.valueOf(200*quantity));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id " + counter + " Giá gà chiên cốm " + 120000 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Đã thêm đơn hàng thành công !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Vui lòng thử lại", Toast.LENGTH_SHORT).show();

                    }



                } else {  Toast.makeText(getContext(), "Số lượng giá trị không thể bằng 0 hoặc ít hơn!!!", Toast.LENGTH_SHORT).show();

                    int j = 0;
                    Toast.makeText(getContext(), "" + order_details[j] + "\n" + order_details[j+1] + "\n"+ order_details[j+2] + "\n" + order_details[j+3], Toast.LENGTH_LONG).show();

                }




            }
        });

        return listItemView;
    }
}