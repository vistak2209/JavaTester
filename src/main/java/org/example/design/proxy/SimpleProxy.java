package org.example.design.proxy;

public class SimpleProxy implements Interface {
    private Interface proxied;
    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }

    @Override
    public void dosomthing() {
        System.out.println("Simple proxy do Something");
        proxied.dosomthing();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("Simple somethingElse: "+arg);
        proxied.somethingElse(arg);
    }
}
