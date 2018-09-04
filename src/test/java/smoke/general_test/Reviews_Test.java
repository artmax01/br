package smoke.general_test;

import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MattressPlp;
import pages.PageHeader;
import utils.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;

public class Reviews_Test extends BaseTest{

    @Test
    @TestName (name = "Reviews test")
    public void reviews_short_test(){

        PageHeader header = PageHeader.Instance;
        MattressPlp mattressPlp = MattressPlp.Instance;

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Black");
        Assert.assertTrue(mattressPlp.chechFor5Reviews(), "Failed to locate product reviews");

        header.openMattressByType("Silver");
        Assert.assertTrue(mattressPlp.chechFor5Reviews(), "Failed to locate product reviews");

        header.openMattressByType("Platinum");
        Assert.assertTrue(mattressPlp.chechFor5Reviews(), "Failed to locate product reviews");

        header.openAccessoryByType("Sleeptracker");
        Assert.assertTrue(mattressPlp.chechFor5Reviews(), "Failed to locate product reviews");

    }

    @Test
    @TestName (name = "View all reviews test")

    public void view_all_reviews_test(){

        PageHeader header = PageHeader.Instance;
        MattressPlp mattressPlp = MattressPlp.Instance;

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Black");
        Assert.assertTrue(mattressPlp.clickOnSeeAllReviewsButton(), "Failed to locate product reviews");

        header.openMattressByType("Silver");
        Assert.assertTrue(mattressPlp.clickOnSeeAllReviewsButton(), "Failed to locate product reviews");

        header.openMattressByType("Platinum");
        Assert.assertTrue(mattressPlp.clickOnSeeAllReviewsButton(), "Failed to locate product reviews");

        header.openAccessoryByType("Sleeptracker");
        Assert.assertTrue(mattressPlp.clickOnSeeAllReviewsButton(), "Failed to locate product reviews");
    }
}
