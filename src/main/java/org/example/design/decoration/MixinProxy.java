package org.example.design.decoration;

import org.example.generics.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MixinProxy implements InvocationHandler {
    Map<String,Object> delegatesByMethod;
    public MixinProxy(TwoTuple<Object,Class<?>>... pairs){
        delegatesByMethod = new HashMap<String, Object>();
        for(TwoTuple<Object,Class<?>> pair:pairs){
            for(Method method:pair.second.getMethods()){
                String methodName = method.getName();
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
    public static Object newInstance(TwoTuple... pairs){
        Class[] interfaces = new Class[pairs.length];
        for(int i=0;i<pairs.length;i++){
            interfaces[i]=(Class) pairs[i].second;
        }
        ClassLoader c1 = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(c1,interfaces,new MixinProxy(pairs));
    }
}
