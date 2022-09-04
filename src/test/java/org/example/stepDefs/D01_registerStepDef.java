package org.example.stepDefs;

import io.cucumber.java.en.*;
import org.example.pages.P01_register;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class D01_registerStepDef {

    P01_register register = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage() {
        register.registerlink.click();
    }

    @When("user select gender type")
    public void selectGender() {
        register.genderMale.click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String firstName, String lastName) {
        register.firstName.sendKeys(firstName);
        register.lastName.sendKeys(lastName);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        Select dropDown = new Select(register.birthDay);
        dropDown.selectByValue("23");

        dropDown = new Select(register.birthMonth);
        dropDown.selectByValue("4");

        dropDown = new Select(register.birthYear);
        dropDown.selectByValue("1991");
        
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String email) {
        register.emailAddress.sendKeys(email);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String password, String confirmPassword) {
        register.passwordField.sendKeys(password);
        register.confirmPassword.sendKeys(confirmPassword);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.registerButton.click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(register.resultMessage.getText(),"Your registration completed");
        softAssert.assertEquals(register.resultMessage.getCssValue("color"),"rgba(76, 177, 124, 1)");
    }
}
