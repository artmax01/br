package pages;

public class MattressPage extends BasePage{

    private static MattressPage instance;
    public static MattressPage Instance = (instance != null) ? instance : new MattressPage();

    public MattressPage() {pageURL = "/mattresses";}






    public class Black{

        public Black() { pageURL = "/black" ;}
    }


}
