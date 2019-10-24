package com.etsy.step_definitions;

import com.etsy.utils.Driver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

public class Hook {

    @Before
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void teardown(){
        Driver.closeDriver();
    }
}
