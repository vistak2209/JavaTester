package org.example.design.generator.reflection.serial;

import java.lang.reflect.Method;

public class Apple {
    public static <T,S extends Iterable<? extends  T>>
    void apply(S seq, Method f, Object... args){
        try{
            for(T t: seq){
                f.invoke(t,args);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
