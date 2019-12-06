package com.cris.superplatform.my.experiment.example;


import java.util.HashMap;
import java.util.Map;

@AnnotationExample.AnnotationExamples(name = "type", gid = Long.class) //类成员注解
/**
 * UseAnnotationExample
 *
 * @author cris.zhu
 * @date 2019/12/5
 */
public class UseAnnotationExample {

    @AnnotationExample.AnnotationExamples(name = "param", id = 1, gid = Long.class) //类成员注解
    /**
     * age
     */
    private Integer age;

    @AnnotationExample.AnnotationExamples(name = "construct", id = 2, gid = Long.class)//构造方法注解
    /**
     * UseAnnotationExample
     */
    public UseAnnotationExample() {
    }

    @AnnotationExample.AnnotationExamples(name = "public method", id = 3, gid = Long.class) //类方法注解
    /**
     * a
     */
    public void a() {
        Map m = new HashMap(0);
    }

    @AnnotationExample.AnnotationExamples(name = "protected method", id = 4, gid = Long.class) //类方法注解
    /**
     * b
     */
    protected void b() {
        Map m = new HashMap(0);
    }

    @AnnotationExample.AnnotationExamples(name = "private method", id = 5, gid = Long.class) //类方法注解
    /**
     * c
     */
    private void c() {
        Map m = new HashMap(0);
    }

    public void b(Integer a) {
    }
}