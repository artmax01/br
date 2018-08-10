package smoke.count_test;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdjustableBasePlp;
import pages.PageHeader;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.ProductPage.*;

public class Count_Of_Box_Spring_Platinum_In_Cart_Test extends BaseTest {

    @Test
    @TestName(name = "Check count of box spring platinum in cart and minicart icon")
    public void countOfBoxSpringPlatinumInCart_Test() throws Exception {

        ItemEntity firstitem = EntitiesFactory.getItem(FileIO.getDataFile("mattress/box_spring_platinum.json"));
        ItemEntity seconditem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/box_spring_platinum_upd.json"));

        int countOfProductsFromIcon;
        int countOfProductsInCart;

        PageHeader header = PageHeader.Instance;

        open(baseUrl);
        closeWelcomeMessage();

        header.openBoxSpring();
        AdjustableBasePlp.OpenProductPage("PLATINUM");
        SelectSize(firstitem.getSize());
        SelectProductOption("Low Profile");
        clickAddToCart();

        open(baseUrl);
        header.openBoxSpring();
        AdjustableBasePlp.OpenProductPage("PLATINUM");
        SelectSize(firstitem.getSize());
        SelectProductOption("Low Profile");
        clickAddToCart();

        open(baseUrl);
        header.openBoxSpring();
        AdjustableBasePlp.OpenProductPage("PLATINUM");
        SelectSize(firstitem.getSize());
        SelectProductOption("Low Profile");
        clickAddToCart();;

        open(baseUrl);

        countOfProductsFromIcon = header.getCountOfProductsOnMinicartIcon();
        countOfProductsInCart = header.getCountOfGoodsInMinicart();
        Assert.assertTrue(countOfProductsFromIcon == countOfProductsInCart, "Count of products in cart does not equal to count from minicart icon");

        header.openBoxSpring();
        AdjustableBasePlp.OpenProductPage("PLATINUM");
        SelectSize(seconditem.getSize());
        SelectProductOption("Standard");
        clickAddToCart();

        open(baseUrl);
        header.openBoxSpring();
        AdjustableBasePlp.OpenProductPage("PLATINUM");
        SelectSize(seconditem.getSize());
        SelectProductOption("Standard");
        clickAddToCart();

        open(baseUrl);

        countOfProductsFromIcon = header.getCountOfProductsOnMinicartIcon();
        countOfProductsInCart = header.getCountOfGoodsInMinicart();
        Assert.assertTrue(countOfProductsFromIcon == countOfProductsInCart, "Count of products in cart does not equal to count from minicart icon");
    }
}
