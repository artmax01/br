package smoke;

import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PageHeader;
import utils.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static pages.MattressPlp.verifyProductTypeFilter;

public class Product_Filter_Test extends BaseTest {

    @Test
    @TestName(name = "Mattress type filter test")

    public static void VerifyMattressTypeFilter(){

        open(HomePage.pageURL);
        PageHeader.openMattressesPlp();
        Assert.assertTrue(verifyProductTypeFilter(), "Failed to sort products by type");
    }


    @Test
    @TestName(name = "Mattress price filter test")

    public static void VerifyMattressPriceFilter(){
        open(HomePage.pageURL);
        PageHeader.openMattressesPlp();
        //verifyProductPriceFilter();
    }
}
