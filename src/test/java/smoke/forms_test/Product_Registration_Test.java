package smoke.forms_test;

import annotations.TestName;
import entities.ItemEntity;
import entities.UserEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.PageFooter;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;
import pages.ProductRegistrationPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;
import static pages.BasePage.waitForPageToLoad;

public class Product_Registration_Test extends BaseTest {

    @Test
    @TestName(name = "Product Registration Test")
    public void ProductRegistration_Test() throws Exception{

        ProductRegistrationPage ProductRegistration = ProductRegistrationPage.Instance;
        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("user.json"));

        open(baseUrl);
        closeWelcomeMessage();
        PageFooter.openProductRegistration();
        ProductRegistration.populateFields(user);
        ProductRegistration.clickOnSubmitButton();
        waitForPageToLoad();
        Assert.assertTrue(ProductRegistrationPage.captchaWarningMessageIsDisplayed(), "reCaptcha warning message is not displayed");

    }
}
