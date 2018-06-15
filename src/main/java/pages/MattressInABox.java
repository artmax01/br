package pages;

public class MattressInABox extends BasePage{

    private static MattressInABox instance;
    public static MattressInABox Instance = (instance != null) ? instance : new MattressInABox();

    public MattressInABox(){
        pageURL = "https://www.beautyrest.com/Mattress-In-A-Box";
        pageTitle = "Mattress In A Box | Beautyrest";
    }
}
