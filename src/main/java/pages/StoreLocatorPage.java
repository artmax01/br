package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.getElement;

public class StoreLocatorPage extends BasePage{

    private static StoreLocatorPage instance;
    public static StoreLocatorPage Instance = (instance != null) ? instance : new StoreLocatorPage();

    public StoreLocatorPage(){
        pageURL = "/locator/";
        pageTitle = "Find a Mattress Store Near You | Beautyrest";
    }

    /** UI Mapping **/
    public static SelenideElement
    citySearchBox = $("#FindStoreCity"),
    searchButton = $("#find-store-submit"),

    map = $(".googlemap"),
    searchResults = $(".show-tag-li.store-item");

    /** Page Methods **/

    public void searchForStore(){
        reporter.info("Submitting serach request");
        citySearchBox.sendKeys("New York");
        searchButton.click();
    }

    public boolean checkSearchResults(){
        waitForPageToLoad();
        reporter.info("Checking search page for displayed results");
        if (map.isDisplayed() && searchResults.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean checkSearchResultsElements(){
        waitForPageToLoad();
        reporter.info("Checking that search results have required elements");
        ElementsCollection results = $$(".show-tag-li.store-item");

        $(".store_rank-img").shouldBe(Condition.visible);
        $(".store-web").shouldBe(Condition.visible);

        for (SelenideElement element : results){
            if (element.findElement(By.cssSelector(".store-title")).isDisplayed()
                && element.findElement(By.cssSelector(".store-info-data")).isDisplayed()
                && element.findElement(By.cssSelector(".store-info-action-wrapper")).isDisplayed()
                && element.findElement(By.cssSelector(".store-num")).isDisplayed()){
                return true;
            }
        }
        return false;
    }
}
