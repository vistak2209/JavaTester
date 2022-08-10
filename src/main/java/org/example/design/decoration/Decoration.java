package org.example.design.decoration;

public class Decoration {
    public static void main(String[] args){
        TimeStamped t  = new TimeStamped(new Basic());
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));
        SerialNumbered s  = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));

    }
}
