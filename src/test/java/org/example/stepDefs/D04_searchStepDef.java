package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {

    P03_homePage homepage = new P03_homePage();

    @Given("user enters the {string} in search bar")
    public void userEntersTheInSearchBar(String productName) {
        homepage.searchBar.sendKeys(productName);
    }

    @When("user clicks on search button")
    public void clickOnSearchButton() {
        homepage.searchButton.click();
    }

    @Then("search results page opens")
    public void searchResultsPageOpens() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
    }

    @And("every product in search page related to {string}")
    public void everyProductInSearchPageRelatedTo(String productName) {
        SoftAssert softAssert = new SoftAssert();
        for(int i = 0 ; i < homepage.products.size() ; i++) {
            String searchName = homepage.products.get(i).findElement(new By.ByTagName("a")).getText();
            softAssert.assertTrue(searchName.toLowerCase().contains(productName));
        }
    }

    @And("user clicks on the product related to sku")
    public void userClicksOnTheProductRelatedToSku() {
        homepage.products.get(0).findElement(By.tagName("a")).click();
    }

    @Then("product sku is similar to the search {string}")
    public void productSkuIsSimilarToTheSearch(String sku) {
        Assert.assertEquals(homepage.productSKU.getText().toLowerCase(),sku.toLowerCase());
    }
}
