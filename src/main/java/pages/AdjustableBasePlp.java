package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.getElement;

public class AdjustableBasePlp extends BasePage{

    private static AdjustableBasePlp instance;
    public static AdjustableBasePlp Instance = (instance != null) ? instance : new AdjustableBasePlp();

    public AdjustableBasePlp(){
        pageURL = "https://www.beautyrest.com/Smartmotion";
        pageTitle = "SmartMotion™ Bases | Optimized Sleep | Beautyrest";
    }

    public static ProductPage OpenProductPage(String productLine){
        reporter.info("Opening product page: " + productLine);
        //getElement(By.xpath(".//span[@class='br-model-name' and contains(text(), '" + item.getName() + "')]/../.."))
        getElement(By.xpath(".//div[contains(@class, 'product-item-info') and .//span[contains(text(), '" + productLine +"')]]"))
                //getElement(By.xpath(".//div[@class='product-item-info'] and .//span[contains(text(), '" + pr + "')]"))
                .scrollIntoView(true)
                .click();
        return ProductPage.Instance;
    }
}
