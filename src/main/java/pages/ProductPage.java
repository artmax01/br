package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.getElement;

public class ProductPage extends BasePage{

    private static ProductPage instance;
    public static ProductPage Instance = (instance != null) ? instance : new ProductPage();

    public static void SelectSize(String size){
        reporter.info("Selecting product size: " + size);
        getElement(By.xpath(".//div[@role='option' and text()='" + size + "']")).click();
    }

    public static void SelectProductOption(String option){
        reporter.info("Selecting option: " + option);
        getElement(By.xpath(".//a[text()='" + option + "']")).click();

    }

    public static CartPage clickAddToCart(){
        reporter.info("Clicking on \"Add to cart\" button");
        waitForPageToLoad();
        getElement(By.cssSelector("#product-addtocart-button"))
                .click();
        return CartPage.Instance;
    }

}
