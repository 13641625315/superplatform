package com.cris.superplatform.my.experiment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MyExperimentController
 *
 * @author cris.zhu
 * @date 2019/11/28
 */
@RestController
public class MyExperimentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyExperimentController.class);

    @GetMapping("/runMyExperiment")
    public void runMyExperiment() {
        LOGGER.info("$$$$$$$$$$$$$$$$$runMyExperiment$$$$$$$$$$$$$$$");
    }
}
