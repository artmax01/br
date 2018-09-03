package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage extends BasePage{

    private static ProductPage instance;
    public static ProductPage Instance = (instance != null) ? instance : new ProductPage();

    /** UI Mapping **/

    public static SelenideElement
    sizeByDefault = $(By.xpath("//div[@aria-checked='true' and @aria-describedby='option-label-bed_size-177']")),
    klarnaBlock = $(".klarna-placement");


    //* Page Methods **/

    public static void SelectSize(String size){
        reporter.info("Selecting product size: " + size);
        if ( !sizeByDefault.getText().toLowerCase().contains(size.toLowerCase()) ){
            $(By.xpath(".//div[@role='option' and text()='" + size + "']")).click();
        }
    }

    public static void SelectProductOption(String option){
        reporter.info("Selecting option: " + option);
        getElement(By.xpath(".//a[text()='" + option + "']")).click();
        waitForPageToLoad();
    }

    public static CartPage clickAddToCart() {
        reporter.info("Clicking on \"Add to cart\" button");
        waitForPageToLoad();
        getElement(By.cssSelector("#product-addtocart-button"))
                .click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ( $(".xs-modal__sold").isDisplayed()){
            reporter.info("closing popup");
            $x(".//a[contains(text(), 'Checkout Now ')]").click();
        }
        return CartPage.Instance;
    }

    public static CartPage clickUpdateProduct(){
        reporter.info("Clicking on \"Update Product\" button");
        waitForPageToLoad();
        getElement(By.cssSelector("#product-updatecart-button"))
                .click();
        return CartPage.Instance;
    }

    public static void verifyKlarnaPresence(){
        reporter.info("Search page for \"Klarna\" block");
        klarnaBlock.scrollIntoView(true)
                .shouldBe(Condition.visible);
                //.should(Condition.have(Condition.text(" As low as $25/mo. ")));
    }

    public static void verifyKlarnaAbsence(){
        reporter.info("Checking that \"Klarna\" block is not displayed");
        getElement(By.xpath(".//div[@class='klarna-placement']//iframe")).shouldNotBe(Condition.visible);
    }

}
