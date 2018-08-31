package smoke.general_test;

import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageHeader;
import pages.StoreLocatorPage;
import utils.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;

public class Store_Locator_Test extends BaseTest{

    @Test
    @TestName (name = "Store locator test")

    public void storeLocatorTest(){

        PageHeader header = PageHeader.Instance;
        StoreLocatorPage locator = StoreLocatorPage.Instance;

        open(baseUrl);
        closeWelcomeMessage();

        header.openStoreLocator();
        locator.searchForStore();
        Assert.assertTrue(locator.checkSearchResults(), "Failed to locate search results");
        Assert.assertTrue(locator.checkSearchResultsElements(), "Failed to locate search result elements");

    }
}
