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

public class Count_Of_Black_Katarina_Mattress_In_Cart_Test extends BaseTest {

    @Test
    @TestName(name = "Check count of katarina mattresses in cart and minicart icon")
    public void countOfKatarinaInCart_Test() throws Exception {

        ItemEntity firstmattress = EntitiesFactory.getItem(FileIO.getDataFile("mattress/black_katarina.json"));
        ItemEntity secondmattress = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/black_katarina_upd.json"));

        int countOfProductsFromIcon;
        int countOfProductsInCart;

        PageHeader header = PageHeader.Instance;

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Black")
                .OpenProductPage("KATARINA");
        SelectSize(firstmattress.getSize());
        SelectProductOption("Medium Pillow Top");
        clickAddToCart();

        open(baseUrl);
        header.openMattressByType("Black")
                .OpenProductPage("KATARINA");
        SelectSize(firstmattress.getSize());
        SelectProductOption("Medium Pillow Top");
        clickAddToCart();

        open(baseUrl);
        header.openMattressByType("Black")
                .OpenProductPage("KATARINA");
        SelectSize(firstmattress.getSize());
        SelectProductOption("Medium Pillow Top");
        clickAddToCart();

        open(baseUrl);

        countOfProductsFromIcon = header.getCountOfProductsOnMinicartIcon();
        countOfProductsInCart = header.getCountOfGoodsInMinicart();
        Assert.assertTrue(countOfProductsFromIcon == countOfProductsInCart, "Count of products in cart does not equal to count from minicart icon");

        header.openMattressByType("Black")
                .OpenProductPage("KATARINA");
        SelectSize(secondmattress.getSize());
        SelectProductOption("Soft Pillow Top");
        clickAddToCart();

        open(baseUrl);
        header.openMattressByType("Black")
                .OpenProductPage("KATARINA");
        SelectSize(secondmattress.getSize());
        SelectProductOption("Soft Pillow Top");
        clickAddToCart();

        open(baseUrl);

        countOfProductsFromIcon = header.getCountOfProductsOnMinicartIcon();
        countOfProductsInCart = header.getCountOfGoodsInMinicart();
        Assert.assertTrue(countOfProductsFromIcon == countOfProductsInCart, "Count of products in cart does not equal to count from minicart icon");
    }
}
