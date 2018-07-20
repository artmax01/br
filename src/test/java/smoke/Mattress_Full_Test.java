package smoke;

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


public class Mattress_Full_Test extends BaseTest {

    HomePage home = HomePage.Instance;
    PageHeader header = PageHeader.Instance;
    ProductPage product = ProductPage.Instance;
    CartPage cart = CartPage.Instance;

    @Test
    @TestName (name = "Black Calista mattress full test")

    public void black_calista_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/black_calista.json"));

        open(baseUrl);
        header.openMattressByType("Black")
                .OpenProductPage("CALISTA");

        product.SelectSize(item.getSize());
        product.SelectProductOption(item.getType());
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");

    }

    @Test
    @TestName (name = "Black Katarina mattress full test")

    public void black_katarina_mattress_full_test() throws Exception{

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/black_katarina.json"));

        open(baseUrl);
        header.openMattressByType("Black")
                .OpenProductPage("KATARINA");

        product.SelectSize(item.getSize());
        product.SelectProductOption(item.getType());
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");
    }

    @Test
    @TestName (name = "Platinum Spring Grove mattress full test")

    public void platinum_springgrove_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/platinum_spring_grove.json"));

        open(baseUrl);
        header.openMattressByType("Platinum")
                .OpenProductPage("SPRING GROVE");

        product.SelectSize(item.getSize());
        product.SelectProductOption(item.getType());
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");
    }

    @Test
    @TestName(name = "Platinum Crestridge mattress full test")

    public void platinum_crestridge_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/platinum_crestridge.json"));

        open(baseUrl);
        header.openMattressByType("Platinum")
                .OpenProductPage("CRESTRIDGE");

        product.SelectSize(item.getSize());
        product.SelectProductOption(item.getType());
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");
    }

    @Test
    @TestName(name = "Platinum Atlas Cove mattress full test")

    public void platinum_atlascove_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/platinum_atlas_cove.json"));

        open(baseUrl);
        header.openMattressByType("Platinum")
                .OpenProductPage("ATLAS COVE");

        product.SelectSize(item.getSize());
        product.SelectProductOption(item.getType());
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");
    }

    @Test
    @TestName(name = "Silver Open Seas mattress full test")

    public void silver_openseas_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/silver_open_seas.json"));

        open(baseUrl);
        header.openMattressByType("Silver")
                .OpenProductPage("OPEN SEAS");

        product.SelectSize(item.getSize());
        product.SelectProductOption(item.getType());
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");
    }

    @Test
    @TestName(name = "Silver Beachwood mattress full test")

    public void silver_beachwood_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/silver_beachwood.json"));

        open(baseUrl);
        header.openMattressByType("Silver")
                .OpenProductPage("BEACHWOOD");

        product.SelectSize(item.getSize());
        product.SelectProductOption(item.getType());
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");
    }

    @Test
    @TestName(name = "Silver Austin Reef mattress full test")

    public void silver_austinreef_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/silver_austin_reef.json"));

        open(baseUrl);
        header.openMattressByType("Silver")
                .OpenProductPage("AUSTIN REEF");

        product.SelectSize(item.getSize());
        product.SelectProductOption(item.getType());
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");
    }

}
