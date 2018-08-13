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

public class CartPage extends BasePage{

    private static CartPage instance;
    public static CartPage Instance = (instance != null) ? instance : new CartPage();

    public CartPage(){
        pageURL = "/checkout/cart/";
        pageTitle = "Shopping Cart";
    }

    //* UI mappings *//
    SelenideElement
//    cartItems = $("tr.item-info"),
//    cartItemName = $("strong.product-item-name"),
//    itemQty = $("input"),
//    itemPrice = $("span.price"),
//    itemDetails = $("dd"),

    backToShopLink = $x("//A[@class='back-to-shop'][text()='Back to Shop']"),
    proceedToCheckoutButton = $("button[data-role='proceed-to-checkout']");

    By increaseQtyButton = By.xpath("//button[@name='update_cart_action' and @title='+']");
    By decreaseQtyButton = By.xpath("//button[@name='update_cart_action' and @title='-']");

    By cartItems = By.cssSelector("tr.item-info");
    By cartItemName = By.cssSelector("strong.product-item-name");
    By itemQty = By.cssSelector("input");
    By itemPrice = By.cssSelector("span.price");
    By itemDetails = By.cssSelector("dd");
    By itemEditButton = By.cssSelector(".col.action-rem-edit a.action.action-edit");
    By itemDeleteButton = By.cssSelector(".col.action-rem-edit a.action.action-delete");

    public boolean itemDisplayedOnViewCartPage(ItemEntity item) {
        waitForPageToLoad();
        ArrayList<ItemEntity> items = getAllViewCartPageItems();
        reporter.info("Expected item: " + item.toString());
        return items.stream()
                .filter(cur -> item.getTitle() == null || item.getTitle().equals(cur.getTitle()))
                .filter(cur -> item.getQty() == 0 || item.getQty() == cur.getQty())
                .filter(cur -> item.getPrice() == 0 ||item.getPrice() == cur.getPrice())
                //.filter(cur -> item.getType() == null || cur.getType().contains(item.getType()))
                .filter(cur -> item.getSize() == null || cur.getSize().contains(item.getSize()))
                    .count() > 0;
    }

    public boolean itemDisplayedOnViewCartPage(String itemName) {
        ArrayList<ItemEntity> items = getAllViewCartPageItems();
        return items.stream()
                .filter(cur -> itemName.equals(cur.getTitle()))
                .count() > 0;
    }

    public boolean itemDisplayedOnViewCartPage(String itemName, int qty) {
        ArrayList<ItemEntity> items = getAllViewCartPageItems();
        return items.stream()
                .filter(cur -> itemName.equals(cur.getTitle()))
                .filter(cur -> qty == cur.getQty())
                .count() > 0;
    }

    private ArrayList<ItemEntity> getAllViewCartPageItems() {
        ArrayList<ItemEntity> result = new ArrayList<>();
        reporter.info("Getting order items on cart page");
        waitForPageToLoad();

        ElementsCollection itemsList = getElements(cartItems);
        for (WebElement orderItem : itemsList ) {
            ItemEntity currentItem = new ItemEntity();

            currentItem.setTitle(orderItem.findElement(cartItemName).getText());
            currentItem.setQty(Integer.valueOf(orderItem.findElement(itemQty).getAttribute("value")));
            currentItem.setPrice(Tools.convertStringPriceToFloat(orderItem.findElement(itemPrice).getText()));
            currentItem.setSize("");
//            if (orderItem.findElement(cartItemName).getText().contains("Pillow")){
//                if (orderItem.findElement(cartItemName).getText().contains("Soft")){
//                    currentItem.setType("Soft Pillow Top");
//                }else{
//                    currentItem.setType("Medium Pillow Top");
//                }
//            } else{
//                if (orderItem.findElement(cartItemName).getText().contains("Firm")){
//                    currentItem.setType("Firm");
//                }else if (orderItem.findElement(cartItemName).getText().contains("Soft")){
//                    currentItem.setType("Soft");
//                }else{
//                    currentItem.setType("Medium");
//                }
//            }

            List<WebElement> details = orderItem.findElements(itemDetails);

            for(WebElement elem : details){
                currentItem.setSize(elem.getText());
//                String value = elem.getText();
//                if (value.contains("(") && value.contains(")"))
//                    currentItem.setSize(value);
//                else
//                    currentItem.setType(value);
            }

            reporter.info("Order item: " + currentItem.toString());
            result.add(currentItem);

        }

        if (itemsList.size() == 0) {
            reporter.info("No items were found on Checkout page");
            //Assert.fail("No items were found on Checkout page");
        }

        return result;
    }

    // click on product name on product cart
    public void clickOnProduct(String itemName) {
        reporter.info("Open item from View cart page: " + itemName );
        getElement(By.xpath("(//a[text()='" + itemName + "'])[2]")).click();
    }

    //click on edit button for item in View Cart
    public void clickOnEditProduct(String itemName) {
        reporter.info("Edit item from View cart page: " + itemName );
        ElementsCollection itemsList = getElements(cartItems);
        for (WebElement orderItem : itemsList ) {
            if ( orderItem.findElement(cartItemName).getText().equals(itemName)) {
                orderItem.findElement(itemEditButton).click();
                return;
            }
        }
    }

    //click on delete button for item in View Cart
    public void clickOnDeleteProduct(String itemName) {
        reporter.info("Delete item from View cart page: " + itemName );
        ElementsCollection itemsList = getElements(cartItems);
        for (WebElement orderItem : itemsList ) {
            if ( orderItem.findElement(cartItemName).getText().equals(itemName)) {
                orderItem.findElement(itemDeleteButton).click();
                return;
            }
        }
    }


    public void addQuantity(String itemName) {
        reporter.info("Increase number of items on View cart page: " + itemName );
        ElementsCollection itemsList = getElements((By) cartItems);
        for (WebElement orderItem : itemsList ) {
            if ( orderItem.findElement(cartItemName).getText().equals(itemName)) {
                orderItem.findElement(increaseQtyButton).click();
                return;
            }
        }
    }

    public void subQuantity(String itemName) {
        reporter.info("Decrease number of items on View cart page: " + itemName );
        ElementsCollection itemsList = getElements((By) cartItems);
        for (WebElement orderItem : itemsList ) {
            if ( orderItem.findElement((By) cartItemName).getText().equals(itemName)) {
                orderItem.findElement((By) decreaseQtyButton).click();
                return;
            }
        }
    }

    public void clickOnBackToShop() {
        reporter.info("Click on back to shop link");
        backToShopLink.click();
    }

    public CheckoutPage clickOnProceedToChechout() {
        reporter.info("Click on Proceed to Checkout button");
        proceedToCheckoutButton.scrollIntoView(true)
                .click();
        return CheckoutPage.Instance;
    }
}
