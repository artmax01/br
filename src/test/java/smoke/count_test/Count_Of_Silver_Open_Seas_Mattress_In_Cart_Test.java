package smoke.count_test;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageHeader;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.ProductPage.*;

public class Count_Of_Silver_Open_Seas_Mattress_In_Cart_Test extends BaseTest {

    @Test
    @TestName(name = "Check count of katarina mattresses in cart and minicart icon")
    public void countOfOpenSeasInCart_Test() throws Exception {

        ItemEntity firstmattress = EntitiesFactory.getItem(FileIO.getDataFile("mattress/silver_open_seas.json"));
        ItemEntity secondmattress = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/silver_beachwood_upd.json"));

        int countOfProductsFromIcon;
        int countOfProductsInCart;

        PageHeader header = PageHeader.Instance;

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Silver")
                .OpenProductPage("OPEN SEAS");
        SelectSize(firstmattress.getSize());
        SelectProductOption("Medium Pillow Top");
        clickAddToCart();

        open(baseUrl);
        header.openMattressByType("Silver")
                .OpenProductPage("OPEN SEAS");
        SelectSize(firstmattress.getSize());
        SelectProductOption("Medium Pillow Top");
        clickAddToCart();

        open(baseUrl);
        header.openMattressByType("Silver")
                .OpenProductPage("OPEN SEAS");
        SelectSize(firstmattress.getSize());
        SelectProductOption("Medium Pillow Top");
        clickAddToCart();

        open(baseUrl);

        countOfProductsFromIcon = header.getCountOfProductsOnMinicartIcon();
        countOfProductsInCart = header.getCountOfGoodsInMinicart();
        Assert.assertTrue(countOfProductsFromIcon == countOfProductsInCart, "Count of products in cart does not equal to count from minicart icon");

        header.openMattressByType("Silver")
                .OpenProductPage("OPEN SEAS");
        SelectSize(secondmattress.getSize());
        SelectProductOption("Firm");
        clickAddToCart();

        open(baseUrl);
        header.openMattressByType("Silver")
                .OpenProductPage("OPEN SEAS");
        SelectSize(secondmattress.getSize());
        SelectProductOption("Firm");
        clickAddToCart();

        open(baseUrl);

        countOfProductsFromIcon = header.getCountOfProductsOnMinicartIcon();
        countOfProductsInCart = header.getCountOfGoodsInMinicart();
        Assert.assertTrue(countOfProductsFromIcon == countOfProductsInCart, "Count of products in cart does not equal to count from minicart icon");
    }
}
