package org.example.design.dynamicproxy;

import org.example.generics.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MixinProxy implements InvocationHandler {
    Map<String,Object> delegatesByMethod;
    public MixinProxy(TwoTuple<Object,Class<?>>... pairs){
        System.out.println("constructing");
        delegatesByMethod = new HashMap<String, Object>();
        for(TwoTuple<Object,Class<?>> pair:pairs){
            for(Method method:pair.second.getMethods()){
                String methodName = method.getName();
                System.out.println("methodName: "+methodName);
                if(!delegatesByMethod.containsKey(methodName)){
                    delegatesByMethod.put(methodName,pair.first);
                }

            }
        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName =method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate,args);
    }
    @SuppressWarnings("unchecked")
    public static Object newInstance(TwoTuple... pairs){
        Class[] interfaces = new Class[pairs.length];
        for(int i=0;i<pairs.length;i++){
            System.out.println("newInstance--> "+pairs[i].second.getClass().getName());
            interfaces[i]=(Class) pairs[i].second;
        }
        ClassLoader c1 = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(c1,interfaces,new MixinProxy(pairs));
    }
}
