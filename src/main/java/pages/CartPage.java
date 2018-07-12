package pages;

public class CartPage extends BasePage{

    private static CartPage instance;
    public static CartPage Instance = (instance != null) ? instance : new CartPage();

    public CartPage(){
        pageURL = "checkout/cart/";
        pageTitle = "Shopping Cart";
    }

    //* UI mappings *//

}
