package smoke.full_test;

import annotations.TestName;
import entities.ItemEntity;
import entities.UserEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.BasePage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;


public class Mattress_Full_Test extends BaseTest {

    HomePage home = HomePage.Instance;
    PageHeader header = PageHeader.Instance;
    ProductPage product = ProductPage.Instance;
    CartPage cart = CartPage.Instance;
    CheckoutPage checkout = CheckoutPage.Instance;
    AdminPage admin = AdminPage.Instance;

    @Test
    @TestName (name = "Black Calista mattress full test")

    public void black_calista_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/black_calista.json"));
        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("user.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Black")
                .OpenProductPage("CALISTA");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Soft");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        //Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");

        header.clickOnViewCheckoutPage();
        checkout.populateShippingFields(user)
            .payWithCreditCard();
        Assert.assertTrue(checkout.orderHasBeenPlaced(), "Failed to place order");

        String orderNumber = checkout.getOrderNumber();
        BasePage.openAdminPage();

        admin.doLogin()
            .navigateToOrders();
        Assert.assertTrue(admin.orderIsDisplayedOnOrdersPage(orderNumber), "Failed to locate order " + orderNumber);

        admin.viewOrderDetails();
        Assert.assertTrue(admin.orderContainsProduct(item), "Order does not contain product");

        admin.clickOnCancelButton();
        Assert.assertTrue(admin.orderHasBeenCanceled(), "Failed to cancel order " + orderNumber);

    }

    @Test
    @TestName (name = "Black Katarina mattress full test")

    public void black_katarina_mattress_full_test() throws Exception{

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/black_katarina.json"));
        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("user.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Black")
                .OpenProductPage("KATARINA");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Medium Pillow Top");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");

        header.clickOnViewCheckoutPage();
        checkout.populateShippingFields(user)
                .payWithCreditCard();
        Assert.assertTrue(checkout.orderHasBeenPlaced(), "Failed to place order");

        String orderNumber = checkout.getOrderNumber();
        BasePage.openAdminPage();

        admin.doLogin()
                .navigateToOrders();
        Assert.assertTrue(admin.orderIsDisplayedOnOrdersPage(orderNumber), "Failed to locate order " + orderNumber);

        admin.viewOrderDetails();
        Assert.assertTrue(admin.orderContainsProduct(item), "Order does not contain product");

        admin.clickOnCancelButton();
        Assert.assertTrue(admin.orderHasBeenCanceled(), "Failed to cancel order " + orderNumber);

    }

    @Test
    @TestName (name = "Platinum Spring Grove mattress full test")

    public void platinum_springgrove_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/platinum_spring_grove.json"));
        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("user.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Platinum")
                .OpenProductPage("SPRING GROVE");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Firm");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");

        header.clickOnViewCheckoutPage();
        checkout.populateShippingFields(user)
                .payWithCreditCard();
        Assert.assertTrue(checkout.orderHasBeenPlaced(), "Failed to place order");

        String orderNumber = checkout.getOrderNumber();
        BasePage.openAdminPage();

        admin.doLogin()
                .navigateToOrders();
        Assert.assertTrue(admin.orderIsDisplayedOnOrdersPage(orderNumber), "Failed to locate order " + orderNumber);

        admin.viewOrderDetails();
        Assert.assertTrue(admin.orderContainsProduct(item), "Order does not contain product");

        admin.clickOnCancelButton();
        Assert.assertTrue(admin.orderHasBeenCanceled(), "Failed to cancel order " + orderNumber);

    }

    @Test
    @TestName(name = "Platinum Crestridge mattress full test")

    public void platinum_crestridge_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/platinum_crestridge.json"));
        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("user.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Platinum")
                .OpenProductPage("CRESTRIDGE");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Soft");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");

        header.clickOnViewCheckoutPage();
        checkout.populateShippingFields(user)
                .payWithCreditCard();
        Assert.assertTrue(checkout.orderHasBeenPlaced(), "Failed to place order");

        String orderNumber = checkout.getOrderNumber();
        BasePage.openAdminPage();

        admin.doLogin()
                .navigateToOrders();
        Assert.assertTrue(admin.orderIsDisplayedOnOrdersPage(orderNumber), "Failed to locate order " + orderNumber);

        admin.viewOrderDetails();
        Assert.assertTrue(admin.orderContainsProduct(item), "Order does not contain product");

        admin.clickOnCancelButton();
        Assert.assertTrue(admin.orderHasBeenCanceled(), "Failed to cancel order " + orderNumber);

    }

    @Test
    @TestName(name = "Platinum Atlas Cove mattress full test")

    public void platinum_atlascove_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/platinum_atlas_cove.json"));
        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("user.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Platinum")
                .OpenProductPage("ATLAS COVE");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Firm");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");

        header.clickOnViewCheckoutPage();
        checkout.populateShippingFields(user)
                .payWithCreditCard();
        Assert.assertTrue(checkout.orderHasBeenPlaced(), "Failed to place order");

        String orderNumber = checkout.getOrderNumber();
        BasePage.openAdminPage();

        admin.doLogin()
                .navigateToOrders();
        Assert.assertTrue(admin.orderIsDisplayedOnOrdersPage(orderNumber), "Failed to locate order " + orderNumber);

        admin.viewOrderDetails();
        Assert.assertTrue(admin.orderContainsProduct(item), "Order does not contain product");

        admin.clickOnCancelButton();
        Assert.assertTrue(admin.orderHasBeenCanceled(), "Failed to cancel order " + orderNumber);

    }

    @Test
    @TestName(name = "Silver Open Seas mattress full test")

    public void silver_openseas_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/silver_open_seas.json"));
        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("user.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Silver")
                .OpenProductPage("OPEN SEAS");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Medium Pillow Top");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");

        header.clickOnViewCheckoutPage();
        checkout.populateShippingFields(user)
                .payWithCreditCard();
        Assert.assertTrue(checkout.orderHasBeenPlaced(), "Failed to place order");

        String orderNumber = checkout.getOrderNumber();
        BasePage.openAdminPage();

        admin.doLogin()
                .navigateToOrders();
        Assert.assertTrue(admin.orderIsDisplayedOnOrdersPage(orderNumber), "Failed to locate order " + orderNumber);

        admin.viewOrderDetails();
        Assert.assertTrue(admin.orderContainsProduct(item), "Order does not contain product");

        admin.clickOnCancelButton();
        Assert.assertTrue(admin.orderHasBeenCanceled(), "Failed to cancel order " + orderNumber);

    }

    @Test
    @TestName(name = "Silver Beachwood mattress full test")

    public void silver_beachwood_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/silver_beachwood.json"));
        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("user.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Silver")
                .OpenProductPage("BEACHWOOD");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Medium");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");

        header.clickOnViewCheckoutPage();
        checkout.populateShippingFields(user)
                .payWithCreditCard();
        Assert.assertTrue(checkout.orderHasBeenPlaced(), "Failed to place order");

        String orderNumber = checkout.getOrderNumber();
        BasePage.openAdminPage();

        admin.doLogin()
                .navigateToOrders();
        Assert.assertTrue(admin.orderIsDisplayedOnOrdersPage(orderNumber), "Failed to locate order " + orderNumber);

        admin.viewOrderDetails();
        Assert.assertTrue(admin.orderContainsProduct(item), "Order does not contain product");

        admin.clickOnCancelButton();
        Assert.assertTrue(admin.orderHasBeenCanceled(), "Failed to cancel order " + orderNumber);

    }

    @Test
    @TestName(name = "Silver Austin Reef mattress full test")

    public void silver_austinreef_mattress_full_test() throws Exception {

        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/silver_austin_reef.json"));
        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("user.json"));

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Silver")
                .OpenProductPage("AUSTIN REEF");

        product.SelectSize(item.getSize());
        product.SelectProductOption("Soft");
        product.clickAddToCart();
        Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed on cart page");

        open(baseUrl);
        Assert.assertTrue(home.header.itemWasFoundInMiniCart(item), "Item was not found in minicart");

        header.clickOnViewCheckoutPage();
        checkout.populateShippingFields(user)
                .payWithCreditCard();
        Assert.assertTrue(checkout.orderHasBeenPlaced(), "Failed to place order");

        String orderNumber = checkout.getOrderNumber();
        BasePage.openAdminPage();

        admin.doLogin()
                .navigateToOrders();
        Assert.assertTrue(admin.orderIsDisplayedOnOrdersPage(orderNumber), "Failed to locate order " + orderNumber);

        admin.viewOrderDetails();
        Assert.assertTrue(admin.orderContainsProduct(item), "Order does not contain product");

        admin.clickOnCancelButton();
        Assert.assertTrue(admin.orderHasBeenCanceled(), "Failed to cancel order " + orderNumber);

    }

}
