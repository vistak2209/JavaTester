package org.example.generics.anonymous;

import org.example.design.generator.Generator;

public class Teller {
    private static long counter = 1;
    private final long id = counter++;
    private Teller(){}
    public String toString(){return "Teller: "+id;};
    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };
}
