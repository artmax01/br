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

public class Header_Navigation_Test extends BaseTest{

    @Test
    @TestName(name="Header Navigation Test")

    public static void HeaderNavigationTest(){

        open(baseUrl);
        PageHeader.openMattressesPlp();
        Assert.assertTrue(title().equals(MattressPlp.pageTitle), "Page title is: " + title());

        open(baseUrl);
        PageHeader.openMattressByType("Black");
        Assert.assertTrue(title().equals("Beautyrest Black | Luxury Mattress | Beautyrest"), "title is: " + title());
        Assert.assertTrue(url().contains("Black"), "url is: " + url());

        open(baseUrl);
        PageHeader.openMattressByType("Silver");
        Assert.assertTrue(title().equals("Beautyrest Silver| Better Support | Beautyrest"), "title is: " + title());
        Assert.assertTrue(url().contains("Silver"), "url is: " + url());

        open(baseUrl);
        PageHeader.openMattressByType("Platinum");
        Assert.assertTrue(title().equals("Beautyrest Platinum | Sleep Better | Beautyrest"), "title is: " + title());
        Assert.assertTrue(url().contains("Platinum"), "url is: " + url());

        open(baseUrl);
        PageHeader.openMattressInABox();
        Assert.assertTrue(title().equals(MattressInABox.pageTitle), "Page title is: " + title());
        Assert.assertTrue(url().equals(MattressInABox.pageURL), "Page url is: " + url());

        open(baseUrl);
        PageHeader.openAdjustableBase();
        Assert.assertTrue(title().equals(AdjustableBasePlp.pageTitle), "Page title is: " + title());
        Assert.assertTrue(url().equals(AdjustableBasePlp.pageURL), "Page url is: " + url());

        open(baseUrl);
        PageHeader.openAccessoryByType("Sleeptracker");
        Assert.assertTrue(title().equals("Beautyrest Sleeptracker | Sleep Monitor Technology | Beautyrest"), "Page title is: " + title());

        open(baseUrl);
        PageHeader.openAccessoryByType("Pillows");
        Assert.assertTrue(title().equals("Pillows | Beautyrest"), "Page title is: " + title());

        open(baseUrl);
        PageHeader.openAccessoryByType("Covers");
        Assert.assertTrue(title().equals("Covers | Beautyrest"), "Page title is: " + title());

        open(baseUrl);
        PageHeader.openAccessoryByType("Pet-Beds");
        Assert.assertTrue(title().equals("Memory Foam Pet Beds | Beautyrest Pet Beds | Beautyrest"), "Page title is: " + title());

        open(baseUrl);
        PageHeader.openPromotionsPage();
        Assert.assertTrue(title().equals(PromotionsPage.pageTitle), "Page title is: " + title());
        Assert.assertTrue(url().equals(PromotionsPage.pageURL), "Page url is: " + url());

        open(baseUrl);
        PageHeader.openBlogPage();
        Assert.assertTrue(title().equals(BlogPage.pageTitle), "Page title is: " + title());
        Assert.assertTrue(url().equals(BlogPage.pageURL), "Page url is: " + url());

        open(baseUrl);
        PageHeader.openStoreLocator();
        Assert.assertTrue(title().equals(StoreLocatorPage.pageTitle), "Page title is: " + title());
        Assert.assertTrue(url().equals(StoreLocatorPage.pageURL), "Page url is: " + url());
    }
}
