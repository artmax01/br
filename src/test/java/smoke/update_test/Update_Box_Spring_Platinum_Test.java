package smoke.update_test;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdjustableBasePlp;
import pages.CartPage;
import pages.PageHeader;
import pages.ProductPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;

public class Update_Box_Spring_Platinum_Test extends BaseTest {

    @Test
    @TestName(name = "Box Spring Platinum Update Test")
    public void Box_Spring_Black() throws Exception{

        PageHeader header = PageHeader.Instance;
        ProductPage product = ProductPage.Instance;
        CartPage cart = CartPage.Instance;

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/box_spring_platinum.json"));
        ItemEntity newitem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/box_spring_platinum_upd.json"));

        open(baseUrl);
        closeWelcomeMessage();
        header.openBoxSpring();
        AdjustableBasePlp.OpenProductPage("PLATINUM");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Low Profile");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        cart.clickOnEditProduct(item.getTitle());
        product.SelectSize(newitem.getSize());
        newitem.setTitle(item.getTitle());
        product.clickUpdateProduct();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(newitem), "Failed to update product");
    }

}
