package smoke;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.PageHeader;
import pages.ProductPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class Black_Mattress_Full_Test extends BaseTest {

    @Test
    @TestName (name = "Black mattress full test")

    public static void black_mattress_full_test() throws Exception {
        ItemEntity item = EntitiesFactory.getItem(FileIO.getDataFile("mattress_black.json"));

        open(baseUrl);
        PageHeader.openMattressByType("Black")
                .OpenProductPage(item);

        ProductPage.SelectSize(item.getSize());
        ProductPage.SelectProductOption(item.getType());
        ProductPage.clickAddToCart();

        CartPage.Instance.open();



    }
}
