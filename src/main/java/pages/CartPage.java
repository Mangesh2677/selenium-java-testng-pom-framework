package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private final By cartItems = By.cssSelector(".cart_item");
    private final By cartItemNames =
            By.cssSelector(".cart_item .inventory_item_name");
    private final By cartTitle =
            By.cssSelector(".title");

    public CartPage() {
        // Wait for the cart page title and for at least one cart item to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTitle));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
    }

    public boolean isProductPresent(String productName) {
        String expected = productName == null ? "" : productName.trim();
        return driver.findElements(cartItemNames)
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .anyMatch(text -> text.equalsIgnoreCase(expected));
    }

    public int getItemCount() {
        return driver.findElements(cartItems).size();
    }

    public void waitForCartItem() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartItems)
        );
    }
}
