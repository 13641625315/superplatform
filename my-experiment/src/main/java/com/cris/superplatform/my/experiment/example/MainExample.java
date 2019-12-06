package com.cris.superplatform.my.experiment.example;

import com.cris.superplatform.my.experiment.example.model.UserModelExample;

import java.util.Optional;

/**
 * MainExample
 *
 * @author cris.zhu
 * @date 2019/12/1
 */
public class MainExample {

    //Optional Judgement Example
    public static void optionalJudgementCase() {
        UserModelExample user1 = null;
        UserModelExample user2 = new UserModelExample();
        user2.setId("user2");
        UserModelExample user3 = new UserModelExample();
        user3.setId("user3");
        Optional<UserModelExample> userOptional = Optional.ofNullable(user3);
        System.out.println(userOptional.map(userModelExample -> userModelExample.getId()).orElse(user2.getId()));
    }

    public static void annotationCase() throws ClassNotFoundException {
        ParseAnnotationExample.parseTypeAnnotation();
        ParseAnnotationExample.parseMethodAnnotation();
        ParseAnnotationExample.parseConstructAnnotation();
    }
}
