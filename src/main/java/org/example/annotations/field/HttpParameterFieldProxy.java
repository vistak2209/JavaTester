package org.example.annotations.field;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class HttpParameterFieldProxy implements InvocationHandler {
    HashMap<String,String> parameters = new HashMap<>();
    public HttpParameterFieldProxy(Class<?> classObj){
        for(Method method:classObj.getMethods()){
            String methodName = method.getName();


        }
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return null;
    }
}
