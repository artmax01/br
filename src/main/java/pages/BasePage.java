package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {

    static ReporterManager reporter = ReporterManager.Instance;

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public final static String BASE_URL = (FileIO.getConfigProperty("baseUrl"));

    public static String pageURL = "";
    public static String pageTitle = "";

    public static WebDriver driver(){
        return driver.get();
    }

    public void open() {
        reporter.info("Opening the page: " + "\"" + BASE_URL + pageURL + "\"");
        Selenide.open(BASE_URL + pageURL);
        closeWelcomeMessage();
    }

    public static void hover2ItemsAndClick(WebElement a, WebElement b, WebElement c)
    {
        try
        {
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
            ((JavascriptExecutor) driver()).executeScript(mouseOverScript,a);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver()).executeScript(mouseOverScript,b);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver()).executeScript("arguments[0].click();",c);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void hoverTwoItems(WebElement a, WebElement b){
        try
        {
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
            ((JavascriptExecutor) driver()).executeScript(mouseOverScript,a);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver()).executeScript(mouseOverScript,b);
            Thread.sleep(1000);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static WebElement scrollToElement(WebElement element){
        waitForPageToLoad();
        ((JavascriptExecutor) driver()).executeScript("arguments[0].focus(); window.scroll(0, window.scrollY+=300)", element);
        return element;
    }

    public static WebElement scrollIntoView(WebElement element){
        waitForPageToLoad();
        ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView(); window.scroll(0, window.scrollY-=300)", element);
        return element;
    }

    public static AdminPage openAdminPage(){
        reporter.info("Opening Admin page");
        Selenide.open("https://bettersleep:stg-tsleep-@45@staging.tomorrowsleep.com/office45w45");
        return AdminPage.Instance;
    }

    public static WebElement findElement(By element, int... timeout) {
        int timeoutForFindElement = timeout.length < 1 ? (int) Configuration.timeout/5000 : timeout[0];
        waitForPageToLoad();
        try {
            //synchronize();
            (new WebDriverWait(driver(), timeoutForFindElement))
                    .until(visibilityOfElementLocated(element));
            return driver().findElement(element);
        } catch (Exception e) {
            reporter.fail(Tools.getStackTrace(e));
            throw new RuntimeException("Failure finding element");
        }
    }

    public static void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver(), 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    static void waitForElement(By by){
        WebDriverWait wait = new WebDriverWait(driver(), 90);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    static void waitUntilElementContainsText(By by){
        WebDriverWait wait = new WebDriverWait(driver(), 30);
        wait.until((ExpectedCondition<Boolean>) driver -> driver.findElement(by).getText().length() != 0);
    }


    public static void clickWithJS(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void closeWelcomeMessage(){
        waitForPageToLoad();
        reporter.info("Closing welcome message");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ($(".close-button").isDisplayed()) {
            $(".close-button").click();
        }
    }

    public static void switchToFrame(By xpath) {
        reporter.info("Switching to frame: " + xpath.toString());
        driver().switchTo().frame(findElement(xpath));
    }

    public void switchToDefaultContent() {
        reporter.info("Switching to default content");
        driver().switchTo().defaultContent();
    }

}
