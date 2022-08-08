package org.example.generics.complex;

public class Product {
    private final int id;
    private String description;
    private double price;
    public Product(int IDnumber,String descr,double price){
        this.id = IDnumber;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }
    public String toString(){
        return id + " : "+description+", price: $"+price;
    }
}
