package pages;

public class PromotionsPage extends BasePage{

    private static PromotionsPage instance;
    public static PromotionsPage Instance = (instance != null) ? instance : new PromotionsPage();

    public PromotionsPage(){
        pageURL = "/sale";
        pageTitle = "BR Promotions";
    }
}
