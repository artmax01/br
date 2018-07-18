package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import entities.ItemEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Tools;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class PageHeader extends BasePage {

    private static PageHeader instance;
    public static PageHeader Instance = (instance != null) ? instance : new PageHeader();

    /** UI Mapping for Header **/

    public static SelenideElement

    products = $(By.xpath("(//A[@class='nav-link'])[1]")),
    mattresses = $(By.xpath("//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='Mattresses']")),
    mattresInBox = $(By.xpath("//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='Mattress-in-a-box']")),
    adjustableBase = $(By.xpath("//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='Adjustable Bases']")),
    accessories = $(By.xpath("//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='Accessories']")),
    promotions = $(By.xpath("//a[@class='nav-link'][text()='Promotions']")),
    blog = $(By.xpath("//a[@class='nav-link'][text()='Blog']")),
    findAStore = $("i.nav-link-icon").parent(),

    /** Minicart elements **/
    minicartIcon = $("a.action.showcart"),
    minicartItems = $("div.product-item-details"),
    minicartItemName = $("strong.product-item-name"),
    minicartQty = $x(".//input[@disabled='disabled']"),
    minicartPrice = $("span.price"),
    minicartItemDetails = $("dl.product.options.list span"),
    closeMinicart = $("button.action.close"),
    deleteItemFromMinicartButton = $("a.action.delete"),
    confirmItemDeletionButton = $("button.action-primary.action-accept");




    /** Header Navigation methods **/
    public static MattressPlp openMattressByType(String type){
        reporter.info("Opening " + type + " matress page");
        products.hover();
        mattresses.hover();
        // Black, Silver, Platinum
        getElement(By.xpath("//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='" + type + "']")).click();
        return MattressPlp.Instance;
    }

    public static MattressPlp openMattressesPlp(){
        reporter.info("Opening Mattresses PLP");
        products.hover();
        mattresses.click();
        return MattressPlp.Instance;
    }

    public static AccessoryPage openAccessoryByType(String type){
        reporter.info("Opening " + type + " accessory page");
        products.hover();
        accessories.hover();
        // Sleeptracker, Pillows, Covers, Pet-Beds
        getElement(By.xpath("//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='" + type + "']")).click();
        return AccessoryPage.Instance;
    }

    public static AccessoryPlp openAccessoryPlp(){
        reporter.info("Opening Accessories PLP");
        products.hover();
        accessories.click();
        return AccessoryPlp.Instance;
    }

    public static MattressInABoxPlp openMattressInABox(){
        reporter.info("Opening Mattress-In-A-Box Page");
        products.hover();
        mattresInBox.click();
        return MattressInABoxPlp.Instance;
    }

    public static AdjustableBasePlp openAdjustableBase(){
        reporter.info("Opening Adjustable Base Page");
        products.hover();
        adjustableBase.click();
        return AdjustableBasePlp.Instance;
    }

    public static PromotionsPage openPromotionsPage(){
        reporter.info("Opening Promotions Page");
        promotions.click();
        return PromotionsPage.Instance;
    }

    public static BlogPage openBlogPage(){
        reporter.info("Opening Blog Page");
        blog.click();
        return BlogPage.Instance;
    }

    public static StoreLocatorPage openStoreLocator(){
        reporter.info("Opening Store Locator Page");
        findAStore.click();
        return StoreLocatorPage.Instance;
    }

    /** Minicart Methods */

    public PageHeader openCart() {
        reporter.info("Open Cart (Click on Show cart button)");
        minicartIcon.click();
        return this;
    }

    public ArrayList<ItemEntity> getAllCartItems() {
        ArrayList<ItemEntity> result = new ArrayList<>();

        reporter.info("Getting items in minicart");
        openCart();

        ElementsCollection cartItemsList = getElements((By) minicartItems);
        for (WebElement cartItem : cartItemsList) {
            ItemEntity currentItem = new ItemEntity();

            currentItem.setTitle(cartItem.findElement((By) minicartItemName).getText());
            currentItem.setQty(Integer.valueOf(cartItem.findElement((By) minicartQty).getAttribute("data-item-qty")));
            currentItem.setPrice(Tools.convertStringPriceToFloat(cartItem.findElement((By) minicartPrice).getText()));
            currentItem.setSize("");
            currentItem.setType("");

            List<WebElement> details = cartItem.findElements((By) minicartItemDetails);

            for (WebElement elem : details) {
                String value = elem.getText();
                if (value.contains("(") && value.contains(")"))
                    currentItem.setSize(value);
                else
                    currentItem.setType(value);
            }

            result.add(currentItem);

        }
        if (cartItemsList.size() == 0) {
            reporter.info("No Cart items were found");
            //Assert.fail("No Cart items were found");
        }

        return result;
    }

    public boolean itemWasFoundInMiniCart(ItemEntity item) {
        ArrayList<ItemEntity> items = getAllCartItems();
        reporter.info("Expected item: " + item.toString());
        return items.stream()
                .filter(cur -> item.getTitle().equals(cur.getTitle()))
                .filter(cur -> item.getQty() == cur.getQty())
                .filter(cur -> item.getPrice() == cur.getPrice())
                .filter(cur -> cur.getType().contains(item.getType()))
                .filter(cur -> cur.getSize().contains(item.getSize())).count() > 0;
    }

    public void clickOnDeleteProductButton(ItemEntity item) {
        closeCart();
        openCart();
        ElementsCollection cartItemsList = getElements((By) minicartItems);
        for (int i = 0; i < cartItemsList.size(); i++) {
            WebElement cartItem = cartItemsList.get(i);
            if (cartItem.findElement((By) minicartItemName).getText().contains(item.getTitle()) &&
                    Tools.convertStringPriceToFloat(cartItem.findElement((By) minicartPrice).getText()) == item.getPrice() &&
                    cartItem.findElement((By) minicartQty).getAttribute("data-item-qty").equals(String.valueOf(item.getQty()))) {
                cartItem.findElement((By) deleteItemFromMinicartButton).click();

                confirmItemDeletionButton.click();
            }
        }
        reporter.info("Click on Delete Cart button");

    }

    public int getCountOfProductsOnMinicartIcon() {
        reporter.info("Getting count of goods from cart's item");
        String[] result = minicartIcon.getText().split("\n");
        reporter.info("Items on cart icon are equal to " + Integer.valueOf(result[0]));
        return Integer.valueOf(result[0]);
    }

    public int getCountOfGoodsInMinicart() {
        reporter.info("Counting sum of goods in the cart");
        openCart();
        int count = 0;
        ElementsCollection cartItemsList = getElements((By) minicartItems);
        for (int i = 0; i < cartItemsList.size(); i++) {
            WebElement cartItem = cartItemsList.get(i);
            count = count + Integer.valueOf(cartItem.findElement((By) minicartQty).getAttribute("data-item-qty"));
        }
        reporter.info("Sum of goods in cart equals to " + count);
        closeCart();
        return count;
    }

    public void closeCart() {
        if (closeMinicart.isDisplayed()) {
            reporter.info("Closing cart");
            closeMinicart.click();
        }
    }

}
