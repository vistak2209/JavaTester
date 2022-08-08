package org.example.design.generator.reflection;

import org.example.design.command.robot.Robot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommuteReflectivity {
    public static void perform(Object speaker){
        Class<?> spkr = speaker.getClass();
        try {
            Method speak = spkr.getMethod("speak");
            speak.invoke(speaker);
        }catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            System.out.println("Speaker can't speak");
        }
        try {
            Method sit = spkr.getMethod("sit");
            sit.invoke(speaker);
        }catch (NoSuchMethodException e){
            System.out.println("Speaker can't sit");
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String args[]){
        CommuteReflectivity.perform(new SmartDog());
        CommuteReflectivity.perform(new Mime());

    }

}
