package org.example.design.generator.reflection.serial;

import java.util.ArrayList;

public class FilledList <T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type,int size){
        try{
            add(type.newInstance());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
