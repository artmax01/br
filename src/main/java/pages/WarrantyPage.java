package pages;


import com.codeborne.selenide.SelenideElement;
import entities.UserEntity;
import org.openqa.selenium.By;
import utils.Tools;

import static com.codeborne.selenide.Selenide.$;


public class WarrantyPage extends BasePage {


    private static WarrantyPage instance;
    public static WarrantyPage Instance = (instance != null) ? instance : new WarrantyPage();


    /** UI Mapping **/

    public static SelenideElement

            initialClimeButton = $(By.xpath("//a[@class='btn btn-black-white']")),
            firstNameField = $(By.xpath(".//input[@placeholder='First Name*']")),
            lastNameField = $(By.xpath(".//input[@placeholder='Last Name*']")),
            phoneNumberField = $(By.xpath(".//input[@placeholder='Phone Number*']")),
            cityField = $(By.xpath(".//input[@placeholder='City*']")),
            stateDropdown = $(By.xpath(".//select[@class='required-entry']")),
            zipCodeField = $(By.xpath(".//input[@placeholder='Zip*']")),
            emailField = $(By.xpath(".//input[@placeholder='Email*']")),
            alternativePhoneField = $(By.xpath(".//input[@placeholder='Alternate Phone Number']")),
            storeNameField = $(By.xpath(".//input[@placeholder='Store Name']")),
            brandField = $(By.xpath(".//input[@placeholder='Brand']")),
            lawTagField = $(By.xpath(".//input[@placeholder='Law Tag Information']")),
            yearPurchasedField = $(By.xpath(".//select[@class=\"required-entry \"]")),
            previousNumberField = $(By.xpath(".//input[@placeholder='Previously Submitted Claim Number']")),
            textAreaField = $(By.xpath(".//textarea[@class = 'input-text   validate-min-max-number rf-size-small']")),
            checkboxJoinTo = $(By.xpath(".//input[@type='checkbox']")),
            submitButtom  = $(By.xpath(".//button[@type='submit']")),
            capchaMessage = $(By.xpath(".//div[@data-bind='html: message.text']"));



    /** Page Methods **/

    public static void openClaimePage(){
        reporter.info("Go to Claime age");
        waitForPageToLoad();
        initialClimeButton.click();
    }

    public WarrantyPage FillFields(UserEntity user){
        waitForPageToLoad();
        this.setFirstName(user.getFirstname())
                .setLastname(user.getLastname())
                .setPhoneNumber(user.getPhone())
                .setAlternativePhoneNumber("356456595")
                .setCity(user.getCity())
                .selectState(user.getState())
                .setZipCode(user.getZipcode())
                .selectState(user.getState())
                .setEmail()
                .setStoreName("Macy`s")
                .setBrand("Silver")
                .setLawTag("Lorem ipsum")
                .selectYearPurchased("2016")
                .setPreviouslyClaimNumber("235695945")
                .setTextArea("Lorem ipsum");

        verifyIfCheckboxChecked();
        clickOnCSubmitButton();


        waitForPageToLoad();
        return this;
    }

            /**Required Fields**/

    public WarrantyPage setFirstName(String firstname){
        reporter.info("Set firstname: " + firstname);
        firstNameField.sendKeys(firstname);
        return this;
    }

    public WarrantyPage setLastname(String lastname){
        reporter.info("Set lastname: " + lastname);
        lastNameField.sendKeys(lastname);
        return this;
    }
    public WarrantyPage setPhoneNumber(String phone){
        reporter.info("Set phone: " + phone);
        phoneNumberField.sendKeys(phone);
        return this;
    }

    public WarrantyPage setCity(String city){
        reporter.info("Set city: " + city);
        cityField.sendKeys(city);
        return this;
    }
    public WarrantyPage selectState(String state){
        reporter.info("Select state: " + state);
        stateDropdown.selectOptionContainingText(state);
        return this;
    }

    public WarrantyPage setZipCode(String zip){
        reporter.info("Set zip: " + zip);
        zipCodeField.sendKeys(zip);
        return this;
    }

    public WarrantyPage setEmail(){
        String email = "beautyrest.autotest" + Tools.getRandomUserEmail();
        reporter.info("Set email to: " + email);
        emailField.sendKeys(email);
        return this;
    }

            /**Not Required Fields**/

    public WarrantyPage setAlternativePhoneNumber(String alternativePhone){
        reporter.info("Set alternative phone: " + alternativePhone);
        alternativePhoneField.sendKeys(alternativePhone);
        return this;
    }

    public WarrantyPage setStoreName (String storeName){
        reporter.info("Set store name: " + storeName);
        storeNameField.sendKeys(storeName);
        return this;
    }

    public WarrantyPage setBrand(String brand){
        reporter.info("Set brand: " + brand);
        brandField.sendKeys(brand);
        return this;
    }

    public WarrantyPage setLawTag(String lawTag){
        reporter.info("Set law tag information: " + lawTag);
        lawTagField.sendKeys(lawTag);
        return this;
    }

    public WarrantyPage selectYearPurchased(String year){
        reporter.info("Select year: " + year);
       yearPurchasedField.selectOptionContainingText(year);
        return this;
    }

    public WarrantyPage setPreviouslyClaimNumber (String previousNumber){
        reporter.info("Set previously submitted claim number: " + previousNumber);
        previousNumberField.sendKeys(previousNumber);
        return this;
    }

    public WarrantyPage setTextArea (String text){
        reporter.info("Set text area: " + text);
       // textAreaField.scrollIntoView(true);
        textAreaField.sendKeys(text);
        return this;
    }

    public WarrantyPage clickOnCSubmitButton(){
        reporter.info("Clicking on \"Submit\" button");
        submitButtom.scrollIntoView(true);
        submitButtom.click();
        return this;
    }


    /**Verify if checkbox is checked**/

    public static void  verifyIfCheckboxChecked (){
        reporter.info("Verify checkbox");
        if ( ! checkboxJoinTo.isSelected()) {
            reporter.info("Checkbox is not checked. Click on checkbox");
            checkboxJoinTo.click();
        }
    }


    /**Verify Captcha message displaying**/

    public boolean checkCaptchaMessage(){
        reporter.info("Check captcha message");
        if (capchaMessage.isDisplayed()){
            return true;
        }
        return false;
    }


}

