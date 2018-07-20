package pages;

public class CheckoutPage extends BasePage{

    private static CheckoutPage instance;
    public static CheckoutPage Instance = (instance != null) ? instance : new CheckoutPage();

    public CheckoutPage(){
        pageURL = "checkout/";
        pageTitle = "Checkout";
    }
}
