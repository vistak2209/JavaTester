package org.example.design.generator.base.set;
import java.lang.reflect.Method;
import java.util.*;

public class ContainerMethodDifferences {
    static Set<String> methodSet(Class<?> type){
        Set<String> result = new TreeSet<String>();
        for(Method m: type.getMethods()){
            result.add(m.getName());
        }
        return result;
    }
    static void interfaces(Class<?> type){
        System.out.print("Interface in "+type.getSimpleName()+" : ");
        List<String> result = new ArrayList<String>();
        for(Class<?> c :type.getInterfaces()){
            result.add(c.getSimpleName());
        }
        System.out.println(result);
    }
    static Set<String> object = methodSet(Object.class);
    static {object.add("clone");}
    static void difference(Class<?> superset,Class<?> subset){
        System.out.println(superset.getSimpleName()+ " extends "+ subset.getSimpleName());
        Set<String> comp =  Sets.difference(
                methodSet(superset),methodSet(subset)
        );
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superset);

    }
    public static void main(String [] args){
        difference(Collection.class,HashMap.class);
        difference(Integer.class,HashMap.class);
    }


}
