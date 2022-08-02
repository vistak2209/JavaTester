package org.example.design.generator.cofficemaker;

import org.example.design.generator.Generator;

import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee> {
    private Class[] types = {
            Americano.class, Cappuccino.class, Latte.class, Mocha.class
    };
    private static Random rand = new Random(47);
    private int size = 0;

    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int sz) {
        size = sz;
    }


    @Override
    public void forEach(Consumer<? super Coffee> consumer) {
        Iterable.super.forEach(consumer);
    }

    @Override
    public Spliterator<Coffee> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void remove(){
        throw new UnsupportedOperationException();
    }


    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count>0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }
    public Iterator<Coffee> iterator(){
        return new CoffeeIterator();
    }
    public static void main(String[] args){
        CoffeeGenerator gen = new CoffeeGenerator();
        for(int i=0;i<5;i++){
            System.out.println(gen.next());
        }
        for (Coffee c:new CoffeeGenerator(10)){
            System.out.println(c);
        }
    }
}
