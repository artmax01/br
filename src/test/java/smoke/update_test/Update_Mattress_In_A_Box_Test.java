package smoke.update_test;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.PageHeader;
import pages.ProductPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;

public class Update_Mattress_In_A_Box_Test extends BaseTest {

    HomePage home = HomePage.Instance;
    PageHeader header = PageHeader.Instance;
    ProductPage product = ProductPage.Instance;
    CartPage cart = CartPage.Instance;

    @Test
    @TestName (name = "Black Calista Mattress Update Test")
    public void BlackCalistaMattressUpdateTest() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/mattress_in_a_box.json"));
        ItemEntity newitem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/mattress_in_a_box_upd.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressInABox()
                .OpenMattressInABoxPdp();

        product.SelectSize(item.getSize());
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        cart.clickOnEditProduct(item.getTitle());

        product.SelectSize(newitem.getSize());
        product.clickUpdateProduct();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(newitem), "Failed to update product");
    }
}
