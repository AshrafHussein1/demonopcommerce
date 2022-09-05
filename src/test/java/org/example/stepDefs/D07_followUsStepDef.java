package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;

import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class D07_followUsStepDef {

    P03_homePage homepage = new P03_homePage();

    @Given("user opens facebook link")
    public void userOpensFacebookLink() {
        homepage.facebookButton.click();
    }

    @Given("user opens twitter link")
    public void userOpensTwitterLink() {
        homepage.twitterButton.click();
    }

    @Given("user opens rss link")
    public void userOpensRssLink() {
        homepage.rssButton.click();
    }

    @Given("user opens youtube link")
    public void userOpensYoutubeLink() {
        homepage.youtubeButton.click();
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String link) throws InterruptedException {
        Thread.sleep(2000);
        if(driver.getWindowHandles().size() != 2) {
            Assert.fail("No new tab opened");
        }
        else
        {
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Assert.assertTrue(driver.getCurrentUrl().startsWith(link));
        }
    }
}
