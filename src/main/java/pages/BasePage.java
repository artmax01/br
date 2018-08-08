package pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.FileIO;
import utils.ReporterManager;
import utils.Tools;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    static ReporterManager reporter = ReporterManager.Instance;

    public final static String BASE_URL = (FileIO.getConfigProperty("baseUrl"));

    public static String pageURL = "";
    public static String pageTitle = "";

    public void open() {
        reporter.info("Opening the page: " + "\"" + BASE_URL + pageURL + "\"");
        Selenide.open(BASE_URL + pageURL);
        closeWelcomeMessage();
    }

    public static AdminPage openAdminPage(){
        reporter.info("Opening Admin page");
        Selenide.open("https://staging.tomorrowsleep.com/office45w45/");
        return AdminPage.Instance;
    }

    public static void click(SelenideElement element){
        element.scrollIntoView(true)
                .click();
    }

    public static WebElement findElement(By element, int... timeout) {
        int timeoutForFindElement = timeout.length < 1 ? (int) Configuration.timeout : timeout[0];
        waitForPageToLoad();
        try {
            //synchronize();
            (new WebDriverWait(WebDriverRunner.getWebDriver(), timeoutForFindElement))
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
            return WebDriverRunner.getWebDriver().findElement(element);
        } catch (Exception e) {
            reporter.fail(Tools.getStackTrace(e));
            throw new RuntimeException("Failure finding element");
        }
    }

    public static void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void closeWelcomeMessage(){
        reporter.info("Closing welcome message");
        $(".close-button").shouldBe(Condition.visible).click();
    }

    public static void switchToFrame(By xpath) {
        reporter.info("Switching to frame: " + xpath.toString());
        WebDriverRunner.getWebDriver().switchTo().frame(findElement(xpath));
    }

    public void switchToDefaultContent() {
        reporter.info("Switching to default content");
        WebDriverRunner.getWebDriver().switchTo().defaultContent();
    }

}
