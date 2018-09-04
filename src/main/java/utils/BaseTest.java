package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.BasicAuthUrl;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BasePage;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Level;


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
            //Configuration.browser = FileIO.getConfigProperty("Driver");
            Configuration.baseUrl = FileIO.getConfigProperty("baseUrl");
            //Configuration.captureJavascriptErrors = true;
            //Configuration.driverManagerEnabled = true;
            //Configuration.headless = true;
            Configuration.screenshots = false;
            Configuration.savePageSource = false;
            //Configuration.startMaximized = true;
            reporter.info("Driver creation");
            WebDriverRunner.setWebDriver(DriverProvider.getDriver());
            //BasePage.driver.set(DriverProvider.getDriver());
            //reporter.info("Driver created " + BasePage.driver.get().hashCode());
        }catch (Exception e){
            reporter.fail("Before test failure during Driver creation", e);
            reporter.stopReporting();
            reporter.closeReporter();
            Assert.fail();
        }

        ThreadLocal<ScreenRecorder> recorder = new ThreadLocal<ScreenRecorder>();

        //Selenide configuration based on .properties file



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
        BasePage.driver().quit();
        DriverProvider.closeDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void flushReporter() {
        reporter.closeReporter();
    }
}
