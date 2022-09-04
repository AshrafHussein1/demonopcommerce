package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_login {

    public P02_login() {PageFactory.initElements(Hooks.driver,this);}

    @FindBy(className = "ico-login")
    public WebElement loginLink;

    @FindBy(id = "Email")
    public WebElement emailAddress;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(css = "button[class=\"button-1 login-button\"]")
    public WebElement loginButton;

    @FindBy(css = "div[class=\"message-error validation-summary-errors\"]")
    public WebElement errorMessage;

    @FindBy(className = "ico-account")
    public WebElement myAccountLink;


}
