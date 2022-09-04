package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class D05_hoverCategoriesStepDef {

    P03_homePage homepage = new P03_homePage();

    @Given("user hovers on {string} main category")
    public void userHoversOnMainCategory(String cat) {

        Actions action = new Actions(driver);

        for(int i = 0 ; i < homepage.categories.size() ; i++) {
            if (cat.equals(homepage.categories.get(i).getText())) {
                action.moveToElement(homepage.categories.get(i)).perform();
            }
        }

    }

    @When("user clicks on {string} sub category")
    public void userClicksOnSubCategory(String subCat) {

        for(int i = 0 ; i < homepage.subCategories.size() ; i++) {
            if (subCat.equals(homepage.subCategories.get(i).getText())) {
                homepage.subCategories.get(i).click();
            }
        }

    }

    @Then("{string} page is opened")
    public void pageIsOpened(String expectedTitle) {
        Assert.assertTrue(homepage.pageTitle.getText().toLowerCase().trim().contains(expectedTitle.toLowerCase().trim()));
    }
}
