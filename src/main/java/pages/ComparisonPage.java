package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.getElement;
import static com.codeborne.selenide.Selenide.getElements;

public class ComparisonPage extends BasePage {

    private static ComparisonPage instance;
    public static ComparisonPage Instance = (instance != null) ? instance : new ComparisonPage();

    public ComparisonPage(){
        pageURL = "/catalog/product_compare/index/";
        pageTitle = "Products Comparison List - Magento Enterprise Edition";
    }

    public static boolean checkComparisonTable(){
        reporter.info("Checking comparison table");
        ElementsCollection rows = getElements(By.cssSelector("tr"));
        ElementsCollection td = getElements(By.cssSelector("td"));
        if (rows.size() == 6 && td.size() == 15){
            reporter.info("Comparison table is displayed");
            return true;
        }
        return false;
    }
}


