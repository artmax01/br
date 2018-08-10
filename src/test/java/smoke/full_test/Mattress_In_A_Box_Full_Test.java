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


public class Mattress_In_A_Box_Full_Test extends BaseTest {

    @Test
    @TestName(name = "Mattress in a Box full test")
    public void Mattress_in_a_box() throws Exception{

        HomePage home = HomePage.Instance;
        PageHeader header = PageHeader.Instance;
        ProductPage product = ProductPage.Instance;
        CartPage cart = CartPage.Instance;
        CheckoutPage checkout = CheckoutPage.Instance;
        AdminPage admin = AdminPage.Instance;

        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("user.json"));
        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress/mattress_in_a_box.json"));

        open(baseUrl);
        closeWelcomeMessage();
        header.openMattressInABox()
                .OpenMattressInABoxPdp();

        product.SelectSize(item.getSize());
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
