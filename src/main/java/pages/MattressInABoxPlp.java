package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.getElements;

public class MattressInABoxPlp extends BasePage{

    private static MattressInABoxPlp instance;
    public static MattressInABoxPlp Instance = (instance != null) ? instance : new MattressInABoxPlp();

    public MattressInABoxPlp(){
        pageURL = "https://www.beautyrest.com/Mattress-In-A-Box";
        pageTitle = "Mattress In A Box | Beautyrest";
    }


    public static boolean VerifyAllMattressInAboxProducts(){
        reporter.info("Checking that all \"Mattress-in-a-box\" products are displayed");
        ElementsCollection products =  getElements(By.cssSelector(".product-item.col-lg-4"));
        if (products.size() == 3 && products.findBy(cssClass("product-item-name")).getText().contains("BeautyRest Mattress-In-A-Box")){
            return true;
        }
        return false;
    }


}

