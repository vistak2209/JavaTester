package org.example.design.command.robot;

import java.util.Arrays;
import java.util.List;

public class SnowRemovalRobot implements Robot{
    private String name;
    public SnowRemovalRobot(String name){
        this.name = name;
    }
    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot Series 11";
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    @Override
                    public String descripion() {
                        return "can shovel snow";
                    }
                    @Override
                    public void command() {
                        System.out.println(name + " is shoveling snow");
                    }
                },
                new Operation() {
                    @Override
                    public String descripion() {
                        return "can chip ice";
                    }
                    @Override
                    public void command() {
                        System.out.println(name + " is chipping ice");
                    }
                },                new Operation() {
                    @Override
                    public String descripion() {
                        return "can clear the roof";
                    }
                    @Override
                    public void command() {
                        System.out.println(name + " is clearing roof");
                    }
                }
        );
    }
    public static void main(String[] args){
        Robot.Test.test(new SnowRemovalRobot("Slusher"));
    }
}
