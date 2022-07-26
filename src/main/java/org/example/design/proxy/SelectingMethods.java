package org.example.design.proxy;

import java.lang.reflect.Proxy;

public class SelectingMethods {
    public static void main(String [] args){
        SomeMethods someMethods = (SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[] {SomeMethods.class},
                new MethodSelector(new Implementation())
        );
        someMethods.boring2();
        someMethods.boring1();
        someMethods.boring2();
        someMethods.interesting("boonon");
    }
}
