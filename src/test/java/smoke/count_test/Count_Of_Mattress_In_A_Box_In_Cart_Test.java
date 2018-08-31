package smoke.count_test;

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
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;


public class Count_Of_Mattress_In_A_Box_In_Cart_Test extends BaseTest {

    @Test
    @TestName(name = "Count of Mattress in a Box in cart and minicart icon")
    public void Mattress_in_a_box() throws Exception{

        PageHeader header = PageHeader.Instance;
        ProductPage product = ProductPage.Instance;

        int countOfProductsFromIcon;
        int countOfProductsInCart;

        ItemEntity firstitem = EntitiesFactory.getItem(FileIO.getDataFile("mattress/mattress_in_a_box.json"));
        ItemEntity seconditem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/mattress_in_a_box_upd.json"));

        open(baseUrl);
        closeWelcomeMessage();
        header.openMattressInABox()
                .OpenMattressInABoxPdp();
        product.SelectSize(firstitem.getSize());
        product.clickAddToCart();

        open(baseUrl);
        header.openMattressInABox()
                .OpenMattressInABoxPdp();
        product.SelectSize(firstitem.getSize());
        product.clickAddToCart();

        open(baseUrl);
        header.openMattressInABox()
                .OpenMattressInABoxPdp();
        product.SelectSize(firstitem.getSize());
        product.clickAddToCart();

        open(baseUrl);

        countOfProductsFromIcon = header.getCountOfProductsOnMinicartIcon();
        countOfProductsInCart = header.getCountOfGoodsInMinicart();
        Assert.assertTrue(countOfProductsFromIcon == countOfProductsInCart, "Count of products in cart does not equal to count from minicart icon");

        header.openMattressInABox()
                .OpenMattressInABoxPdp();
        product.SelectSize(seconditem.getSize());
        product.clickAddToCart();

        open(baseUrl);
        header.openMattressInABox()
                .OpenMattressInABoxPdp();
        product.SelectSize(seconditem.getSize());
        product.clickAddToCart();

        open(baseUrl);

        countOfProductsFromIcon = header.getCountOfProductsOnMinicartIcon();
        countOfProductsInCart = header.getCountOfGoodsInMinicart();
        Assert.assertTrue(countOfProductsFromIcon == countOfProductsInCart, "Count of products in cart does not equal to count from minicart icon");

        close();
     }

}
