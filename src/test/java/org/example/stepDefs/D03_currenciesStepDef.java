package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class D03_currenciesStepDef {

    P03_homePage homepage = new P03_homePage();

    @Given("user changed currency to {string}")
    public void userChangedCurrencyTo(String currency) {
        Select dropDown = new Select(homepage.currencyDropDown);
        switch(currency){
            case "Euro" :
                dropDown.selectByIndex(1);
                break;
            case "US Dollar" :
                dropDown.selectByIndex(0);
                break;
        }
    }

    @Then("homepage products are changed to {string}")
    public void homepageProductsAreChangedTo(String currency) {
        for(int i = 0 ; i < homepage.productsPrices.size(); i++)
        {
            String price = homepage.productsPrices.get(i).getText();
            switch(currency){
                case "Euro" :
                    Assert.assertTrue(price.contains("€"));
                    break;
                case "US Dollar" :
                    Assert.assertTrue(price.contains("$"));
                    break;
            }
        }
    }
}
