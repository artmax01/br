package pages;

public class MattressPlp extends BasePage{

    private static MattressPlp instance;
    public static MattressPlp Instance = (instance != null) ? instance : new MattressPlp();

    public MattressPlp(){
        pageURL = "/Mattresses";
        pageTitle = "Beautyrest Mattresses | Get Quality Sleep | Beautyrest";
    }
}
