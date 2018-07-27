package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.FileIO;
import utils.ReporterManager;

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

    public static void click(SelenideElement element){
        element.scrollIntoView(true)
                .click();
    }

    public static void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
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

}
