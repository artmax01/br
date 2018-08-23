package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PageFooter extends BasePage {

    private static PageFooter instance;
    public static PageFooter Instance = (instance != null) ? instance : new PageFooter();

    /** UI Mapping **/

    static SelenideElement FAQ = $(By.partialLinkText("FAQs"));


    /** Page Methods **/

    public static FaqPage openFAQ(){
        reporter.info("Opening FAQ Page");
        FAQ.scrollIntoView(true)
                .click();
        return FaqPage.Instance;
    }
}
