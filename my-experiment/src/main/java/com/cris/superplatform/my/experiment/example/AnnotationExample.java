package com.cris.superplatform.my.experiment.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * AnnotationExample
 *
 * @author cris.zhu
 * @date 2019/12/5
 */
public class AnnotationExample {
    @Target({TYPE, METHOD, FIELD, CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnnotationExamples {
        String name();

        int id() default 0;

        Class gid();
    }
}


