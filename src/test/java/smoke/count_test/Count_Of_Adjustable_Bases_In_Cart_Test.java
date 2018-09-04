package smoke.count_test;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdjustableBasePlp;
import pages.HomePage;
import pages.PageHeader;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.ProductPage.*;

public class Count_Of_Adjustable_Bases_In_Cart_Test extends BaseTest {

    @Test
    @TestName(name = "Check count of adjustable bases in cart and minicart icon")
    public void countOfAdjustableBasesInCart_Test() throws Exception {

        ItemEntity firstitem = EntitiesFactory.getItem(FileIO.getDataFile("mattress/adjustable_base.json"));
        ItemEntity seconditem = EntitiesFactory.getItem(FileIO.getDataFile("updated_products/adjustable_base_upd.json"));

        int countOfProductsFromIcon;
        int countOfProductsInCart;

        PageHeader header = PageHeader.Instance;

        open(baseUrl);
        closeWelcomeMessage();
        header.openAdjustableBase();
        AdjustableBasePlp.OpenProductPage("SMARTMOTION");
        SelectSize(firstitem.getSize());
        clickAddToCart();

        open(baseUrl);
        header.openAdjustableBase();
        AdjustableBasePlp.OpenProductPage("SMARTMOTION");
        SelectSize(firstitem.getSize());
        clickAddToCart();

        open(baseUrl);
        header.openAdjustableBase();
        AdjustableBasePlp.OpenProductPage("SMARTMOTION");
        SelectSize(firstitem.getSize());
        clickAddToCart();

        open(baseUrl);

        countOfProductsFromIcon = header.getCountOfProductsOnMinicartIcon();
        countOfProductsInCart = header.getCountOfGoodsInMinicart();
        Assert.assertTrue(countOfProductsFromIcon == countOfProductsInCart, "Count of products in cart does not equal to count from minicart icon");

        header.openAdjustableBase();
        AdjustableBasePlp.OpenProductPage("SMARTMOTION");
        SelectSize(seconditem.getSize());
        SelectProductOption("3.0");
        clickAddToCart();

        open(baseUrl);
        header.openAdjustableBase();
        AdjustableBasePlp.OpenProductPage("SMARTMOTION");
        SelectSize(seconditem.getSize());
        SelectProductOption("3.0");
        clickAddToCart();

        open(baseUrl);

        countOfProductsFromIcon = header.getCountOfProductsOnMinicartIcon();
        countOfProductsInCart = header.getCountOfGoodsInMinicart();
        Assert.assertTrue(countOfProductsFromIcon == countOfProductsInCart, "Count of products in cart does not equal to count from minicart icon");
    }
}
