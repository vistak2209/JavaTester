package org.example.design.factory.method;

public class MethodFactory {
    public static void main(String[] args){
        ICourseFactory factory = new JavaCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new PythonCourseFactory();
        course = factory.create();
        course.record();
    }
}
