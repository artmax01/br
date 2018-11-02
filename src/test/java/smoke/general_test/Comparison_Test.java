package smoke.general_test;

import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparisonPage;
import pages.MattressPlp;
import pages.PageHeader;
import utils.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;

public class Comparison_Test extends BaseTest{

    PageHeader header = PageHeader.Instance;
    MattressPlp mattressPlp = MattressPlp.Instance;
    ComparisonPage compare = ComparisonPage.Instance;

    @Test
    @TestName (name = "Compare button presence test")

    public void checkCompareButtonPresenceTest() {

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Black");
        Assert.assertTrue(mattressPlp.compareButtonIsDisplayed(), "Failed to locate compare button");

        header.openMattressByType("Silver");
        Assert.assertTrue(mattressPlp.compareButtonIsDisplayed(), "Failed to locate compare button");

        header.openMattressByType("Platinum");
        Assert.assertTrue(mattressPlp.compareButtonIsDisplayed(), "Failed to locate compare button");

        header.openMattressInABox();
        Assert.assertTrue(mattressPlp.compareButtonIsDisplayed(), "Failed to locate compare button");

        close();
    }


    @Test
    @TestName (name = "Compare block presence test")

    public void checkCompareBlockPresence(){

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressesPlp();
        mattressPlp.addProductsForComparison();
        Assert.assertTrue(mattressPlp.compareBlockIsDisplayed(), "Failed to locate Compare Block");

        close();
    }


//    @Test
//    @TestName (name = "Clear comparison selections button functionality test")
//
//    public void checkClearComparisonSelectionsButton(){
//
//        open(baseUrl);
//        closeWelcomeMessage();
//
//        header.openMattressesPlp();
//        mattressPlp.addProductsForComparison();
//        mattressPlp.clickOnClearSelectionsButton();
//        Assert.assertFalse(mattressPlp.compareBlockIsDisplayed(), "Failed to clear comparison selections");
//
//        close();
//    }

    @Test
    @TestName (name = "Compare- button on PLP functionality test")

    public void checkRemoveComparisonPlpButton(){

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressesPlp();
        mattressPlp.addProductsForComparison();
        mattressPlp.removeProductsForComparisonFromPlp();
        Assert.assertFalse(mattressPlp.compareBlockIsDisplayed(), "Failed to remove product comparison selections");

        close();
    }


    @Test
    @TestName (name = "Remove button on compare block functionality test")

    public void checkRemoveComparisonBlockButton(){

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressesPlp();
        mattressPlp.addProductsForComparison();
        mattressPlp.removeProductsForComparisonFromCompareBlock();
        Assert.assertFalse(mattressPlp.compareBlockIsDisplayed(), "Failed to remove product comparison selections");

        close();
    }


    @Test
    @TestName (name = "Compare button functionality test")

    public void checkCompareButtonFunctionality(){

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressesPlp();
        mattressPlp.addProductsForComparison();
        mattressPlp.clickOnCompareButton();
        Assert.assertTrue(compare.checkComparisonTable(), "Failed to locate comparison table");

        close();
    }

    @Test
    @TestName (name = "Check comparison of different product lines")

    public void checkComparisonOfDifferentProductLines(){

        open(baseUrl);
        closeWelcomeMessage();

        header.openMattressByType("Black");
        mattressPlp.addOneProductForComparison();

        header.openMattressByType("Silver");
        mattressPlp.addOneProductForComparison();

        header.openMattressByType("Platinum");
        mattressPlp.addOneProductForComparison();

        mattressPlp.clickOnCompareButton();
        Assert.assertTrue(compare.checkComparisonTable(), "Failed to locate comparison table");

        close();
    }
}
