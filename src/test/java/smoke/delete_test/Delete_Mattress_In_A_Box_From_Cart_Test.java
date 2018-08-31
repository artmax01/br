package smoke.delete_test;

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
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;


public class Delete_Mattress_In_A_Box_From_Cart_Test extends BaseTest {

    @Test
    @TestName(name = "Delete Mattress in a Box from cart")
    public void Mattress_in_a_box() throws Exception{

        PageHeader header = PageHeader.Instance;
        ProductPage product = ProductPage.Instance;
        CartPage cart = CartPage.Instance;

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/mattress_in_a_box.json"));

        open(baseUrl);
        closeWelcomeMessage();
        header.openMattressInABox()
                .OpenMattressInABoxPdp();

        product.SelectSize(item.getSize());
        product.clickAddToCart();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not found on cart page");

        cart.clickOnDeleteProduct(item.getTitle());

        Assert.assertFalse(cart.itemDisplayedOnViewCartPage(item), "Item was found on cart page");

        close();
     }

}
