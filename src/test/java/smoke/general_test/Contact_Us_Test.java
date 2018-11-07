package smoke.general_test;


import annotations.TestName;
import entities.UserEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;


import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static pages.BasePage.closeWelcomeMessage;

public class Contact_Us_Test extends BaseTest {

    @Test
    @TestName(name="Contact Us test")
    public void ContactUs() throws Exception {

        ContactUsPage contactUs = ContactUsPage.Instance;
        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("user.json"));

        open(baseUrl);
        closeWelcomeMessage();
        PageFooter.openContactUs();
        contactUs.populatesFields(user);
        contactUs.setComment("asd123");
        contactUs.clickOnSubmitButton();

        Assert.assertFalse(ContactUsPage.CheckthatCorrectMessageIsDisplayed.isDisplayed());
        //Assert.assertTrue(ContactUsPage.CheckthatCorrectMessageIsDisplayed());

    }

}
