package org.example.annotations.field;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        BuildTagDTO buildTagInfo =  new BuildTagDTO();
        buildTagInfo.setComponentName("tes123");
        buildTagInfo.setBuildTask("11111");
        Field[] fields= BuildTagDTO.class.getDeclaredFields();
        for(Field field:fields){

            HttpParameters httpParameters = field.getAnnotation(HttpParameters.class);
            if(httpParameters==null)continue;
            System.out.println(field.get(buildTagInfo));
            //Method method = BuildTagDTO.class.getMethod("getComponentName");
            //Object value = method.invoke(buildTagInfo);
            //System.out.println(""+value);
            //System.out.println(httpParameters.name()+" "+field.get(""));
        }
    }
}
