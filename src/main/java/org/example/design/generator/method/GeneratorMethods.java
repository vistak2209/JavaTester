package org.example.design.generator.method;

public class GeneratorMethods {
    public <T> void f(T x){
        System.out.println(x.getClass().getName());
    }
    public static void main(String[] args){
        GeneratorMethods gm = new GeneratorMethods();
        gm.f("123");
        gm.f(123);
        gm.f('c');
    }
}

