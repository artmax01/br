package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import entities.UserEntity;
import org.openqa.selenium.By;
import utils.FileIO;
import utils.Tools;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends BasePage{

    private static CheckoutPage instance;
    public static CheckoutPage Instance = (instance != null) ? instance : new CheckoutPage();

    public CheckoutPage(){
        pageURL = "checkout/";
        pageTitle = "Checkout";
    }

    /** UI Mapping **/

    public static SelenideElement

    emailField = $("#customer-email"),
    firstNameField = $(By.name("firstname")),
    lastNameField = $(By.name("lastname")),
    streetField = $(By.name("street[0]")),
    cityField = $(By.name("city")),
    phoneField = $(By.name("telephone")),
    zipcodeField = $(By.name("postcode")),
    stateDropdown = $(By.name("region_id")),
    freeShippingRadio = $(By.xpath(".//label[@for='radio'][1]")),
    continueButton = $(By.xpath(".//button[@class='button action continue primary']")),

    billingSameOption = $(By.xpath(".//span[text()='Billing same as shipping']")),
    creditcardOption = $(By.xpath(".//span[text()='Credit Card']")),
    paypalOption = $(By.xpath(".//span[text()='PayPal (Braintree)']")),
    klarnaOption = $(By.xpath(".//input[@class='radio' and @id='klarna_pay_over_time']/..")),

    orderNumber = $("p.order-number span"),
    continueShoppingButton = $("a.action.primary.continue");


    /** Page Methods **/

    public CheckoutPage selectBillingSameAsShippingOption(){
        waitForPageToLoad();
        reporter.info("Select billing address same as shipping");
        billingSameOption.click();
        return this;
    }

    public CheckoutPage payWithCreditCard() {
        selectBillingSameAsShippingOption();
        waitForPageToLoad();

        reporter.info("Selecting Credit Card payment option");
        creditcardOption.scrollIntoView(true);
        creditcardOption.shouldBe(Condition.visible)
            .click();

        setCreditcardNumber();
        setExpMonth();
        setExpYear();
        setCVV();

        if ( $(".message.message-error.error").isDisplayed()){
            reporter.pass("Expected to recieve error message");
        }

//        ElementsCollection buttons = getElements(By.cssSelector("button.action.primary.checkout"));
//        buttons.filterBy(Condition.visible).exclude(Condition.disabled).first().click();

        return this;
    }

    public void setCreditcardNumber() {
        reporter.info("Set credit card to: 4111111111111111");
        switchToFrame(By.xpath(".//iframe[@id='braintree-hosted-field-number']"));
        $("#credit-card-number").sendKeys("4111111111111111");
        switchToDefaultContent();
    }

    public void setExpMonth() {
        reporter.info("Set expiration date to: 12/21");
        switchToFrame(By.xpath(".//iframe[@id='braintree-hosted-field-expirationMonth']"));
        $("#expiration-month").sendKeys("12");
        switchToDefaultContent();
    }

    public void setExpYear() {
        switchToFrame(By.xpath(".//iframe[@id='braintree-hosted-field-expirationYear']"));
        $("#expiration-year").sendKeys("21");
        switchToDefaultContent();
    }

    public void setCVV() {
        reporter.info("Set CVV to: 111");
        switchToFrame(By.xpath(".//iframe[@id='braintree-hosted-field-cvv']"));
        $("#cvv").sendKeys("111");

        if (FileIO.getConfigProperty("EnvType").equals("Near_prod")){
            reporter.pass("Expected to stop");
            reporter.closeTest();

        }

        $("#cvv").pressEnter();
        switchToDefaultContent();
    }

    public String getOrderNumber(){
        waitForPageToLoad();
        String number = orderNumber.getText();
        reporter.info("Order number is: " + number);
        return number;
    }

    public CheckoutPage populateShippingFields(UserEntity user){
        waitForPageToLoad();
        this.setEmail()
                .setFirstName(user.getFirstname())
                .setLastname(user.getLastname())
                .setStreet(user.getStreet())
                .setCity(user.getCity())
                .setPhone(user.getPhone())
                .setZipcode(user.getZipcode())
                .selectState(user.getState());

        waitForPageToLoad();
        selectFreeShipping();
        clickOnContinueButton();

        return this;
    }

    public boolean orderHasBeenPlaced(){
        waitForPageToLoad();
        orderNumber.shouldBe(Condition.visible);
        if (orderNumber.isDisplayed() && getOrderNumber() != null
                && continueShoppingButton.isDisplayed()){
            return true;
        }
        return false;
    }

    public CheckoutPage setEmail(){
        String email = "beautyrest.autotest" + Tools.getRandomUserEmail();
        reporter.info("Set email to: " + email);
        emailField.sendKeys(email);
        return this;
    }

    public CheckoutPage setFirstName(String firstname){
        reporter.info("Set firstname: " + firstname);
        firstNameField.sendKeys(firstname);
        return this;
    }

    public CheckoutPage setLastname(String lastname){
        reporter.info("Set lastname: " + lastname);
        lastNameField.sendKeys(lastname);
        return this;
    }

    public CheckoutPage setStreet(String street){
        reporter.info("Set street: " + street);
        streetField.sendKeys(street);
        return this;
    }

    public CheckoutPage setCity(String city){
        reporter.info("Set city: " + city);
        cityField.sendKeys(city);
        return this;
    }

    public CheckoutPage setPhone(String phone){
        reporter.info("Set phone: " + phone);
        phoneField.sendKeys(phone);
        return this;
    }

    public CheckoutPage setZipcode(String zip){
        reporter.info("Set zip: " + zip);
        zipcodeField.sendKeys(zip);
        return this;
    }

    public CheckoutPage selectState(String state){
        reporter.info("Select state: " + state);
        stateDropdown.selectOptionContainingText(state);
        return this;
    }

    public CheckoutPage selectFreeShipping(){
        reporter.info("Selecting free shipping option");
        freeShippingRadio.click();
        return this;
    }

    public CheckoutPage clickOnContinueButton(){
        reporter.info("Clicking on \"Continue\" button");
        continueButton.click();
        return this;
    }
}
