package com.etsy.pages.base;

public abstract class LoginPageBase {

    //if some functionality is different for android from ios
    //we can create an abstract method
    //and the every platform provide implementation
    //the idea of abstraction is to hide implementation
    //it tells what to do instead of how to do it
    //that's why we create abstract methods
    //for functions that will be done in different way
    //on ios and android
    public abstract void clickLogin();
}
