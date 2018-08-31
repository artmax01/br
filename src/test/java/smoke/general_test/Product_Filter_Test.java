package smoke.general_test;

import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PageHeader;
import utils.BaseTest;

import static pages.MattressPlp.*;


public class Product_Filter_Test extends BaseTest {

    HomePage home = HomePage.Instance;

//    @Test
//    @TestName(name = "Mattress type filter test")
//
//    public void VerifyMattressTypeFilter(){
//
//        home.open();
//        PageHeader.openMattressesPlp();
//
//        SwitchToAllTypes();
//        Assert.assertTrue(AllTypesAreDisplayed(), "Not all mattress types are displayed");
//
//        //SwitchToPocketedType();
//        //Assert.assertTrue(OnlyPocketedAreDisplayed(), "Non Pocketed mattresses were found");
//
//        SwitchToHybridType();
//        Assert.assertTrue(OnlyHybridAreDisplayed(), "Non Hybrid mattresses were found");
//
//        SwitchToAllTypes();
//        Assert.assertTrue(AllTypesAreDisplayed(), "Not All mattress types are displayed");
//    }


    @Test
    @TestName(name = "Mattress price filter test")

    public void VerifyMattressPriceFilter(){
        home.open();
        PageHeader.openMattressesPlp();

        SwitchToAllPrices();
        Assert.assertTrue(AllPricesAreDisplayed(), "Not all mattresses are displayed");

        MovePriceSliderTo$799_or_less();
        Assert.assertTrue(CheckPrice$799_or_less(), "Failed to filter products to $799 or less");

        MovePriceSliderTo$800_999();
        Assert.assertTrue(CheckPricesAre_$800_999(), "Failed to filter products to range of $800 - $999");

        MovePriceSliderTo$1000_1999();
        Assert.assertTrue(CheckPricesAre_$1000_1999(), "Failed to filter products to range of $1000 - $1999");

        MovePriceSliderTo$2000_2999();
        Assert.assertTrue(CheckPricesAre_$2000_2999(), "Failed to filter products to range of $2000 - $2999");

        MovePriceSliderTo$3000_or_more();
        Assert.assertTrue(CheckPricesAre_$3000_or_more(), "Failed to filter products to $3000 or more");

        SwitchToAllPrices();
        Assert.assertTrue(AllPricesAreDisplayed(), "Not all mattresses are displayed");
    }
}
