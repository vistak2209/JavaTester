package org.example.generics;

public class TupleTest {
    static TwoTuple<String,Integer> f(){
        return new TwoTuple<String,Integer>("hi",47);
    }
    static ThreeTuple<Amphibian,String,Integer> g(){
        return new ThreeTuple<Amphibian,String,Integer>(new Amphibian(),"hi",47);
    }
    public static void main(String[] args){
        TwoTuple<String,Integer>  ttsi = f();
        System.out.println(ttsi);
        System.out.println(g());
        System.out.println(f());
    }
}
