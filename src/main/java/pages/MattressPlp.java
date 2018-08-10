package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class MattressPlp extends BasePage{

    private static MattressPlp instance;
    public static MattressPlp Instance = (instance != null) ? instance : new MattressPlp();

    public MattressPlp(){
    pageURL = "/mattresses";
    pageTitle = "BR Mattresses";}


    /* UI elements */
    public static SelenideElement
            blackMattresses = $(By.xpath(".//a[@class='btn btn-black' and contains(text(), 'Black')]")),
            platinumMattress = $(By.xpath(".//a[@class='btn btn-black' and contains(text(), 'Platinum')]")),
            silverMattress = $(By.xpath(".//a[@class='btn btn-black' and contains(text(), 'Silver')]")),

    mattressTypeSlider = $(By.xpath(".//div[@id='TypeSlider']//div[@class='noUi-handle noUi-handle-lower']")),
            typeStepAll = $(By.xpath(".//em[contains(text(), 'All')]")),
            typeStepPocketedCoil = $(By.xpath(".//div[@class='Step']//span[contains(text(), 'Pocketed Coil')]/..")),
            typeStepHybrid = $(By.xpath(".//div[@class='Step']//span[contains(text(), 'Hybrid')]/..")),

    mattressPriceSlider = $("#PriceSlider .noUi-handle.noUi-handle-lower"),
            priceStepAll = $x(".//div[@id='PriceSlider']//em/.."),
            priceStep_799_or_less = $x(".//div[@class='Step']/span[contains(text(), '$799')]/.."),
            priceStep_800_999 = $x(".//div[@class='Step']/span[contains(text(), '$800')]/.."),
            priceStep_1000_1999 = $x(".//div[@class='Step']/span[contains(text(), '$100')]/.."),
            priceStep_2000_2999 = $x(".//div[@class='Step']/span[contains(text(), '$2000')]/.."),
            priceStep_3000_or_more = $x(".//div[@class='Step']/span[contains(text(), '$3000')]/.."),

    product = $(".product-item-name");


    //* Page methods *//
    public ProductPage OpenProductPage(String productLine){
        reporter.info("Opening product page: " + productLine);
        //getElement(By.xpath(".//span[@class='br-model-name' and contains(text(), '" + item.getName() + "')]/../.."))
        getElement(By.xpath(".//div[contains(@class, 'product-item-info') and .//span[contains(text(), '" + productLine +"')]]"))
                //getElement(By.xpath(".//div[@class='product-item-info'] and .//span[contains(text(), '" + pr + "')]"))
                .scrollIntoView(true)
                .click();
        return ProductPage.Instance;
    }

    public static void SwitchToAllPrices(){
        reporter.info("Moving mattress price slider to \"All\"");
        mattressPriceSlider.dragAndDropTo(priceStepAll);
    }

    public static boolean AllPricesAreDisplayed(){
        reporter.info("Checking that all mattresses are displayed");
        if (getElements(By.cssSelector(".product-item.col-lg-4"))
                .size() == 38){
            return true;
        }
        return false;
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
            product.scrollIntoView(true);
            if (Integer.valueOf(product.$(".plp-price").getText().replace("$", "").replace(",", "")) <= 799){
                return true;
            }
        }
        return false;
    }

    public static void MovePriceSliderTo$800_999(){
       reporter.info("Moving mattress price slider to \"$800 - $999\"");
       mattressPriceSlider.dragAndDropTo(priceStep_800_999);
    }

    public static boolean CheckPricesAre_$800_999(){
        reporter.info("Checking that products cost is \"$800 - $999\"");
        ElementsCollection products = getElements(By.cssSelector(".product-item.col-lg-4"))
                .exclude(attribute("style", "display: none;"));
        for (SelenideElement product : products){
            product.scrollIntoView(true);
            int price = Integer.valueOf(product.$(".plp-price").getText().replace("$", "").replace(",", ""));
            if (price >= 800 & price <= 999){
                return true;
            }
        }
        return false;
    }

    public static void MovePriceSliderTo$1000_1999(){
        reporter.info("Moving mattress price slider to \"$1000 - $1999\"");
        mattressPriceSlider.dragAndDropTo(priceStep_1000_1999);
    }

    public static boolean CheckPricesAre_$1000_1999(){
        reporter.info("Checking that products cost is \"$1000 - $1999\"");
        ElementsCollection products = getElements(By.cssSelector(".product-item.col-lg-4"))
                .exclude(attribute("style", "display: none;"));
        for (SelenideElement product : products){
            product.scrollIntoView(true);
            int price = Integer.valueOf(product.$(".plp-price").getText().replace("$", "").replace(",", ""));
            if (price >= 1000 & price <= 1999){
                return true;
            }
        }
        return false;
    }

    public static void MovePriceSliderTo$2000_2999(){
        reporter.info("Moving mattress price slider to \"$2000 - $2999\"");
        mattressPriceSlider.dragAndDropTo(priceStep_2000_2999);
    }

    public static boolean CheckPricesAre_$2000_2999(){
        reporter.info("Checking that products cost is \"$2000 - $2999\"");
        ElementsCollection products = getElements(By.cssSelector(".product-item.col-lg-4"))
                .exclude(attribute("style", "display: none;"));
        for (SelenideElement product : products){
            product.scrollIntoView(true);
            int price = Integer.valueOf(product.$(".plp-price").getText().replace("$", "").replace(",", ""));
            if (price >= 2000 & price <= 2999){
                return true;
            }
        }
        return false;
    }

    public static void MovePriceSliderTo$3000_or_more(){
        reporter.info("Moving mattress price slider to \"$3000 or More\"");
        mattressPriceSlider.dragAndDropTo(priceStep_3000_or_more);
    }

    public static boolean CheckPricesAre_$3000_or_more(){
        reporter.info("Checking that products cost is \"$3000 or More\"");
        ElementsCollection products = getElements(By.cssSelector(".product-item.col-lg-4"))
                .exclude(attribute("style", "display: none;"));
        for (SelenideElement product : products){
            product.scrollIntoView(true);
            int price = Integer.valueOf(product.$(".plp-price").getText().replace("$", "").replace(",", ""));
            if (price >= 3000){
                return true;
            }
        }
        return false;
    }

    public static void SwitchToAllTypes(){
        reporter.info("Moving mattress type slider to \"All\"");
        mattressTypeSlider.dragAndDropTo(typeStepAll).shouldHave(Condition.attribute("aria-valuenow", "0.0"));
    }

    public static boolean AllTypesAreDisplayed(){
        reporter.info("Checking that all mattressess are displayed");
        if (getElements(By.cssSelector(".product-item.col-lg-4"))
                .exclude(Condition.attribute("style", "display: none;"))
                //Verify that all products are displayed
                .size() == 38){
            return true;
        }
        return false;
    }

    public static void SwitchToPocketedType(){
        reporter.info("Moving mattress type slider to \"Pocketed Coil\"");
        mattressTypeSlider.shouldHave(Condition.attribute("aria-valuenow", "0.0"))
                .dragAndDropTo(typeStepPocketedCoil).shouldHave(Condition.attribute("aria-valuenow", "50.0"));
    }

    public static boolean OnlyPocketedAreDisplayed(){
        ElementsCollection products = getElements(By.cssSelector(".product-item.col-lg-4"))
                .exclude(Condition.attribute("style", "display: none;"));

        //Verify that only selected products are displayed
        reporter.info("Checking that Hybrid mattresses are not displayed");
        for (SelenideElement product : products) {
            product.scrollIntoView(true);
            if (product.find("span.br-model-name").getText().contains("Hybrid"))
                return false;
        }
        return true;
    }

    public static void SwitchToHybridType(){
        reporter.info("Moving mattress type slider to \"Hybrid\"");
        mattressTypeSlider.dragAndDropTo(typeStepHybrid).shouldHave(Condition.attribute("aria-valuenow", "100.0"));
    }

    public static boolean OnlyHybridAreDisplayed(){
        ElementsCollection products = getElements(By.cssSelector(".product-item.col-lg-4"))
                .exclude(Condition.attribute("style", "display: none;"));
        //Verify that only selected products are displayed
        //products.shouldHave(size()); // TODO: 7/11/18
        reporter.info("Checking that only Hybrid mattresses are displayed");
        for (SelenideElement product : products) {
            product.scrollIntoView(true);
            if (!product.find("span.br-model-name").getText().contains("Hybrid")){
                return true;
            }
        }
        return false;
    }

}
