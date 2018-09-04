package smoke.full_test;

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

public class Silver_Austinreef_Mattress_Full_Test extends BaseTest{

    HomePage home = HomePage.Instance;
    PageHeader header = PageHeader.Instance;
    ProductPage product = ProductPage.Instance;
    CartPage cart = CartPage.Instance;
    CheckoutPage checkout = CheckoutPage.Instance;
    AdminPage admin = AdminPage.Instance;

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
