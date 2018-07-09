package pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
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
            typeStepAll = mattressTypeSlider.$x(".//em[contains(text(), 'All')]"),
            typeStepPocketedCoil = $(By.xpath(".//div[@class='Step']//span[contains(text(), 'Pocketed Coil')]/..")),
            typeStepHybrid = $(By.xpath(".//div[@class='Step']//span[contains(text(), 'Hybrid')]/..")),

            mattressPriceSlider = $("#PriceSlider"),
            priceStepAll = mattressPriceSlider.$("div:nth-child(1)"),
            priceStep_799_or_less = $("#PriceSlider > div:nth-child(2)"),
            priceStep_800_999 = mattressPriceSlider.$("div:nth-child(3)"),
            priceStep_1000_1999 = mattressPriceSlider.$("div:nth-child(4)"),
            priceStep_2000_2999 = mattressPriceSlider.$("div:nth-child(5)"),
            priceStep_3000_or_more = mattressPriceSlider.$("div:nth-child(6)"),

            productsList = $(".product-item-info");

    public static void SwitchToAllPrices(){
        reporter.info("Moving mattress price slider to \"All\"");
        mattressPriceSlider.dragAndDropTo(priceStepAll);
        getElements(By.cssSelector(".product-item.col-lg-4"))
                .shouldHave((CollectionCondition) size(38));
    }


    public static void MovePriceSliderTo$799_or_less(){
        reporter.info("Moving mattress price slider to \"$799 or Less\"");
        mattressPriceSlider.dragAndDropTo(priceStep_799_or_less);
    }
    public static boolean CheckPrice$799_or_less(){
        reporter.info("Checking that products cost is less than $799");
        ElementsCollection products = getElements(By.cssSelector(".product-item.col-lg-4"))
                .exclude(attribute("style", "display: none;"));
        for (SelenideElement product : products){
            if (Integer.valueOf(product.$(".plp-price").getText().replace("$", "")) <= 799){
                return true;
            }
        }
        return false;
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
