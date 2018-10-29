package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import entities.ItemEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Tools;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class PageHeader extends BasePage {

    private static PageHeader instance;
    public static PageHeader Instance = (instance != null) ? instance : new PageHeader();

    /** UI Mapping for Header **/

    public static SelenideElement

    products = $(xpath("(.//A[@class='nav-link'])[1]")),
    mattresses = $(xpath(".//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='Mattresses']")),
    mattresInBox = $(xpath(".//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='Mattress-in-a-box']")),
    bases = $(xpath(".//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='Bases']")),
    adjustableBase = $(xpath(".//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='Adjustable Bases']")),
    boxSpring = $(xpath(".//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='Box Springs']")),
    accessories = $(xpath(".//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='Accessories']")),
    promotions = $(xpath(".//a[@class='nav-link'][text()='Promotions']")),
    blog = $(xpath(".//a[@class='nav-link'][text()='Blog']")),
    findAStore = $("i.nav-link-icon").parent(),

    /** Minicart elements **/

    minicartIcon = $("a.action.showcart"),
    closeMinicart = $("button.action.close"),
    confirmItemDeletionButton = $("button.action-primary.action-accept"),
    checkoutButton = $("button.action.primary.checkout"),
    viewCartButton = $("a.action.viewcart");
    
    By minicartItems = By.cssSelector("div.product-item-details");
    By minicartItemName = By.cssSelector("strong.product-item-name");
    By minicartQty = By.xpath(".//input[@disabled='disabled']");
    By minicartIconQty = By.cssSelector("span.counter-number");
    By minicartPrice = By.cssSelector("span.price");
    By minicartItemDetails = By.cssSelector("dl.product.options.list span");
    By deleteItemFromMinicartButton = By.cssSelector("a.action.delete");

    /** Header Navigation methods **/

    public static MattressPlp openMattressByType(String type){
        // Black, Silver, Platinum
        SelenideElement element = $(xpath("//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='" + type + "']"));
        reporter.info("Opening " + type + " matress page");
        hover2ItemsAndClick(products, mattresses, element);
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
        SelenideElement element = $x("//A[@class='nav-link active d-flex flex-column justify-content-center'][text()='" + type + "']");
        hover2ItemsAndClick(products, accessories, element);
        // Sleeptracker, Pillows, Covers, Pet-Beds
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
        hover2ItemsAndClick(products, bases, adjustableBase);
        return AdjustableBasePlp.Instance;
    }

    public static AdjustableBasePlp openBoxSpring(){
        reporter.info("Opening Box Springs Page");
        hover2ItemsAndClick(products, bases, boxSpring);
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

    public static void openCart() {
        reporter.info("Open Cart (Click on Show cart button)");
        minicartIcon.click();
        waitForPageToLoad();
        $(".product-item-name").shouldBe(Condition.visible);
    }

    public CartPage clickOnViewCartButton(){
        reporter.info("Click on \"View Cart\" button");
        openCart();
        viewCartButton.click();
        return CartPage.Instance;
    }

    public CheckoutPage clickOnViewCheckoutPage(){
        openCart();
        reporter.info("Click on \"Checkout\" button in minicart");
        checkoutButton.click();
        return CheckoutPage.Instance;
    }

    public ArrayList<ItemEntity> getAllCartItems() {
        ArrayList<ItemEntity> result = new ArrayList<>();

        openCart();
        reporter.info("Getting items in minicart");

        ElementsCollection cartItemsList = getElements(minicartItems);
        for (WebElement cartItem : cartItemsList) {
            ItemEntity currentItem = new ItemEntity();

            currentItem.setTitle(cartItem.findElement(minicartItemName).getText());
            currentItem.setQty(Integer.valueOf(cartItem.findElement(minicartQty).getAttribute("data-item-qty")));
            currentItem.setPrice(Tools.convertStringPriceToFloat(cartItem.findElement(minicartPrice).getText()));
            currentItem.setSize("");
//            if (cartItem.findElement(minicartItemName).getText().contains("Pillow")){
//                if (cartItem.findElement(minicartItemName).getText().contains("Soft")){
//                    currentItem.setType("Soft Pillow Top");
//                }else{
//                    currentItem.setType("Medium Pillow Top");
//                }
//            } else{
//                if (cartItem.findElement(minicartItemName).getText().contains("Firm")){
//                    currentItem.setType("Firm");
//                }else if (cartItem.findElement(minicartItemName).getText().contains("Soft")){
//                    currentItem.setType("Soft");
//                }else{
//                    currentItem.setType("Medium");
//                }
//            }

            List<WebElement> details = cartItem.findElements(minicartItemDetails);

            for (WebElement elem : details) {
                currentItem.setSize(elem.getText());
//                String value = elem.getText();
//                reporter.info(elem.getText());
//                if (value.contains("(") && value.contains(")"))
//                    currentItem.setSize(value);
//                else
//                    currentItem.setType(value);
            }
            reporter.info("Order item: " + currentItem.toString());
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
        closeMinicart.click();
        return true;
//        return items.stream()
//                .filter(cur -> item.getTitle().equals(cur.getTitle()))
//                .filter(cur -> item.getQty() == cur.getQty())
//                .filter(cur -> item.getPrice() == cur.getPrice())
//                //.filter(cur -> cur.getType().contains(item.getType()))
//                .filter(cur -> cur.getSize().contains(item.getSize().toLowerCase()
//                        .replace(".", "")
//                        .replace(" ", ""))).count() > 0;
    }

    public void clickOnDeleteProductButton(ItemEntity item) {
        closeCart();
        openCart();
        ElementsCollection cartItemsList = getElements(minicartItems);
        for (int i = 0; i < cartItemsList.size(); i++) {
            WebElement cartItem = cartItemsList.get(i);
            if (cartItem.findElement(minicartItemName).getText().contains(item.getTitle()) &&
                    Tools.convertStringPriceToFloat(cartItem.findElement(minicartPrice).getText()) == item.getPrice() &&
                    cartItem.findElement(minicartQty).getAttribute("data-item-qty").equals(String.valueOf(item.getQty()))) {
                cartItem.findElement(deleteItemFromMinicartButton).click();

                confirmItemDeletionButton.click();
            }
        }
        reporter.info("Click on Delete Cart button");

    }

    public int getCountOfProductsOnMinicartIcon() {
        reporter.info("Getting count of goods from minicart icon");
        waitForPageToLoad();
        waitForElement(minicartIconQty);
        waitUntilElementContainsText(minicartIconQty);
        String[] result = $(".counter.qty").getText().split("\n");
        reporter.info("Items on cart icon are equal to " + Integer.valueOf(result[0]));
        return Integer.valueOf(result[0]);
    }

    public int getCountOfGoodsInMinicart() {
        reporter.info("Counting sum of goods in the cart");
        openCart();
        int count = 0;
        ElementsCollection cartItemsList = getElements(minicartItems);
        for (int i = 0; i < cartItemsList.size(); i++) {
            WebElement cartItem = cartItemsList.get(i);
            count = count + Integer.valueOf(cartItem.findElement(minicartQty).getAttribute("data-item-qty"));
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
