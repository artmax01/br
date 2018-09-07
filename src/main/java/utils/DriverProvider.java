package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.logging.Level;

public class DriverProvider {

    static String OS_EXTENTION = (System.getProperty("os.name").toLowerCase().contains("win")) ? ".exe" :
            (System.getProperty("os.name").toLowerCase().contains("mac")) ? "_mac" :
                    "_linux";
    static String FIREFOX_PATH = "drivers/geckodriver" + OS_EXTENTION;
    static String CHROME_PATH = "drivers/chromedriver" + OS_EXTENTION;

    //private static WebDriver instance;
    public static ThreadLocal<WebDriver> instance = new ThreadLocal<WebDriver>();

    static String BROWSER_TYPE;

    static public FirefoxDriver getFirefox() {

        System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);

        DesiredCapabilities caps = DesiredCapabilities.firefox();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        return new FirefoxDriver(caps);

    }

    static public ChromeDriver getChrome(){

        System.setProperty("webdriver.chrome.driver", CHROME_PATH);

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.OFF);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--start-fullscreen");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");

        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return new ChromeDriver(caps);

    }


    public static WebDriver getDriver() throws MalformedURLException {
        //if (instance == null)
        if (instance.get() == null)
            if (getCurrentBrowserName().equals(BrowserType.FIREFOX)) {
                //instance = getFirefox();
                instance.set(getFirefox());
            }
            else if (getCurrentBrowserName().equals(BrowserType.CHROME)){
                //instance = getChrome();
                instance.set(getChrome());
            }
        //return instance;
        return instance.get();
    }

    public static void closeDriver(){
        //instance.quit();
        instance.get().quit();
        //instance = null;
        instance.set(null);
    }

    public static String getCurrentBrowserName() {
        if (BROWSER_TYPE == null)
            if (FileIO.getConfigProperty("Driver").equals("firefox"))
                BROWSER_TYPE = BrowserType.FIREFOX;
            else if (FileIO.getConfigProperty("Driver").equals("chrome"))
                BROWSER_TYPE = BrowserType.CHROME;
        return BROWSER_TYPE;
    }
}
