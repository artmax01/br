package pages;

public class BlogPage extends BasePage{

    private static BlogPage instance;
    public static BlogPage Instance = (instance != null) ? instance : new BlogPage();

    public BlogPage(){
        pageURL = "https://www.beautyrest.com/Blog";
        pageTitle = "Under The Covers Blog | Mattress Research | Beautyrest";
    }
}
