package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D08_WishlistStepDef {

    P03_homePage homepage = new P03_homePage();

    @Given("user clicks on add to wishlist button for product {string}")
    public void userClicksOnAddToWishlistButtonForProduct(String product) {
        for(int i = 0 ; i < homepage.productTitles.size();i++)
        {
            if(homepage.productTitles.get(i).getText().toLowerCase().trim().equals(product.toLowerCase().trim())) {
                homepage.wishlistButtons.get(i).click();
            }
        }
    }

    @Then("success message appears to acknowledge the addition")
    public void successMessageAppearsToAcknowledgeTheAddition() {
        SoftAssert softAssert = new SoftAssert();
        Assertions.assertAll(
                () -> softAssert.assertEquals(homepage.wishlistSuccessMessageText.getText(),"The product has been added to your wishlist"),
                () -> softAssert.assertEquals(homepage.wishlistSuccessMessageBackgorund.getCssValue("background-color"),"rgba(76, 177, 124, 1)")
        );
    }

    @And("user waits for success message to disappear")
    public void userWaitsForSuccessMessageToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            wait.until(ExpectedConditions.visibilityOf(homepage.wishlistSuccessMessageText));
            wait.until(ExpectedConditions.invisibilityOf(homepage.wishlistSuccessMessageText));
        } catch (Exception e) {
            Assert.fail("Success message didn't disappear");
        }
    }

    @And("user clicks on wishlist link on top menu")
    public void userClicksOnWishlistLinkOnTopMenu() {
        homepage.wishlistLink.click();
    }

    @Then("product quantity in wishlist is higher than {int}")
    public void productQuantityInWishlistIsHigherThan(int arg0) {
        int quantity = Integer.parseInt(homepage.itemQuantity.getAttribute("value"));
        Assert.assertTrue(quantity > arg0);
    }
}
