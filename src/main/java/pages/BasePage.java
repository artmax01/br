package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import utils.FileIO;
import utils.ReporterManager;
import utils.Tools;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    static ReporterManager reporter = ReporterManager.Instance;

    public final static String BASE_URL = (FileIO.getConfigProperty("baseUrl"));

    public static String pageURL = "";
    public static String pageTitle = "";

    public void open() {
        reporter.info("Opening the page: " + "\"" + BASE_URL + pageURL + "\"");
        Selenide.open(BASE_URL + pageURL);
    }
}
