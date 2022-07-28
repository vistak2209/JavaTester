package org.example.design.proxy.nullhander.example.person;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {
    public void add(String title,Person person){
        add(new Position(title,person));
    }
    public void add(String... titles){
        for(String title:titles){
            add(new Position(title));
        }
    }
    public Staff(String... titles){
        add(titles);
    }
    public boolean positionAvailable(String title){
        for(Position position: this){
            if(position.getTitle().equals(title)&&position.getPerson()==Person.NULL){
                return true;
            }
        }
        return false;
    }
    public void fillPosition(String title,Person hire){
        for(Position position:this){
            if(position.getTitle().equals(title)&&position.getPerson()==Person.NULL){
                position.setPerson(hire);
                return;
            }
        }
        throw new RuntimeException("Position "+title+" not available");
    }
    public static void main(String[] args){
        Staff staff = new Staff("AAA","BBB","CCC","DDD","EEE","FFF");
        staff.fillPosition("AAA",new Person("Me","Last","The Top,Lonly At"));
        staff.fillPosition("CCC",new Person("Jenet","Planner","Taiwan"));
        if(staff.positionAvailable("EEE")){
            staff.fillPosition("EEE",new Person("Bob","Coder","Canada"));
        }
        if(staff.positionAvailable("AD")){
            staff.fillPosition("AD",new Person("Bob","Coder","Canada"));
        }
        System.out.println(staff);
    }
}
