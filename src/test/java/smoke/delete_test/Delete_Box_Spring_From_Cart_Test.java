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
import static pages.BasePage.closeWelcomeMessage;

public class Delete_Box_Spring_From_Cart_Test extends BaseTest {

    PageHeader header = PageHeader.Instance;
    ProductPage product = ProductPage.Instance;
    CartPage cart = CartPage.Instance;

    @Test
    @TestName(name = "Delete Black Box Spring from cart")

    public void deleteBlackBoxSpringFromCartTest() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/box_spring_black.json"));

        open(baseUrl);
        closeWelcomeMessage();
        header.openBoxSpring();
        AdjustableBasePlp.OpenProductPage("BLACK");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Standard");
        product.clickAddToCart();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not found on cart page");

        cart.clickOnDeleteProduct(item.getTitle());

        Assert.assertFalse(cart.itemDisplayedOnViewCartPage(item), "Item was found on cart page");

        close();
    }

    @Test
    @TestName (name = "Delete Silver Box Spring from cart")

    public void deleteSilverBoxSpringFromCartTest() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/box_spring_silver.json"));

        open(baseUrl);
        closeWelcomeMessage();
        header.openBoxSpring();
        AdjustableBasePlp.OpenProductPage("SILVER");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Low Profile");
        product.clickAddToCart();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not found on cart page");

        cart.clickOnDeleteProduct(item.getTitle());

        Assert.assertFalse(cart.itemDisplayedOnViewCartPage(item), "Item was found on cart page");

        close();
    }

    @Test
    @TestName (name = "Delete Platinum Box Spring from cart")

    public void deletePlatinumBoxSpringFromCartTest() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/box_spring_platinum.json"));

        open(baseUrl);
        closeWelcomeMessage();
        header.openBoxSpring();
        AdjustableBasePlp.OpenProductPage("PLATINUM");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Low Profile");
        product.clickAddToCart();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not found on cart page");

        cart.clickOnDeleteProduct(item.getTitle());

        Assert.assertFalse(cart.itemDisplayedOnViewCartPage(item), "Item was found on cart page");

        close();
    }
}
