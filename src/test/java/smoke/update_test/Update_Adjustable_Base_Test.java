package smoke.update_test;

import annotations.TestName;
import entities.ItemEntity;
import entities.UserEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;
import static pages.ProductPage.SelectProductOption;

public class Update_Adjustable_Base_Test extends BaseTest {

    @Test
    @TestName(name = "Adjustable Base Update Test")
    public void Adjustable_Base() throws Exception{

        PageHeader header = PageHeader.Instance;
        ProductPage product = ProductPage.Instance;
        CartPage cart = CartPage.Instance;

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/adjustable_base.json"));
        ItemEntity newitem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/adjustable_base_upd.json"));

        open(baseUrl);

        closeWelcomeMessage();
        header.openAdjustableBase();
        AdjustableBasePlp.OpenProductPage("SMARTMOTION");

        product.SelectSize(item.getSize());
        product.SelectProductOption("1.0");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        cart.clickOnEditProduct(item.getTitle());

        product.SelectSize(newitem.getSize());
        newitem.setTitle(item.getTitle());
        newitem.setPrice(1498);
        product.clickUpdateProduct();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(newitem), "Failed to update product");
    }
}
