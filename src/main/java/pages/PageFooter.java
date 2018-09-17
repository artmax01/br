package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static pages.WarrantyPage.Instance;

public class PageFooter extends BasePage {

    private static PageFooter instance;
    public static PageFooter Instance = (instance != null) ? instance : new PageFooter();

    /** UI Mapping **/

    static SelenideElement
            FAQ = $(By.partialLinkText("FAQs")),
            ProductRegistration = $(By.partialLinkText("Product Registration")),
            ContactUs = $(By.partialLinkText("Contact Us")),
            Warranties = $(By.partialLinkText("Warranties"));


    /** Page Methods **/

    public static FaqPage openFAQ(){
        reporter.info("Opening FAQ Page");
        FAQ.scrollIntoView(true)
                .click();
        return FaqPage.Instance;
    }

    public static ProductRegistrationPage openProductRegistration(){
        reporter.info("Opening Product Registration Page");
        ProductRegistration.scrollIntoView(true)
                .click();
        return ProductRegistrationPage.Instance;
    }

    public static ContactUsPage openContactUs() {
        reporter.info("Opening Contact Us Page");
        ContactUs.scrollIntoView(true).click();
        return ContactUsPage.Instance;
    }

    public static WarrantyPage openWarranty(){
        reporter.info("Opening Warranty Page");
        Warranties.scrollIntoView(true)
                .click();
        return WarrantyPage.Instance;
    }
}
