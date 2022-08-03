package org.example.design.generator.method;

import org.example.design.generator.Generator;

public class BasicGeneratorDemo {
    public static void main(String[] main){
        Generator<CountedObject> gen = BaseGenerator.create(CountedObject.class);
        for(int i=0;i<5;i++){
            System.out.println(gen.next());
        }
    }
}
