package smoke.forms_test;

import annotations.TestName;
import entities.UserEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageFooter;
import  pages.WarrantyPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;


import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;


public class Warranty_Claim_Test extends BaseTest {

    @Test
    @TestName (name = "Warranties Test")
    public void WarrantyClaim_Test() throws Exception {

        WarrantyPage warranty = WarrantyPage.Instance;
        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("user.json"));

        open(baseUrl);
        closeWelcomeMessage();

        PageFooter.openWarranty();
        warranty.openClaimePage();

        warranty.FillFields(user);

        Assert.assertTrue(warranty.checkCaptchaMessage(), "Captcha message don`t display");
    }
}
