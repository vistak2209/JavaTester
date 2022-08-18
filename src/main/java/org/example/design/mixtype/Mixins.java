package org.example.design.mixtype;

public class Mixins {
    public static void main(String[] args){
        Mixin mixin1 = new Mixin(),mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println("getSerialNumber: "+mixin1.getSerialNumber()+" getStamp: "+mixin1.getStamp());
        System.out.println("getSerialNumber: "+mixin2.getSerialNumber()+" getStamp: "+mixin2.getStamp());
    }
}
