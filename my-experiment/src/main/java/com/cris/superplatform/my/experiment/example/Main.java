package com.cris.superplatform.my.experiment.example;

/**
 * Mian
 *
 * @author cris.zhu
 * @date 2019/12/1
 */
public class Main {
    public static void main(String[] args) {
        try {
            MainExample.annotationCase();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}