package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_register {

    //With page factory
    public P01_register()
    {
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(className ="ico-register" )
    public WebElement registerlink;

    @FindBy(id = "gender-male")
    public WebElement genderMale;

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    public WebElement birthDay;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement birthMonth;

    @FindBy(name = "DateOfBirthYear")
    public WebElement birthYear;

    @FindBy(id = "Email")
    public WebElement emailAddress;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(id = "register-button")
    public WebElement registerButton;

    @FindBy(className = "result")
    public WebElement resultMessage;

}
