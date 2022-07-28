package org.example.design.command.robot;

import org.example.design.proxy.nullhander.example.person.Null;

import java.util.List;

public interface Robot {
    String name();
    String model();
    List<Operation> operations();
    class Test {
        public static void test(Robot r){
            if(r instanceof Null) {
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name: "+r.name());
            System.out.println("Robot model: "+r.model());
            for(Operation operation: r.operations()){
                System.out.println(operation.descripion());
                operation.command();
            }

        }
    }
}
