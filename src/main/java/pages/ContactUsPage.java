package pages;

import com.codeborne.selenide.SelenideElement;
import entities.UserEntity;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ContactUsPage extends BasePage {
    private static ContactUsPage instance;
    public static ContactUsPage Instance = (instance != null) ? instance : new ContactUsPage();

    public ContactUsPage(){
        pageURL = "https://staging-br.tomorrowsleep.com/contact-us";
    }

    /** UI Mapping **/

    public static SelenideElement
            emailField = $(By.xpath("//input[@placeholder='Email*']")),
            firstNameField = $(By.xpath("//input[@placeholder='First Name*']")),
            lastNameField = $(By.xpath("//input[@placeholder='Last Name*']")),
            phoneField = $(By.xpath("//input[@placeholder='Phone*']")),
            commentField = $(By.xpath("//textarea[@name='loffield_c519']")),
            submitButton = $(By.xpath("//button[@class='formbuilder-button button']")),
            CheckthatCorrectMessageIsDisplayed = $(By.xpath("//*[@id=\"maincontent\"]/div[1]/div/div/div"));

    /** Page Methods **/

    public static boolean CheckthatCorrectMessageIsDisplayed() {
        reporter.info("Checking that correct message is displayed");
        waitForElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div/div/div"));
        if(CheckthatCorrectMessageIsDisplayed.isDisplayed()){
          return true;
      }
        return false;
    }

    public ContactUsPage populatesFields(UserEntity user){
        waitForPageToLoad();

        this
                .setFirstName(user.getFirstname())
                .setLastname(user.getLastname())
                .setEmail("beautyrest.test@g.com")
                .setPhone(user.getPhone())
                .setComment("asd123");
        return this;
    }

    private ContactUsPage setLastname(String lastname) {
        reporter.info("Set Last Name: " + lastname);
        lastNameField.sendKeys("Maksymiv");
        return  this;
    }

    public ContactUsPage setFirstName(String firstName){
        reporter.info("Set First Name: " + firstName);
        firstNameField.sendKeys("Artur");
        return this;
    }

    public ContactUsPage setEmail(String email){
        reporter.info("Set Email: " + email);
        emailField.sendKeys("test.beautyrest@g.com");
        return this;
    }

    public ContactUsPage setPhone(String phone){
        reporter.info("Set Phone: " + phone);
        phoneField.sendKeys("(123)456-7890");
        return this;
    }

    public ContactUsPage setComment(String comment){
        waitForPageToLoad();
        reporter.info("Set Comment: " + comment);
        commentField.sendKeys("asd123");
        return this;
    }

    public ContactUsPage clickOnSubmitButton(){
        waitForPageToLoad();
        reporter.info("Click on Submit button");
        submitButton.scrollIntoView(true).click();
        return this;
    }
}
