package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.monte.screenrecorder.ScreenRecorder;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BasePage;

import java.lang.reflect.Method;


public class BaseTest{

    ReporterManager reporter;
    public static ThreadLocal<ScreenRecorder> recorder = new ThreadLocal<ScreenRecorder>();

    @BeforeMethod
    public void beforeWithData(Object[] data, Method method) {

        //init reporter
        reporter = ReporterManager.Instance;
        reporter.startReporting(method, data);

        //set reporter to product sync
        ProductSync.reporter = reporter;

        //init threadlocal driver
        try {
            Configuration.timeout = 40000;
            Configuration.collectionsTimeout = 40000;
            Configuration.browser = FileIO.getConfigProperty("Driver");
            Configuration.baseUrl = FileIO.getConfigProperty("baseUrl");
            //Configuration.captureJavascriptErrors = true;
            //Configuration.driverManagerEnabled = true;
            Configuration.headless = false;
            Configuration.screenshots = false;
            Configuration.savePageSource = false;
            //Configuration.startMaximized = true;
            reporter.info("Driver creation");
            WebDriverRunner.setWebDriver(DriverProvider.getDriver());
            BasePage.driver.set(DriverProvider.getDriver());
            //reporter.info("Driver created " + BasePage.driver.get().hashCode());
        }catch (Exception e){
            reporter.fail("Before test failure during Driver creation", e);
            reporter.stopReporting();
            reporter.closeReporter();
            Assert.fail();
        }
    }

    @BeforeTest
    public void beforeTest(){

    }

    @BeforeClass
    public static void setup(){


    }

    @AfterMethod
    public void endTest(ITestResult testResult){

        // close reporter
        reporter.stopReporting(testResult);
        //close driver
        try {
            BasePage.driver().quit();
        }catch (Exception ignore){

        }
        DriverProvider.closeDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void flushReporter() {
        reporter.closeReporter();
    }
}
