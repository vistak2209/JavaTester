package org.example.design.factory.abstractor;

public class AbstractFactory {
    public static void main(String[] args){
        run(new JavaCourseFactory());
        run(new PythonCourseFactory());
    }
    public static void run(CourseFactory factory){
        factory.createVideo().edit();
        factory.createNote().record();
    }
}
