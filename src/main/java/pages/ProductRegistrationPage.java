package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import entities.UserEntity;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.FileIO;
import utils.Tools;

import static com.codeborne.selenide.Selenide.*;

public class ProductRegistrationPage extends BasePage {

    private static ProductRegistrationPage instance;
    public static ProductRegistrationPage Instance = (instance != null) ? instance : new ProductRegistrationPage();

    /** UI Mapping **/

    public static SelenideElement
            firstNameField = $(By.xpath("//*[@autocomplete='given-name']")),
            lastNameField = $(By.xpath("//*[@autocomplete=\"family-name\"]")),
            addressField = $(By.xpath("//*[@autocomplete=\"street-address\"]")),
            addressContField = $(By.xpath("//*[@autocomplete=\"c5\"]")),
            cityField = $(By.xpath("//*[@autocomplete=\"locality\"]")),
            stateDropdown = $(By.xpath(".//*[@class='state col-sm-12']/select")),
            zipcodeField = $(By.xpath("//*[@placeholder=\"Zip*\"]")),
            emailField = $(By.xpath("//*[@autocomplete=\"email\"]")),
            confirmEmailField = $(By.xpath("//*[@placeholder=\"Confirm Email*\"]")),
            phoneField = $(By.xpath("//*[@placeholder=\"Phone\"]")),

            dateField = $(By.xpath("//*[@placeholder=\"MM/DD/YYYY*\"]")),
            serialNumberField = $(By.xpath("//*[@placeholder=\"Serial Number \\ Product Number\"]")),
            retailerNameField = $(By.xpath("//*[@placeholder=\"Retailer Name*\"]")),
            retailerCityField = $(By.xpath("//*[@placeholder=\"Retailer City*\"]")),
            retailerStateDropdown = $(By.xpath(".//*[@class='state col-sm-12']/select")),
            brandField = $(By.xpath("//*[@placeholder=\"Brand* \"]")),
            sizeField = $(By.xpath("//*[@placeholder=\"Size\"]")),
            priceField = $(By.xpath("//*[@placeholder=\"Price\"]")),

            reCaptchaCheckbox = $(By.xpath("/html/body/div[2]/div[3]]")),
            submitButton = $(By.xpath(".//button[@type='submit']/span")),

            reCaptchaErrorMessage = $(By.xpath("//*[@id='maincontent']/div[1]"));


    /** Page Methods **/

    public ProductRegistrationPage populateFields(UserEntity user){
        waitForPageToLoad();
        this
                .setFirstName(user.getFirstname())
                .setLastname(user.getLastname())
                .setAddress(user.getStreet())
                .setAddressCont(user.getStreet())
                .setCity(user.getCity())
                .setState(user.getState())
                .setZipcode(user.getZipcode())
                .setEmail("beautyrest.test@test.com")
                .setConfirmEmail("beautyrest.test@test.com")
                .setPhone(user.getPhone())
                .setDate("07/08/2017")
                .setSerialNumber("12345")
                .setRetailerName(user.getFirstname())
                .setRetailerCity(user.getCity())
                .setRetailerState(user.getState())
                .setBrand("Black")
                .setSize("Queen")
                .setPrice("1999");
        waitForPageToLoad();
        return this;
    }

    public ProductRegistrationPage setFirstName(String firstname){
        reporter.info("Set firstname: " + firstname);
        firstNameField.sendKeys(firstname);
        return this;
    }

    public ProductRegistrationPage setLastname(String lastname){
        reporter.info("Set lastname: " + lastname);
        lastNameField.sendKeys(lastname);
        return this;
    }

    public ProductRegistrationPage setAddress(String address){
        reporter.info("Set address: " + address);
        addressField.sendKeys(address);
        return this;
    }

    public ProductRegistrationPage setAddressCont(String address){
        reporter.info("Set address con't: " + address);
        addressContField.sendKeys(address);
        return this;
    }

    public ProductRegistrationPage setCity(String city){
        reporter.info("Set city: " + city);
        cityField.sendKeys(city);
        return this;
    }

    public ProductRegistrationPage setState(String state){
        reporter.info("Set state: " + state);
        stateDropdown.sendKeys(state);
        return this;
    }

    public ProductRegistrationPage setZipcode(String zip){
        reporter.info("Set zip : " + zip);
        zipcodeField.sendKeys(zip);
        return this;
    }

    public ProductRegistrationPage setEmail(String email){
        reporter.info("Set email: " + email);
        emailField.sendKeys(email);
        return this;
    }

    public ProductRegistrationPage setConfirmEmail(String confirmEmail){
        reporter.info("Set confirm email: " + confirmEmail);
        confirmEmailField.sendKeys(confirmEmail);
        return this;
    }

    public ProductRegistrationPage setPhone(String phone){
        reporter.info("Set phone: " + phone);
        phoneField.sendKeys(phone);
        return this;
    }

    public ProductRegistrationPage setDate(String date){
        reporter.info("Set date: " + date);
        dateField.sendKeys(date);
        return this;
    }

    public ProductRegistrationPage setSerialNumber(String serialNumber){
        reporter.info("Set serial number: " + serialNumber);
        serialNumberField.sendKeys(serialNumber);
        return this;
    }

    public ProductRegistrationPage setRetailerName(String retailerName){
        reporter.info("Set retailer name: " + retailerName);
        retailerNameField.sendKeys(retailerName);
        return this;
    }

    public ProductRegistrationPage setRetailerCity(String retailerCity){
        reporter.info("Set retailer City: " + retailerCity);
        retailerCityField.sendKeys(retailerCity);
        return this;
    }

    public ProductRegistrationPage setRetailerState(String retailerState){
        reporter.info("Set retailer State: " + retailerState);
        retailerStateDropdown.sendKeys(retailerState);
        return this;
    }

    public ProductRegistrationPage setBrand(String brand){
        reporter.info("Set brand: " + brand);
        brandField.sendKeys(brand);
        return this;
    }

    public ProductRegistrationPage setSize(String size){
        reporter.info("Set size: " + size);
        sizeField.sendKeys(size);
        return this;
    }

    public ProductRegistrationPage setPrice(String price){
        reporter.info("Set size: " + price);
        priceField.sendKeys(price);
        return this;
    }

    public ProductRegistrationPage clickOnCaptcha(){
        reporter.info("Click on captcha");
        switchToFrame(By.xpath(".//iframe[@role='presentation']"));
        //$(By.xpath("//*[@id=\"recaptcha-anchor\"]")).click();
        switchToDefaultContent();
        return this;
    }

    public ProductRegistrationPage clickOnSubmitButton(){
        reporter.info("Clicking on Submit button");
        submitButton.scrollIntoView(true).click();
        return this;
    }

    public static boolean captchaWarningMessageIsDisplayed() {
        reporter.info("Cheking presence of reCaptcha warning message");
        waitForElement((By.xpath("//*[@id='maincontent']/div[1]")));
        if ( reCaptchaErrorMessage.isDisplayed()){
            return true;
        }
        return false;
    }
}
