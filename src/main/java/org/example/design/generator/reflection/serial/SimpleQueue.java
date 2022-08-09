package org.example.design.generator.reflection.serial;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SimpleQueue <T> implements Iterable<T>{
    private LinkedList<T> storage = new LinkedList<T>();
    public void add(T t){storage.offer(t);}
    public  T get(){return storage.poll();}
    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
    @Override
    public void forEach(Consumer<? super T> consumer) {
        Iterable.super.forEach(consumer);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
