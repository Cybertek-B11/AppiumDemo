package com.etsy.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features"
        },
        glue = {
                "com/etsy/step_definitions"
        },
        dryRun = false

)
public class RunnerIT {

}
