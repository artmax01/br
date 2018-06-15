package pages;

public class StoreLocatorPage extends BasePage{

    private static StoreLocatorPage instance;
    public static StoreLocatorPage Instance = (instance != null) ? instance : new StoreLocatorPage();

    public StoreLocatorPage(){
        pageURL = "https://www.beautyrest.com/Find-A-Store";
        pageTitle = "Find a Mattress Store Near You | Beautyrest";
    }
}
