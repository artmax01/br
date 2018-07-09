package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getElements;

public class MattressPlp extends BasePage{

    private static MattressPlp instance;
    public static MattressPlp Instance = (instance != null) ? instance : new MattressPlp();

    public MattressPlp(){
    pageURL = "/mattresses";
    pageTitle = "Beautyrest Mattresses | Get Quality Sleep | Beautyrest";}


    /* UI elements */
    public static SelenideElement
            blackMattresses = $(By.xpath(".//a[@class='btn btn-black' and contains(text(), 'Black')]")),
            platinumMattress = $(By.xpath(".//a[@class='btn btn-black' and contains(text(), 'Platinum')]")),
            silverMattress = $(By.xpath(".//a[@class='btn btn-black' and contains(text(), 'Silver')]")),

            mattressTypeSlider = $(By.xpath(".//div[@id='TypeSlider']//div[@class='noUi-handle noUi-handle-lower']")),
            typeStepAll = $(By.xpath(".//em[contains(text(), 'All')]")),
            typeStepPocketedCoil = $(By.xpath(".//div[@class='Step']//span[contains(text(), 'Pocketed Coil')]/..")),
            typeStepHybrid = $(By.xpath(".//div[@class='Step']//span[contains(text(), 'Hybrid')]/..")),

            mattressPriceSlider = $("#PriceSlider"),
            priceStepAll = mattressPriceSlider.$x(".//em[contains(text(), 'All')]"),
            priceStep_799_or_less = mattressPriceSlider.$x(".//div[@class='Step']//span[contains(text(), '799')]/.."),
            priceStep_800_999 = mattressPriceSlider.$x(".//div[@class='Step']//span[contains(text(), '800')]/.."),
            priceStep_1000_1999 = mattressPriceSlider.$x(".//div[@class='Step']//span[contains(text(), '1000')]/.."),
            priceStep_2000_2999 = mattressPriceSlider.$x(".//div[@class='Step']//span[contains(text(), '2000')]/.."),
            priceStep_3000_or_more = mattressPriceSlider.$x(".//div[@class='Step']//span[contains(text(), '3000')]").parent(),

            productsList = $(".product-item-info");

    public static boolean verifyProductTypeFilter(){
        int count = 0;

        //Move slider to Pocketed Coil
        SwitchToPocketedType();

        //Move slider to Hybrid
        SwitchToHybridType();

        //Move slider to All
        SwitchToAllTypes();
        return true;
    }

    public static void SwitchToAllTypes(){
        reporter.info("Moving mattress type slider to \"All\"");
        mattressTypeSlider.dragAndDropTo(typeStepAll).shouldHave(Condition.attribute("aria-valuenow", "0.0"));
        //Get list of products
        getElements(By.cssSelector(".product-item.col-lg-4"))
            .exclude(Condition.attribute("style", "display: none;"))
            //Verify that all products are displayed
            .shouldHave((CollectionCondition) size(38));
    }

    public static void SwitchToPocketedType(){
        reporter.info("Moving mattress type slider to \"Pocketed Coil\"");
        mattressTypeSlider.shouldHave(Condition.attribute("aria-valuenow", "0.0"))
                .dragAndDropTo(typeStepPocketedCoil).shouldHave(Condition.attribute("aria-valuenow", "50.0"));
        //Get list of products
        ElementsCollection products = getElements(By.cssSelector(".product-item.col-lg-4"))
                .exclude(Condition.attribute("style", "display: none;"));

        //Verify that only selected products are displayed
        reporter.info("Checking that Hybrid mattresses are not displayed");
        for (SelenideElement product : products) {
            product.scrollIntoView(true);
            product.find("span.br-model-name").shouldNot(have(text("Hybrid")).because("Hybrid mattresses should NOT be displayed")); }
    }

    public static void SwitchToHybridType(){
        reporter.info("Moving mattress type slider to \"Hybrid\"");
        mattressTypeSlider.dragAndDropTo(typeStepHybrid).shouldHave(Condition.attribute("aria-valuenow", "100.0"));
        //Get list of products
        ElementsCollection products = getElements(By.cssSelector(".product-item.col-lg-4"))
                .exclude(Condition.attribute("style", "display: none;"));
        //Verify that only selected products are displayed
        products.shouldHave(size(78));
        reporter.info("Checking that only Hybrid mattresses are displayed");
        for (SelenideElement product : products) {
            product.scrollIntoView(true);
            product.find("span.br-model-name").should(have(text("Hybrid")));
        }
    }
}
