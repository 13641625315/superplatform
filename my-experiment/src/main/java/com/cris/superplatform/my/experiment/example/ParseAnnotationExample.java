package com.cris.superplatform.my.experiment.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ParseAnnotationExample {
    public static void parseTypeAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("com.cris.superplatform.my.experiment.example.UseAnnotationExample");

        Annotation[] annotations = clazz.getAnnotations();
        for (
                Annotation annotation : annotations) {
            AnnotationExample.AnnotationExamples testA = (AnnotationExample.AnnotationExamples) annotation;
            System.out.println("id= " + testA.id() + "; name= " + testA.name() + "; gid = " + testA.gid());
        }

    }

    public static void parseMethodAnnotation() {
        Method[] methods = UseAnnotationExample.class.getDeclaredMethods();
        for (Method method : methods) {

            boolean hasAnnotation = method.isAnnotationPresent(AnnotationExample.AnnotationExamples.class);
            if (hasAnnotation) {

                AnnotationExample.AnnotationExamples annotation = method.getAnnotation(AnnotationExample.AnnotationExamples.class);
                System.out.println("method = " + method.getName()
                        + " ; id = " + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= " + annotation.gid());
            }
        }
    }

    public static void parseConstructAnnotation() {
        Constructor[] constructors = UseAnnotationExample.class.getConstructors();
        for (Constructor constructor : constructors) {

            boolean hasAnnotation = constructor.isAnnotationPresent(AnnotationExample.AnnotationExamples.class);
            if (hasAnnotation) {

                AnnotationExample.AnnotationExamples annotation = (AnnotationExample.AnnotationExamples) constructor.getAnnotation(AnnotationExample.AnnotationExamples.class);
                System.out.println("constructor = " + constructor.getName()
                        + " ; id = " + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= " + annotation.gid());
            }
        }
    }
}
