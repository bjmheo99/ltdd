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



public class TraditionalFoodAdapter extends ArrayAdapter<TraditionalfoodClass> {

    int quantity = 0; int i = 0;
    int value = 0; String hold = "";
    int pos = 0, counter = 1;
    String [] order_details = new String[1000];
    DatabaseHelper mydb;
    String Number,Name,Quantity,Price = "";


    public TraditionalFoodAdapter(Activity context, ArrayList<TraditionalfoodClass> trad_food) {
        super(context, 0, trad_food);
        this.mydb = new DatabaseHelper(context.getApplicationContext());

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.menu_design, parent, false);
        }


        TraditionalfoodClass currenttradfood = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.item_name);
        nameTextView.setText(currenttradfood.getItemName());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.item_image);
        imageView.setImageResource(currenttradfood.getImageResourceId());


        TextView priceTextView = (TextView) listItemView.findViewById(R.id.item_price);
        priceTextView.setText("Giá " + currenttradfood.getItemPrice() );


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

        hold = currenttradfood.getItemquantity();
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
                        boolean isinserted = mydb.Add_to_Cart("Cà ri",String.valueOf(quantity),String.valueOf(1250*quantity));
                        if (isinserted)
                        {
                            int price = 1; //price * quantity = total price
                            order_details[i] = "Id " + counter + " Giá Cà ri " + 125000 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Đã thêm đơn hàng thành công !", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getContext(), "Vui lòng thử lại", Toast.LENGTH_SHORT).show();




                    }
                    if (pos == 1) {
                        boolean isinserted =  mydb.Add_to_Cart("Cơm gà",String.valueOf(quantity),String.valueOf(150*quantity));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id " + counter + " Giá cơm gà " + 75000 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Đã thêm đơn hàng thành công !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Vui lòng thử lại", Toast.LENGTH_SHORT).show();




                    }


                    if (pos == 2) {
                        boolean isinserted =  mydb.Add_to_Cart("Nước xốt gà",String.valueOf(quantity),String.valueOf(250*quantity));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id " + counter + " Gá nước xốt gà " + 80000 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Đã thêm đơn hàng thành công !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Vui lòng thử lại", Toast.LENGTH_SHORT).show();
                    }

                    if (pos == 3) {
                        boolean isinserted =  mydb.Add_to_Cart("Gà nướng nguyên con",String.valueOf(quantity),String.valueOf(1550*quantity));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id " + counter + " Giá gà nướng nguyên con " + 100000 * quantity + " ";
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