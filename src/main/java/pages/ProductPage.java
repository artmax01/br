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
    selectedSize = $x("//*[@class='swatch-opt']/div[1]//div[@class='swatch-option text selected']"),
    selectedSecondOption = $x("//*[@class='swatch-opt']/div[2]//div[@class='swatch-option text selected']"),
    klarnaBlock = $(".klarna-placement"),
    productPriceText = $x("//*[@class='product-info-price']/div/span/span/span"),

    crossSellModal = $(".xs-modal__sold"),
    xsCloseButton = $$x(".//*[@class='action-close']").get(1),
    xsProductNameText = $(".__title m-0"),
    xsProductSizeText = $x("//*[@class='xs-modal__sold']/div/div/div/div/p[2]"),
    xsProductPriceText = $x("//*[@class='xs-modal__sold']/div/div/div/p/span/span/span"),
    xsViewCartButton = $x(".//a[contains(text(), ' View Cart ')]"),
    xsAddBoxSpringsToCartButton = $x("//*[@id='modal-content-38']/div/div/div/div[2]/div[1]/div[2]/button"),
    xsAddSmartMotionToCartButton = $x("//*[@id='modal-content-38']/div/div/div/div[2]/div[2]/div[2]/button"),
    xsBoxSpringSizeText = $$x(".//*[@class='__option text-muted font-small mb-0']").get(0),
    xsSmartMotionSizeText = $$x(".//*[@class='__option text-muted font-small mb-0']").get(1);

    /** Page Methods **/

    public static void SelectSize(String size){
        reporter.info("Selecting product size: " + size);
        waitForPageToLoad();
        waitForElement(By.xpath("//div[@aria-checked='true' and @aria-describedby='option-label-bed_size-177']"));
        if (!sizeByDefault.isDisplayed()){driver().navigate().refresh();}

        if ( !sizeByDefault.getText().toLowerCase().contains(size.toLowerCase()) ){
            $(By.xpath(".//div[@role='option' and text()='" + size + "']")).click();
        }
    }

    public static void SelectProductOption(String option){
        reporter.info("Selecting option: " + option);
//<<<<<<< Updated upstream
        if(!selectedSecondOption.getText().equalsIgnoreCase(option))
        {getElement(By.xpath(".//div[text()='" + option + "']")).click();
        waitForPageToLoad();}
//=======
//        getElement(By.xpath(".//div[@role='option' and text()='" + option + "']")).click(); //(".//a[text()='" + option + "']")).click();
//       waitForPageToLoad();
//>>>>>>> Stashed changes
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
        if (crossSellModal.isDisplayed()){
            reporter.info("closing popup");
            xsViewCartButton.click();
        }
        return CartPage.Instance;
    }

    public static CartPage clickAddToCartDontClosePopup() {
        reporter.info("Clicking on \"Add to cart\" button");
        waitForPageToLoad();
        getElement(By.cssSelector("#product-addtocart-button"))
                .click();
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

    public static void clickXsClose(){
        reporter.info("Closing Cross Sell Popup");
        xsCloseButton.click();
    }

}
