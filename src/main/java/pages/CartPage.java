package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private final By cartItemNames = By.cssSelector(".inventory_item_name");

    public boolean isProductPresent(String productName) {
        return driver.findElements(cartItemNames)
                .stream()
                .anyMatch(element -> element.getText().equals(productName));
    }

    public int getItemCount() {
        return driver.findElements(cartItemNames).size();
    }

    public void waitForCartItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemNames));
    }
}
