package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D06_homeSlidersStepDef {

    P03_homePage homepage = new P03_homePage();

    @Given("user clicks on {string} slider")
    public void userClicksOnSlider(String product) {
        switch (product) {
            case "Nokia Lumia 1020" :
                homepage.sliders.get(0).click();
                break;
            case "iPhone" :
                homepage.sliders.get(1).click();
                break;
        }
    }

    @Then("{string} page opens")
    public void pageOpens(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String url;
        switch (product) {
            case "Nokia Lumia 1020" :
                url = "https://demo.nopcommerce.com/nokia-lumia-1020";
                try{
                    wait.until(ExpectedConditions.titleIs(url));
                } catch (Exception e) {
                    Assert.assertEquals(driver.getCurrentUrl(),url);
                }
                break;
            case "iPhone" :
                url = "https://demo.nopcommerce.com/iphone-6";
                try{
                    wait.until(ExpectedConditions.titleIs(url));
                } catch (Exception e) {
                    Assert.assertEquals(driver.getCurrentUrl(),url);
                }
                break;
        }
    }
}
