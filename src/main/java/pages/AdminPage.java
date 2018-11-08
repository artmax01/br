package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import entities.ItemEntity;
import org.openqa.selenium.By;
import utils.FileIO;

import static com.codeborne.selenide.Selenide.*;

public class AdminPage extends BasePage {

    private static AdminPage instance;
    public static AdminPage Instance = (instance != null) ? instance : new AdminPage();

    public AdminPage(){
        pageURL = FileIO.getConfigProperty("adminUrl");
        pageTitle = "Dashboard / Magento Admin | Tomorrow Sleep";
    }

    /** UI Mappings **/

    public static SelenideElement

    salesTab = $(By.xpath(".//a//span[text()='Sales']")),
    ordersLink = $(By.xpath(".//span[text()='Orders'][1]")),
    searchBox = $("#fulltext"),
    orderRow = $("tr.data-row"),
    viewLink = $(By.xpath(".//a[text()='View']")),

    orderTitle = $(".product-title"),
    orderPrice = $("span.price"),
    cancelButton = $(By.xpath(".//span[text()='Cancel']")),
    submitCancelationButton = $(".action-primary.action-accept"),
    successMessage = $(By.xpath(".//div[@data-ui-id='messages-message-success']"));


    /** Page Methods **/

    public AdminPage doLogin(){
        reporter.info("Logging into admin panel");
        $("#username").sendKeys("auto.qa");
        $("#login").sendKeys("Qwerty123");
        $(".action-login.action-primary").click();
        waitForPageToLoad();

        if ( $(".admin__field-complex-text").isDisplayed()){
            $x(".//span[text()='Next >']").click();
            $x(".//span[text()='Next >']").click();
            $x(".//span[text()='Next >']").click();
            $x(".//span[text()='Done']").click();
        }

        return this;
    }

    public AdminPage navigateToOrders(){
        reporter.info("Opening Orders page in Admin panel");
        salesTab.click();
        ordersLink.click();
        waitForPageToLoad();
        $("div.spinner").shouldNotBe(Condition.visible);
        return this;
    }

    public boolean orderIsDisplayedOnOrdersPage(String orderNumber){
        waitForPageToLoad();
        reporter.info("Verifying that order is displayed on Orders page");
        searchBox.clear();
        searchBox.sendKeys(orderNumber);
        searchBox.pressEnter();
        waitForPageToLoad();

        if (orderRow.isDisplayed() && orderRow.has(Condition.text(orderNumber))){
            return true;
        }
        return false;
    }

    public AdminPage viewOrderDetails(){
        reporter.info("Opening products details page");
        viewLink.click();
        waitForPageToLoad();
        return this;
    }

    public boolean orderContainsProduct(ItemEntity item){
        reporter.info("Checking that product is displayed on order details page");
        if (orderTitle.has(Condition.text(item.getTitle()))){
            return true;
        }
        return false;
    }

    public AdminPage clickOnCancelButton(){
        reporter.info("Cancelling order");
        cancelButton.click();
        submitCancelationButton.click();
        return this;
    }

    public boolean orderHasBeenCanceled(){
        waitForPageToLoad();
        if (successMessage.isDisplayed() && successMessage.getText().contains("You canceled the order.")){
            return true;
        }
        return false;
    }

}
