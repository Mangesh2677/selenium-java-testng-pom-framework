package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private final By cartItems = By.cssSelector(".cart_item");
    private final By cartItemNames =
            By.cssSelector(".cart_item .inventory_item_name");
    private final By cartTitle =
            By.cssSelector(".title");

    public CartPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTitle));
    }

    public boolean isProductPresent(String productName) {
        return driver.findElements(cartItemNames)
                .stream()
                .anyMatch(element ->
                        element.getText().equals(productName));
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