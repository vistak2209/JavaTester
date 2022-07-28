package org.example.design.command.robot;

import org.example.design.proxy.nullhander.example.person.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    private Robot proxied = new NRoot();
    NullRobotProxyHandler(Class<? extends Robot> type){
        nullName = type.getSimpleName()+ "NullRoboot";
    }
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied,args);
    }
    private class NRoot implements Null,Robot{
        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }
}
