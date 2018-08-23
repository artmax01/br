package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage{

    private static HomePage instance;
    public static HomePage Instance = (instance != null) ? instance : new HomePage();

    public HomePage(){ pageURL = "/";}

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */




}


