package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getElement;

public class FaqPage extends BasePage {

    private static FaqPage instance;
    public static FaqPage Instance = (instance != null) ? instance : new FaqPage();

    /** UI Mapping **/

    public static SelenideElement
    searchBox = $("input#search"),
    searchResult = $(".faq_wrapper"),
    ourMattresses = $(By.xpath(".//li[@data-target='#collapse-0']")),
    returnsAndWarranty = $(By.xpath(".//li[@data-target='#collapse-1']")),
    purchasing = $(By.xpath(".//li[@data-target='#collapse-2']")),
    shippingAndDelivery = $(By.xpath(".//li[@data-target='#collapse-3']"));


    /** Page Methods **/

    public static void verifySearchBox(){
        reporter.info("Submitting \"mattress\" search request");
        searchBox.scrollIntoView(true).
                sendKeys("mattress");
        searchBox.submit();
        searchResult.scrollIntoView(true).
                shouldBe(Condition.visible).should(Condition.have(Condition.text("What is a hybrid mattress?")));
    }

    public static void verifyOurMattressAccordion(){
        reporter.info("Expanding Our Mattresses");
        ourMattresses.scrollIntoView(true)
                .click();
        waitForPageToLoad();
        getElement(By.xpath(".//div[contains(text(), 'Why should I purchase Beautyrest over another brand?')]")).shouldBe(Condition.visible);
        ourMattresses.scrollIntoView(true)
                .click();
        waitForPageToLoad();
        getElement(By.xpath(".//div[contains(text(), 'Why should I purchase Beautyrest over another brand?')]")).shouldNotBe(Condition.visible);
        reporter.info("Collapsing Our Mattresses");
    }

    public static void verifyReturnsAndWarrantyAccordion(){
        reporter.info("Expanding Returns & Warranty");
        returnsAndWarranty.scrollIntoView(true)
                .click();
        waitForPageToLoad();
        getElement(By.xpath(".//div[contains(text(), 'What is your return policy?')]")).shouldBe(Condition.visible);
        returnsAndWarranty.scrollIntoView(true)
                .click();
        waitForPageToLoad();
        getElement(By.xpath(".//div[contains(text(), 'What is your return policy?')]")).shouldNotBe(Condition.visible);
        reporter.info("Collapsing Returns & Warranty");
    }

    public static void verifyPurchasingAccordion(){
        reporter.info("Expanding Purchasing");
        purchasing.scrollIntoView(true)
                .click();
        waitForPageToLoad();
        getElement(By.xpath(".//div[contains(text(), 'Are there any restriction on your promotions?')]")).shouldBe(Condition.visible);
        purchasing.scrollIntoView(true)
                .click();
        waitForPageToLoad();
        getElement(By.xpath(".//div[contains(text(), 'Are there any restriction on your promotions?')]")).shouldNotBe(Condition.visible);
        reporter.info("Collapsing Purchasing");
    }

    public static void verifyShippingAndDeliveryAccordion(){
        reporter.info("Expanding Shipping & Delivery");
        shippingAndDelivery.scrollIntoView(true)
                .click();
        waitForPageToLoad();
        getElement(By.xpath(".//div[contains(text(), 'How much does shipping cost?')]")).shouldBe(Condition.visible);
        shippingAndDelivery.scrollIntoView(true)
                .click();
        waitForPageToLoad();
        getElement(By.xpath(".//div[contains(text(), 'How much does shipping cost?')]")).shouldNotBe(Condition.visible);
        reporter.info("Collapsing Shipping & Delivery");
    }
}
