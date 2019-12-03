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
    public void optionalJudgement() {
        UserModelExample user = null;
        Optional<UserModelExample> userOptional = Optional.ofNullable(user);
        userOptional.map(userModelExample -> userModelExample.getId());
    }
}
