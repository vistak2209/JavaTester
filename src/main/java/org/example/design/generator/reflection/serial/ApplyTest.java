package org.example.design.generator.reflection.serial;

import java.util.ArrayList;
import java.util.List;

public class ApplyTest {
    public static void main(String[] args) throws Exception{
        List<Shape> shapes = new ArrayList<Shape>();
        for(int i=0;i<10;i++){
            shapes.add(new Shape());
        }
        Apple.apply(shapes,Shape.class.getMethod("rotate"));
        Apple.apply(shapes,Shape.class.getMethod("resize",int.class),5);
        List<Square> squares= new ArrayList<Square>();
        for(int i=0;i<10;i++){shapes.add(new Square());}
        Apple.apply(squares,Shape.class.getMethod("rotate"));
        Apple.apply(squares,Shape.class.getMethod("resize",int.class),5);

        Apple.apply(new FilledList<Shape>(Shape.class,10),Shape.class.getMethod("rotate"));
        Apple.apply(new FilledList<Shape>(Square.class,10),Shape.class.getMethod("rotate"));

        SimpleQueue<Shape> shapeQ = new SimpleQueue<Shape>();
        for(int i=0;i<5;i++){
            shapeQ.add(new Shape());
            shapeQ.add(new Square());
        }
        Apple.apply(shapeQ,Shape.class.getMethod("rotate"));
    }
}
