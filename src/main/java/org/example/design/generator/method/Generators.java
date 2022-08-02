package org.example.design.generator.method;

import org.example.design.generator.Generator;
import org.example.design.generator.cofficemaker.Coffee;
import org.example.design.generator.cofficemaker.CoffeeGenerator;
import org.example.design.generator.fibonacci.Fibonacci;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen,int n){
        for(int i=0;i<n;i++){
            coll.add(gen.next());
        }
        return coll;
    }
    public static void main(String[] args){
        Collection<Coffee> coffees = fill(new ArrayList<Coffee>(),new CoffeeGenerator(),4);
        for(Coffee c: coffees){
            System.out.println(c);
        }
        Collection<Integer> fnumbers = fill(new ArrayList<Integer>(),new Fibonacci(),12);
        for(int i :fnumbers){
            System.out.println(i+ " . ");
        }

    }
}
