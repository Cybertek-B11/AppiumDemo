package com.etsy.pages;

import com.etsy.utils.Driver;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private String getStartedButtonLocatorID = "com.etsy.android:id/btn_link";
    private String signInWithEtsyLocatorID = "com.etsy.android:id/btn_sign_in_dialog";
    private String emailLocatorID = "com.etsy.android:id/edit_username";
    private String passwordLocatorID = "com.etsy.android:id/edit_password";
    private String getSignInFormLocatorID = "com.etsy.android:id/button_signin";
    private String etsyLogoLocatorAccessibilityID = "Etsy";

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void loginWithEtsyAccount(String email, String password){
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(getStartedButtonLocatorID)));
        WebElement getStartedButton = Driver.getDriver().findElement(MobileBy.id(getStartedButtonLocatorID));
        getStartedButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(signInWithEtsyLocatorID)));
        WebElement signInWithEtsyAccountButton = Driver.getDriver().findElement(MobileBy.id(signInWithEtsyLocatorID));
        signInWithEtsyAccountButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(emailLocatorID)));
        WebElement emailInputBox = Driver.getDriver().findElement(MobileBy.id(emailLocatorID));
        emailInputBox.sendKeys(email);

        WebElement passwordInputBox = Driver.getDriver().findElement(MobileBy.id(passwordLocatorID));
        passwordInputBox.sendKeys(password);

        WebElement signInButton = Driver.getDriver().findElement(MobileBy.id(getSignInFormLocatorID));
        signInButton.click();
    }

    public void verifyEtsyLogoIsDisplayed(){
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(etsyLogoLocatorAccessibilityID)));
        Assert.assertTrue(Driver.getDriver().findElementByAccessibilityId(etsyLogoLocatorAccessibilityID).isDisplayed());
    }
}
