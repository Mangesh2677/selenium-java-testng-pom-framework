package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {

    private final By pageTitle = By.cssSelector(".title");
    private final By sortDropdown = By.cssSelector(".product_sort_container");
    private final By inventoryItems = By.cssSelector(".inventory_item");
    private final By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartLink = By.cssSelector(".shopping_cart_link");

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle))
                .getText();
    }

    public InventoryPage sortByPriceLowToHigh() {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByValue("lohi");
        return this;
    }

    public List<Double> getProductPrices() {
        List<WebElement> priceElements =
                driver.findElements(By.cssSelector(".inventory_item_price"));

        List<Double> prices = new ArrayList<>();
        for (WebElement element : priceElements) {
            prices.add(Double.parseDouble(element.getText().replace("$", "")));
        }
        return prices;
    }

    public InventoryPage addBackpackToCart() {
        driver.findElement(addBackpack).click();
        return this;
    }

    public CartPage openCart() {
        driver.findElement(cartLink).click();

        waitForUrlContains("cart.html");

        return new CartPage();
    }
}
