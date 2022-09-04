package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class D02_loginStepDef {
    P02_login login = new P02_login();

    @Given("user go to login page")
    public void goToLoginPage() {
        login.loginLink.click();
    }

    @When("user login with {string} {string} and {string}")
    public void userLoginWithAnd(String arg0, String email, String password) {
        login.emailAddress.sendKeys(email);
        login.passwordField.sendKeys(password);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.loginButton.click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        Assertions.assertAll(
                () -> softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/"),
                () -> softAssert.assertTrue(login.myAccountLink.isDisplayed())
        );
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert softAssert = new SoftAssert();
        Assertions.assertAll(
                () -> softAssert.assertTrue(login.errorMessage.getText().contains("Login was unsuccessful.")),
                () -> softAssert.assertEquals(Color.fromString(login.errorMessage.getCssValue("color")).asHex(),"#e4434b")
        );
    }
}
