package pages;

public class AdjustableBasePlp extends BasePage{

    private static AdjustableBasePlp instance;
    public static AdjustableBasePlp Instance = (instance != null) ? instance : new AdjustableBasePlp();

    public AdjustableBasePlp(){
        pageURL = "https://www.beautyrest.com/Smartmotion";
        pageTitle = "SmartMotion™ Bases | Optimized Sleep | Beautyrest";
    }
}
