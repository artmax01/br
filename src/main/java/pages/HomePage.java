package pages;

public class HomePage extends BasePage{

    private static HomePage instance;
    public static HomePage Instance = (instance != null) ? instance : new HomePage();

    public HomePage(){ pageURL = "/";}

    /** Common elements **/

    //public PageHeader header = PageHeader.Instance;

    /** UI Mappings */




}


