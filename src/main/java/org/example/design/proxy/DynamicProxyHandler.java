package org.example.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
    private Object proxited;
    public DynamicProxyHandler(Object proxited){
        this.proxited = proxited;
    }
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: "+ proxited.getClass() +
        ", method: "+ method+ ", args"+args
        );
        if(args!=null){
            for(Object arg:args){

            }
        }
        return method.invoke(proxited,args);
    }
}
