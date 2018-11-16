package pages;

public class BlogPage extends BasePage{

    private static BlogPage instance;
    public static BlogPage Instance = (instance != null) ? instance : new BlogPage();

    public BlogPage(){
        pageURL = "/blog";
        pageTitle = "Beautyrest Blog – Know how to fight sleep deprivation? Beautyrest does";
    }
}
