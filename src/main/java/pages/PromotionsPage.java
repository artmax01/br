package pages;

public class PromotionsPage extends BasePage{

    private static PromotionsPage instance;
    public static PromotionsPage Instance = (instance != null) ? instance : new PromotionsPage();

    public PromotionsPage(){
        pageURL = "https://www.beautyrest.com/Memorial-Day-Mattress-Sale";
        pageTitle = "Memorial Day Mattress Sale 2018 | Beautyrest";
    }
}
