package smoke.update_test;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.PageHeader;
import pages.ProductPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;


public class Update_Mattress_Test extends BaseTest {

    PageHeader header = PageHeader.Instance;
    ProductPage product = ProductPage.Instance;
    CartPage cart = CartPage.Instance;

    @Test
    @TestName (name = "Black Calista Mattress Update Test")
    public void BlackCalistaMattressUpdateTest() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/black_calista.json"));
        ItemEntity newitem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/black_calista_upd.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Black")
                .OpenProductPage("CALISTA");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Soft");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        cart.clickOnEditProduct(item.getTitle());

        product.SelectSize(newitem.getSize());
        product.SelectProductOption("Firm");
        product.clickUpdateProduct();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(newitem), "Failed to update product");

    }

    @Test
    @TestName (name = "Black Katarina Mattress Update Test")
    public void BlackKatarinaMattressUpdateTest() throws Exception{

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/black_katarina.json"));
        ItemEntity newitem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/black_katarina_upd.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Black")
                .OpenProductPage("KATARINA");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Medium Pillow Top");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        cart.clickOnEditProduct(item.getTitle());

        product.SelectSize(newitem.getSize());
        product.SelectProductOption("Soft Pillow Top");
        product.clickUpdateProduct();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(newitem), "Failed to update product");

    }

    @Test
    @TestName (name = "Platinum Atlas Cove Mattress Update Test")
    public void PlatinumAtlasCoveMattressUpdateTest() throws Exception{

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/platinum_atlas_cove.json"));
        ItemEntity newitem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/platinum_atlas_cove_upd.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Platinum")
                .OpenProductPage("ATLAS COVE");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Firm");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        cart.clickOnEditProduct(item.getTitle());

        product.SelectSize(newitem.getSize());
        product.SelectProductOption("Soft");
        product.clickUpdateProduct();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(newitem), "Failed to update product");

    }

    @Test
    @TestName (name = "Platinum Crestridge Mattress Update Test")
    public void PlatinumCrestridgeMattressUpdateTest() throws Exception{

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/platinum_crestridge.json"));
        ItemEntity newitem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/platinum_crestridge_upd.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Platinum")
                .OpenProductPage("CRESTRIDGE");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Soft");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        cart.clickOnEditProduct(item.getTitle());

        product.SelectSize(newitem.getSize());
        product.SelectProductOption("Firm");
        product.clickUpdateProduct();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(newitem), "Failed to update product");

    }

    @Test
    @TestName (name = "Platinum Spring Grove Mattress Update Test")
    public void PlatinumSpringGroveMattressUpdateTest() throws Exception{

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/platinum_spring_grove.json"));
        ItemEntity newitem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/platinum_spring_grove_upd.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Platinum")
                .OpenProductPage("SPRING GROVE");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Firm");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        cart.clickOnEditProduct(item.getTitle());

        product.SelectSize(newitem.getSize());
        product.SelectProductOption("Soft Pillow Top");
        product.clickUpdateProduct();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(newitem), "Failed to update product");

    }

    @Test
    @TestName (name = "Silver Austin Reef Mattress Update Test")
    public void SilverAustinReefMattressUpdateTest() throws Exception{

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/silver_austin_reef.json"));
        ItemEntity newitem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/silver_austin_reef_upd.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Silver")
                .OpenProductPage("AUSTIN REEF");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Soft");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        cart.clickOnEditProduct(item.getTitle());

        product.SelectSize(newitem.getSize());
        product.SelectProductOption("Medium");
        product.clickUpdateProduct();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(newitem), "Failed to update product");

    }

    @Test
    @TestName (name = "Silver Beachwood Mattress Update Test")
    public void SilverBeachwoodMattressUpdateTest() throws Exception{

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/silver_beachwood.json"));
        ItemEntity newitem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/silver_beachwood_upd.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Silver")
                .OpenProductPage("BEACHWOOD");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Medium");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        cart.clickOnEditProduct(item.getTitle());

        product.SelectSize(newitem.getSize());
        product.SelectProductOption("Soft");
        product.clickUpdateProduct();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(newitem), "Failed to update product");

    }

    @Test
    @TestName (name = "Silver Open Seas Mattress Update Test")
    public void SilverOpenSeasMattressUpdateTest() throws Exception{

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/silver_open_seas.json"));
        ItemEntity newitem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/silver_open_seas_upd.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Silver")
                .OpenProductPage("OPEN SEAS");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Medium Pillow Top");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        cart.clickOnEditProduct(item.getTitle());

        product.SelectSize(newitem.getSize());
        product.SelectProductOption("Firm");
        product.clickUpdateProduct();

        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(newitem), "Failed to update product");

    }
}
