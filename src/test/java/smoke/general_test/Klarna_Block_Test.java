package smoke.general_test;

import annotations.TestName;
import org.testng.annotations.Test;
import pages.AdjustableBasePlp;
import pages.PageHeader;
import pages.ProductPage;
import utils.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class Klarna_Block_Test extends BaseTest {

    @Test
    @TestName (name = "Klarna Block on PDP Test")

    public void Klarna_Block_Test(){

        PageHeader header = PageHeader.Instance;
        ProductPage product = ProductPage.Instance;

        open(baseUrl);
        header.openBoxSpring();
        AdjustableBasePlp.OpenProductPage("BLACK");
        product.SelectSize("Cal. King");
        product.verifyKlarnaPresence();

        product.SelectSize("Full");
        product.verifyKlarnaAbsence();

    }
}
