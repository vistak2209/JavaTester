package org.example.design.command.robot;

import org.example.design.proxy.nullhander.example.person.Null;

import java.lang.reflect.Proxy;

public class NullRoot {
    public static Robot newNullRobot(Class<? extends Robot> type){
        return (Robot) Proxy.newProxyInstance(
                NullRoot.class.getClassLoader(),
                new Class[] {Null.class,Robot.class},
                new NullRobotProxyHandler(type)
        );
    }
    public static void main(String[] args){
        Robot[] bots = {
            new SnowRemovalRobot("SnowBee"),
            newNullRobot(SnowRemovalRobot.class)
        };
        for(Robot bot:bots){
            Robot.Test.test(bot);
        }
    }
}
