package smoke.general_test;

import annotations.TestName;
import org.testng.annotations.Test;
import pages.PageFooter;
import utils.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;
import static pages.FaqPage.*;

public class FAQ_Test extends BaseTest{

    @Test
    @TestName (name = "FAQ Test")
    public void FAQ_Test(){

        open(baseUrl);
        closeWelcomeMessage();
        PageFooter.openFAQ();

//        verifyOurMattressAccordion();
//        verifyReturnsAndWarrantyAccordion();
//        verifyPurchasingAccordion();
//        verifyShippingAndDeliveryAccordion();
        verifySearchBox();
    }
}
