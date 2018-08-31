package smoke.delete_test;

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
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static pages.ProductPage.*;

public class Delete_Adjustable_Bases_From_Cart_Test extends BaseTest {

    @Test
    @TestName(name = "Delete adjustable bases from cart")
    public void countOfAdjustableBasesInCart_Test() throws Exception {

        PageHeader header = PageHeader.Instance;
        ProductPage product = ProductPage.Instance;
        CartPage cart = CartPage.Instance;

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/adjustable_base.json"));

        open(baseUrl);
        closeWelcomeMessage();
        header.openAdjustableBase();
        AdjustableBasePlp.OpenProductPage("SMARTMOTION");

        product.SelectSize(item.getSize());
        product.SelectProductOption("1.0");
        product.clickAddToCart();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not found on cart page");

        cart.clickOnDeleteProduct(item.getTitle());

        Assert.assertFalse(cart.itemDisplayedOnViewCartPage(item), "Item was found on cart page");

        close();
    }
}
