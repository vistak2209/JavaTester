package org.example.design.proxy;

public class SimpleProxyDemo {
    public static void consumer(Interface interace){
        interace.dosomthing();
        interace.somethingElse("bonobo");
    }
    public static void main(String[] args){
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
