package smoke.general_test;

import annotations.TestName;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static pages.BasePage.closeWelcomeMessage;
import static pages.BasePage.pageURL;

public class Header_Navigation_Test extends BaseTest{

    @Test
    @TestName(name="Header Navigation Test")

    public static void HeaderNavigationTest(){

        open(baseUrl);
        closeWelcomeMessage();

        PageHeader.openMattressesPlp();
        //Assert.assertTrue(title().equals(MattressPlp.pageTitle), "Page title is: " + title());
        Assert.assertEquals(url(), baseUrl + "/mattresses");

        PageHeader.openMattressByType("Black");
        //Assert.assertTrue(title().equals("Black"), "title is: " + title());
        Assert.assertEquals(url(), baseUrl + "/black", "Page url is: " + url());

        PageHeader.openMattressByType("Silver");
        //Assert.assertTrue(title().equals("Silver"), "title is: " + title());
        Assert.assertEquals(url(), baseUrl + "/silver", "Page url is: " + url());

        PageHeader.openMattressByType("Platinum");
        //Assert.assertTrue(title().equals("Platinum"), "title is: " + title());
        Assert.assertEquals(url(), baseUrl + "/platinum", "Page url is: " + url());

        PageHeader.openMattressInABox();
        //Assert.assertTrue(title().equals(MattressInABoxPlp.pageTitle), "Page title is: " + title());
        Assert.assertEquals(url(), baseUrl + "/mattress-in-a-box", "Page url is: " + url());

        PageHeader.openAdjustableBase();
        //Assert.assertTrue(title().equals(AdjustableBasePlp.pageTitle), "Page title is: " + title());
        Assert.assertTrue(url().contains("/adjustable-beds"), "Page url is: " + url());

        PageHeader.openAccessoryByType("Sleeptracker");
        //Assert.assertTrue(title().equals("Beautyrest Sleeptracker | Sleep Monitor Technology | Beautyrest"), "Page title is: " + title());
        Assert.assertTrue(url().contains("/sleeptracker"), "Page url is: " + url());
        // baseUrl + "/sleeptracker", "Page url is: " + url());

        PageHeader.openAccessoryByType("Pillows");
        //Assert.assertTrue(title().equals("Pillows | Beautyrest"), "Page title is: " + title());
        Assert.assertTrue(url().contains("/pillows"), "Page url is: " + url());
        //assertEquals(url(), baseUrl + "/pillows", "Page url is: " + url());

        PageHeader.openAccessoryByType("Covers");
        //Assert.assertTrue(title().equals("Covers | Beautyrest"), "Page title is: " + title());
        Assert.assertTrue(url().contains("/covers"), "Page url is: " + url());
        //assertEquals(url(), baseUrl + "/covers", "Page url is: " + url());

        PageHeader.openAccessoryByType("Pet Beds");
        //Assert.assertTrue(title().equals("Memory Foam Pet Beds | Beautyrest Pet Beds | Beautyrest"), "Page title is: " + title());
        Assert.assertTrue(url().contains("/pet-beds"), "Page url is: " + url());
        //assertEquals(url(), baseUrl + "/pet-beds", "Page url is: " + url());

        PageHeader.openPromotionsPage();
        //Assert.assertTrue(title().equals(PromotionsPage.pageTitle), "Page title is: " + title());
        //Assert.assertEquals(url(), baseUrl + PromotionsPage.pageURL, "Page url is: " + url()); todo

        PageHeader.openBlogPage();
        //Assert.assertTrue(title().equals(BlogPage.pageTitle), "Page title is: " + title());
        //Assert.assertEquals(url(), baseUrl + BlogPage.pageURL, "Page url is: " + url()); todo

        PageHeader.openStoreLocator();
        //Assert.assertTrue(title().equals(StoreLocatorPage.pageTitle), "Page title is: " + title());
        Assert.assertTrue(url().contains("/locator/"), "Page url is: " + url());
        //assertEquals(url(), baseUrl + "/locator/", "Page url is: " + url());
    }
}
