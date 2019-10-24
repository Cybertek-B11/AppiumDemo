package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.KeyEvent;
import java.net.URL;

public class FirstAppiumTest {
    public AppiumDriver driver;

    @Test
    public void test1() throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixel_2_API_24");
        desiredCapabilities.setCapability("platform", "Android");
        desiredCapabilities.setCapability("platformVersion", "7.0");
        //this is a path to the application that we test
        //it can be locally, or on some cloud storage
        //I put this application on S3 bucket
        desiredCapabilities.setCapability("app", "http://cybertek-resumes.s3.amazonaws.com/appium/Etsy+Handmade+Vintage+Goods_v5.30.0_apkpure.com.apk");
        desiredCapabilities.setCapability("adbExecTimeout", "20000");
        try {
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.findElementByXPath("//*[@text='Search']").click();

        //we added explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //for mobile applications, accessibility id is like an in for web applications.
        //it's the best way to allocate element,
        //because it's the fastest and the most reliable way to find element
        //presenceOfElementLocated means that element should be present, not exactly visible
        //if element doesn't present, you will NoSuchElementException/element couldn't be found
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Clothing Button")));

        driver.findElementByAccessibilityId("Clothing Button").click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//*[@text='All']")));

        driver.findElement(By.xpath("//*[@text='All']")).click();


        //if you (isDisplayed(), and in case element doesn't present)
        //webdriver will fail on th findElement stage
        //but, if we use findElements
        //we are getting list of elements
        //if list is empty - element doesn't present
        //no failure will occur if list is empty
        //close banner

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.etsy.android:id/tooltip_x")));

        driver.findElement(MobileBy.id("com.etsy.android:id/tooltip_x")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.etsy.android:id/search_src_text")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("com.etsy.android:id/search_src_text")));

        //enter text
        WebElement inputBox =  driver.findElement(MobileBy.id("com.etsy.android:id/search_src_text"));
        //click on input box
        inputBox.click();
        //enter text
        inputBox.sendKeys("wooden spoon");
        //text was entered completely
        wait.until(ExpectedConditions.textToBe(MobileBy.id("com.etsy.android:id/search_src_text"), "wooden spoon"));
        //we are using keyboard to enter text
        driver.getKeyboard().pressKey(Keys.ENTER);

        //wait for first search result
        //we are using a lot of waits because appium is slow
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.etsy.android:id/listing_image")));
        WebElement firstResult = driver.findElement(MobileBy.id("com.etsy.android:id/listing_image"));
        wait.until(ExpectedConditions.visibilityOf(firstResult));
        //for touch actions
        TouchAction action = new TouchAction(driver);
        //to tap on specific element
        //also we can tap based on coordinates
        //right now we are tapping on specific element
        action.tap(new TapOptions().withElement(new ElementOption().withElement(firstResult))).perform();
        Thread.sleep(5000);
    }


    //with sauce labs
    @Test
    public void test2() throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S6");
        desiredCapabilities.setCapability("platform", "Android");
        desiredCapabilities.setCapability("platformVersion", "7.0");
        //this is a path to the application that we test
        //it can be locally, or on some cloud storage
        //I put this application on S3 bucket
        desiredCapabilities.setCapability("app", "http://cybertek-resumes.s3.amazonaws.com/appium/Etsy+Handmade+Vintage+Goods_v5.30.0_apkpure.com.apk");
        desiredCapabilities.setCapability("adbExecTimeout", "20000");
        desiredCapabilities.setCapability("testobject_api_key", "F7ADDC3F3EC042E8822718DEE010FAEF");
        try {
            driver = new AndroidDriver<>(new URL("https://us1-manual.app.testobject.com/wd/hub"), desiredCapabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.findElementByXPath("//*[@text='Search']").click();

        //we added explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //for mobile applications, accessibility id is like an in for web applications.
        //it's the best way to allocate element,
        //because it's the fastest and the most reliable way to find element
        //presenceOfElementLocated means that element should be present, not exactly visible
        //if element doesn't present, you will NoSuchElementException/element couldn't be found
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Clothing Button")));

        driver.findElementByAccessibilityId("Clothing Button").click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//*[@text='All']")));

        driver.findElement(By.xpath("//*[@text='All']")).click();


        //if you (isDisplayed(), and in case element doesn't present)
        //webdriver will fail on th findElement stage
        //but, if we use findElements
        //we are getting list of elements
        //if list is empty - element doesn't present
        //no failure will occur if list is empty
        //close banner

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.etsy.android:id/tooltip_x")));

        driver.findElement(MobileBy.id("com.etsy.android:id/tooltip_x")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.etsy.android:id/search_src_text")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("com.etsy.android:id/search_src_text")));

        //enter text
        WebElement inputBox =  driver.findElement(MobileBy.id("com.etsy.android:id/search_src_text"));
        //click on input box
        inputBox.click();
        //enter text
        inputBox.sendKeys("wooden spoon");
        //text was entered completely
        wait.until(ExpectedConditions.textToBe(MobileBy.id("com.etsy.android:id/search_src_text"), "wooden spoon"));
        //we are using keyboard to enter text
        driver.getKeyboard().pressKey(Keys.ENTER);

        //wait for first search result
        //we are using a lot of waits because appium is slow
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.etsy.android:id/listing_image")));
        WebElement firstResult = driver.findElement(MobileBy.id("com.etsy.android:id/listing_image"));
        wait.until(ExpectedConditions.visibilityOf(firstResult));
        //for touch actions
        TouchAction action = new TouchAction(driver);
        //to tap on specific element
        //also we can tap based on coordinates
        //right now we are tapping on specific element
        action.tap(new TapOptions().withElement(new ElementOption().withElement(firstResult))).perform();
        Thread.sleep(5000);
    }
}
