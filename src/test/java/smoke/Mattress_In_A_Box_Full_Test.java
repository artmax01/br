package smoke;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;


public class Mattress_In_A_Box_Full_Test extends BaseTest {

    HomePage home = HomePage.Instance;
    PageHeader header = PageHeader.Instance;
    ProductPage product = ProductPage.Instance;
    CartPage cart = CartPage.Instance;

    @Test
    @TestName(name = "Mattress in a Box full test")
    public void Mattress_in_a_box() throws Exception{

             ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/mattress_in_a_box.json"));

             open(baseUrl);
            header.openMattressInABox()
                    .OpenMattressInABoxPdp();

             product.SelectSize(item.getSize());
             product.clickAddToCart();
             Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

             open(baseUrl);
             Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");

     }


}
