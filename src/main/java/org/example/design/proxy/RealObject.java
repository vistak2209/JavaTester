package org.example.design.proxy;

public class RealObject implements Interface {
    @Override
    public void dosomthing() {
        System.out.println("dosomthing");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse: "+ arg);
    }
}
