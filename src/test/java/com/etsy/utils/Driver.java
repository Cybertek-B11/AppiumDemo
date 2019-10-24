package com.etsy.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Driver {
    private static AppiumDriver driver;
    private static DesiredCapabilities desiredCapabilities;

    private Driver() {

    }

    public static void setupDriver() {
        String platform = System.getProperty("platform");
        //if platform parameter was not passed as an env variable -Dplatform
        //when we execute command in terminal: mvn test Dplatform=android
        if (platform == null) {
            //then use parameter from the configuration.properties file
            platform = ConfigurationReader.getProperty("platform");
        }
        platform = platform.toLowerCase();
        switch (platform) {
            case "android":
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("deviceName", "Pixel_2_API_24");
                desiredCapabilities.setCapability("platform", "Android");
                desiredCapabilities.setCapability("platformVersion", "7.0");
                //this is a path to the application that we test
                //it can be locally, or on some cloud storage
                //I put this application on S3 bucket
                desiredCapabilities.setCapability("app", ConfigurationReader.getProperty("android.app.path"));
                desiredCapabilities.setCapability("adbExecTimeout", "20000");
                try {
                    driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "android_sauce_labs":
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S6");
                desiredCapabilities.setCapability("platform", "Android");
                desiredCapabilities.setCapability("platformVersion", "7.0");
                //this is a path to the application that we test
                //it can be locally, or on some cloud storage
                //I put this application on S3 bucket
                desiredCapabilities.setCapability("app", ConfigurationReader.getProperty("android.app.path"));
                desiredCapabilities.setCapability("adbExecTimeout", "20000");
                desiredCapabilities.setCapability("testobject_api_key", "F7ADDC3F3EC042E8822718DEE010FAEF");
                try {
                    driver = new AndroidDriver<>(new URL("https://us1-manual.app.testobject.com/wd/hub"), desiredCapabilities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "ios":
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("deviceName", "Iphone 7");
                desiredCapabilities.setCapability("platform", "IOS");
                desiredCapabilities.setCapability("platformVersion", "12.1");
                //this is a path to the application that we test
                //it can be locally, or on some cloud storage
                //I put this application on S3 bucket
                //for IOS, you need different app. APK it's only for android
                desiredCapabilities.setCapability("app", ConfigurationReader.getProperty("ios.app.path"));
                desiredCapabilities.setCapability("adbExecTimeout", "20000");
                try {
                    driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    //to return driver instance
    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void closeDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
