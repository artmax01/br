package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class ProductPage extends BasePage{

    private static ProductPage instance;
    public static ProductPage Instance = (instance != null) ? instance : new ProductPage();

    public static void SelectSize(String size){
        reporter.info("Selecting product size: " + size);
        Selenide.getElement(By.xpath(".//div[@role='option' and text()='" + size + "']")).click();
    }

    public static void SelectProductOption(String option){
        reporter.info("Selecting option: " + option);
        Selenide.getElement(By.xpath(".//a[text()='" + option + "']")).click();
    }

    public static CartPage clickAddToCart(){
        reporter.info("Clicking on \"Add to cart\" button");
        Selenide.getElement(By.cssSelector("#product-addtocart-button")).click();
        return CartPage.Instance;
    }






    public class Black{

        public Black() { pageURL = "/black" ;}
    }


}
