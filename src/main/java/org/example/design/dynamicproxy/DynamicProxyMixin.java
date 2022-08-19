package org.example.design.dynamicproxy;


import org.example.design.mixtype.*;


import static org.example.design.generator.base.tuple.Tuple.tuple;

public class DynamicProxyMixin {
    public static void main(String[] args){
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImp(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImp(), SerialNumbered.class)
        );
        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped)mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
    }
}
