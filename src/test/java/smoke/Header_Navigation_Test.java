package smoke;

import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static pages.BasePage.closeWelcomeMessage;

public class Header_Navigation_Test extends BaseTest{

    @Test
    @TestName(name="Header Navigation Test")

    public static void HeaderNavigationTest(){

        open(baseUrl);
        closeWelcomeMessage();

        PageHeader.openMattressesPlp();
        Assert.assertTrue(title().equals(MattressPlp.pageTitle), "Page title is: " + title());

        PageHeader.openMattressByType("Black");
        Assert.assertTrue(title().equals("Black"), "title is: " + title());
        Assert.assertTrue(url().contains("black"), "url is: " + url());

        PageHeader.openMattressByType("Silver");
        Assert.assertTrue(title().equals("Silver"), "title is: " + title());
        Assert.assertTrue(url().contains("silver"), "url is: " + url());

        PageHeader.openMattressByType("Platinum");
        Assert.assertTrue(title().equals("Platinum"), "title is: " + title());
        Assert.assertTrue(url().contains("platinum"), "url is: " + url());

        PageHeader.openMattressInABox();
        Assert.assertTrue(title().equals(MattressInABoxPlp.pageTitle), "Page title is: " + title());
        Assert.assertTrue(url().equals(baseUrl + MattressInABoxPlp.pageURL), "Page url is: " + url());

        PageHeader.openAdjustableBase();
        Assert.assertTrue(title().equals(AdjustableBasePlp.pageTitle), "Page title is: " + title());
        Assert.assertTrue(url().equals(baseUrl + AdjustableBasePlp.pageURL), "Page url is: " + url());

        PageHeader.openAccessoryByType("Sleeptracker");
        Assert.assertTrue(title().equals("Beautyrest Sleeptracker | Sleep Monitor Technology | Beautyrest"), "Page title is: " + title());

        PageHeader.openAccessoryByType("Pillows");
        Assert.assertTrue(title().equals("Pillows | Beautyrest"), "Page title is: " + title());

        PageHeader.openAccessoryByType("Covers");
        Assert.assertTrue(title().equals("Covers | Beautyrest"), "Page title is: " + title());

        PageHeader.openAccessoryByType("Pet-Beds");
        Assert.assertTrue(title().equals("Memory Foam Pet Beds | Beautyrest Pet Beds | Beautyrest"), "Page title is: " + title());

        PageHeader.openPromotionsPage();
        Assert.assertTrue(title().equals(PromotionsPage.pageTitle), "Page title is: " + title());
        Assert.assertTrue(url().equals(baseUrl + PromotionsPage.pageURL), "Page url is: " + url());

        PageHeader.openBlogPage();
        Assert.assertTrue(title().equals(BlogPage.pageTitle), "Page title is: " + title());
        Assert.assertTrue(url().equals(baseUrl + BlogPage.pageURL), "Page url is: " + url());

        PageHeader.openStoreLocator();
        Assert.assertTrue(title().equals(StoreLocatorPage.pageTitle), "Page title is: " + title());
        Assert.assertTrue(url().equals(baseUrl + StoreLocatorPage.pageURL), "Page url is: " + url());
    }
}
