package org.example.design.factory.abstractor;



public class JavaCourseFactory implements CourseFactory {
    @Override
    public INote createNote() {
        return new JavaNode();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
