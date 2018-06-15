package utils;

import com.codeborne.selenide.Configuration;
import org.monte.screenrecorder.ScreenRecorder;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.io.IOException;
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

        reporter.info("Starting driver");

        ThreadLocal<ScreenRecorder> recorder = new ThreadLocal<ScreenRecorder>();
    }

    @BeforeClass
    public static void setup() throws IOException, AWTException {

        //Selenide configuration based on .properties file

        Configuration.timeout = 10000;
        Configuration.browser = FileIO.getConfigProperty("Driver");
        Configuration.baseUrl = FileIO.getConfigProperty("baseUrl");
        Configuration.captureJavascriptErrors = true;
        Configuration.driverManagerEnabled = true;
        //Configuration.headless = true;
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.startMaximized = true;
    }

    @AfterMethod
    public void endTest(ITestResult testResult){

        // close reporter
        reporter.stopReporting(testResult);
    }

    @AfterSuite(alwaysRun = true)
    public void flushReporter() {
        reporter.closeReporter();
    }
}
