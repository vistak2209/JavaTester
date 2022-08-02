package org.example.design.generator.fibonacci;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
//This is a kind of adaptor mode
public class IterableFinonacci extends Fibonacci implements Iterable<Integer>{
    private int n;
    public IterableFinonacci(int count){n=count;}
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n>0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFinonacci.this.next();
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Integer> consumer) {
        Iterable.super.forEach(consumer);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Iterable.super.spliterator();
    }
    public static void main(String[] args){
        for(int i: new IterableFinonacci(18)){
            System.out.println(i+" ");
        }
    }
}
