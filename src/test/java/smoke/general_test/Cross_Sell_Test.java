package smoke.general_test;

import annotations.TestName;
import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.PageFooter;
import pages.PageHeader;
import pages.ProductPage;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;
import static pages.BasePage.waitForPageToLoad;

public class Cross_Sell_Test extends BaseTest {

    PageHeader header = PageHeader.Instance;
    ProductPage product = ProductPage.Instance;
    CartPage cart = CartPage.Instance;

    ElementsCollection
            sizeButtonsCollection = $$x("//*[@role='option']"),
            secondOptionButtonsCollection = $$x("//*[@class='swatch-option text'] and //*[@class='swatch-option text selected']");

    @Test
    @TestName (name = "Cross Sell Price and Size Test")
    public void Cross_Sell_SizePrice_Test(){

        String pdpMattressSize, xsMattressSize, xsBoxSpringsSize, xsSmartMotionSize, pdpMattressPrice;

        open(baseUrl);
        closeWelcomeMessage();
        header.openMattressesPlp()
                .OpenProductPage("CALISTA");
        for (int x=1; x<4; x++){
            sizeButtonsCollection.get(x).click();
            pdpMattressSize = sizeButtonsCollection.get(x).getText();
            pdpMattressPrice = product.productPriceText.getText();
            waitForPageToLoad();
            product.clickAddToCartDontClosePopup();
            waitForPageToLoad();
            Assert.assertTrue(product.crossSellModal.isDisplayed(), "Cross Sell modal is not displayed");
            Assert.assertTrue(pdpMattressSize.equalsIgnoreCase(product.xsProductSizeText.getText()), "Incorrect mattress size. On PDP: "+pdpMattressSize+", on XS: "+product.xsProductSizeText.getText());
            Assert.assertTrue(pdpMattressPrice.equalsIgnoreCase(product.xsProductPriceText.getText()), "Incorrect mattress price. On PDP: "+pdpMattressPrice+", on XS: "+product.xsProductPriceText.getText());
            Assert.assertTrue(pdpMattressSize.equalsIgnoreCase(product.xsBoxSpringSizeText.getText()), "Incorrect size of proposed Box Springs. On PDP: "+pdpMattressSize+", on XS: "+product.xsBoxSpringSizeText.getText());
            if (!pdpMattressSize.equals("FULL")) {
                Assert.assertTrue(pdpMattressSize.equalsIgnoreCase(product.xsSmartMotionSizeText.getText()), "Incorrect size of proposed Smart Motion. On PDP: "+pdpMattressSize+", on XS: "+product.xsSmartMotionSizeText.getText());
            }
            product.clickXsClose();
        }

    }
}
