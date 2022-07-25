package org.example.design.proxy;

import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.dosomthing();
        iface.somethingElse("bonbon");
    }
    public static void main(String [] args){
        RealObject read = new RealObject();
        consumer(read);
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[] {Interface.class},
                new DynamicProxyHandler(read)
        );
        consumer(proxy);
    }
}
