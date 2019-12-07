package com.example.homepc.restauranteatitapp;



public class Do_an_nhanh_Class {


        private String Itemname;
        private String Itemprice;
        private int Itemimage;


    public String Itemquantity;

    public Do_an_nhanh_Class(String iName, String iPrice, int iImage, String iquantity)
    {
        Itemname = iName;
        Itemprice = iPrice;
        Itemimage = iImage;
        Itemquantity = iquantity;



    }
    public String getItemName() {
        return Itemname;
    }

    public String getItemPrice() {return Itemprice;}

    public int getImageResourceId() {return Itemimage;}

    public String getItemquantity() {return Itemquantity;}




}


