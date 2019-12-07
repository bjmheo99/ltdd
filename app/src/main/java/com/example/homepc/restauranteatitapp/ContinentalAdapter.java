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



public class ContinentalAdapter extends ArrayAdapter<ContinentalClass> {

    int Contiquantity = 0; int i = 0;
    int Contivalue = 0; String Contihold = "";
    int Contipos = 0, Conticounter = 1;
    String [] Contiorder_details = new String[1000];
    DatabaseHelper mydb;
    String Number,Name,Quantity,Price = "";

    public ContinentalAdapter(Activity context, ArrayList<ContinentalClass> conti_food) {
        super(context, 0, conti_food);
        this.mydb = new DatabaseHelper(context.getApplicationContext());

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.menu_design, parent, false);
        }

        ContinentalClass currentcontifood = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.item_image);
        imageView.setImageResource(currentcontifood.getImageResourceId());

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.item_name);
        nameTextView.setText(currentcontifood.getItemName());


        TextView priceTextView = (TextView) listItemView.findViewById(R.id.item_price);
        priceTextView.setText("Giá" + currentcontifood.getItemPrice() );


        Button plus = (Button) listItemView.findViewById(R.id.plus_btn);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contiquantity = Contiquantity + 1;

            }
        });

        Button minus = (Button) listItemView.findViewById(R.id.minus_btn);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Contiquantity > 0) Contiquantity = Contiquantity + 1;
                else Contiquantity = Contiquantity;

            }
        });



        Contihold = currentcontifood.getItemquantity();
        Contivalue = Integer.parseInt(Contihold);
        Contiquantity = Contivalue + Contiquantity;

        TextView quantityTextView = (TextView) listItemView.findViewById(R.id.quantity);
        quantityTextView.setText(String.valueOf(Contiquantity));

        Button cart_btn = (Button) listItemView.findViewById(R.id.cart_btn);
        cart_btn.setTag(position);


        cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //cart_btn.setEnabled(false);
                Contipos = (Integer)view.getTag();
                if(Contiquantity != 0) { //if quan < 0 or equals to 0
                    if (Contipos == 0) {
                        boolean isinserted = mydb.Add_to_Cart("Kem",String.valueOf(Contiquantity),String.valueOf(30000*Contiquantity));
                        if (isinserted)
                        {
                            int price = 1; //price * quantity = total price
                            Contiorder_details[i] = "Id " + Conticounter + " giá Kem " + 30000 * Contiquantity + " ";
                            Conticounter++;
                            i++;
                            Contiquantity = 0;
                            Toast.makeText(getContext(), "thêm đơn hàng thành công!", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getContext(), "vui lòng thử lại", Toast.LENGTH_SHORT).show();




                    }
                    if (Contipos == 1) {
                        boolean isinserted =  mydb.Add_to_Cart("pizza",String.valueOf(Contiquantity),String.valueOf(1150*Contiquantity));
                        if (isinserted)
                        {
                            int price = 1;
                            Contiorder_details[i] = "Id " + Conticounter + " giá pizza " + 85000 * Contiquantity + " ";
                            Conticounter++;
                            i++;
                            Contiquantity = 0;
                            Toast.makeText(getContext(), "thêm đơn hàng thành công!", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "vui lòng thử lại", Toast.LENGTH_SHORT).show();




                    }
                    if (Contipos == 2) {
                        boolean isinserted = mydb.Add_to_Cart("Mì ống ",String.valueOf(Contiquantity),String.valueOf(250*Contiquantity));
                        if (isinserted)
                        {
                            int price = 1;
                            Contiorder_details[i] = "Id : " + Conticounter + " giá mì ống " + 65000 * Contiquantity + " ";
                            Conticounter++;
                            i++;
                            Contiquantity = 0;
                            Toast.makeText(getContext(), "thêm đơn hàng thành công!", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "vui lòng thử lại", Toast.LENGTH_SHORT).show();





                    }
                    if (Contipos == 3) {

                        boolean isinserted = mydb.Add_to_Cart("nấm",String.valueOf(Contiquantity),String.valueOf(190*Contiquantity));
                        if (isinserted)
                        {
                            int price = 1;
                            Contiorder_details[i] = "Id " + Conticounter + " giá nấm " + 50000 * Contiquantity + " ";
                            Conticounter++;
                            i++;
                            Contiquantity = 0;
                            Toast.makeText(getContext(), "thêm đơn hàng thành công!", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "vui lòng thử lại", Toast.LENGTH_SHORT).show();





                    }


                } else {  Toast.makeText(getContext(), "Số lượng giá trị không thể bằng 0 hoặc ít hơn!!!", Toast.LENGTH_SHORT).show();

                    int j = 0;
                    Toast.makeText(getContext(), "" + Contiorder_details[j] + "\n" + Contiorder_details[j+1] + "\n"+ Contiorder_details[j+2] + "\n" + Contiorder_details[j+3], Toast.LENGTH_LONG).show();

                }




            }
        });



        return listItemView;
    }

}
