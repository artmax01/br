package smoke.delete_test;

import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.PageHeader;
import pages.ProductPage;
import utils.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;

public class Delete_Mattress_From_Cart_Test extends BaseTest {

    @DataProvider(name = "default_item_provider")
    public Object[][] provider () {
        return new Object[][]{
                {"Black", "CALISTA", "Beautyrest Black Calista Soft Mattress", "Full", "Soft"},
                {"Black", "KATARINA", "Beautyrest Black Katarina Medium Pillow Top Mattress", "Queen", "Medium Pillow Top"},
                {"Platinum", "ATLAS COVE", "Beautyrest Platinum Hybrid Atlas Cove Firm Mattress", "Queen", "Firm"},
                {"Platinum", "CRESTRIDGE", "Beautyrest Platinum Hybrid Crestridge Soft Mattress", "Full", "Soft"},
                {"Platinum", "SPRING GROVE", "Beautyrest Platinum Spring Grove Firm Mattress", "King", "Firm"},
                {"Silver", "AUSTIN REEF", "Beautyrest Silver Hybrid Austin Reef Soft Mattress", "Queen", "Soft"},
                {"Silver", "BEACHWOOD", "Beautyrest Silver Hybrid Beachwood Medium Mattress", "Twin", "Medium"},
                {"Silver", "OPEN SEAS", "Beautyrest Silver Open Seas Medium Pillow Top Mattress", "Twin", "Medium Pillow Top"}
        };
    }

    @Test(dataProvider = "default_item_provider")
    @TestName(name = "Delete Mattress from cart")

    public void DeleteMattressFromCartTest(String line, String model, String name, String size, String option){

        PageHeader header = PageHeader.Instance;
        ProductPage product = ProductPage.Instance;
        CartPage cart = CartPage.Instance;

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType(line)
                .OpenProductPage(model);
        product.SelectSize(size);
        product.SelectProductOption(option);

        product.clickAddToCart();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(name), "Item was not displayed in cart");

        cart.clickOnDeleteProduct(name);

        Assert.assertFalse(cart.itemDisplayedOnViewCartPage(name), "Item was displayed in cart");

    }
}
