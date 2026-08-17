package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductTest extends BaseTest {

    private InventoryPage login() {
        return new LoginPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();
    }

    @Test(description = "Verify products can be sorted by price low to high")
    public void sortProductsByPriceTest() {
        InventoryPage inventoryPage = login();

        List<Double> actualPrices = inventoryPage
                .sortByPriceLowToHigh()
                .getProductPrices();

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        Assert.assertEquals(
                actualPrices,
                expectedPrices,
                "Products are not sorted from low to high");
    }

    @Test(description = "Verify product can be added to cart")
    public void addProductToCartTest() {
        CartPage cartPage = login()
                .addBackpackToCart()
                .openCart();

        cartPage.waitForCartItem();

        Assert.assertEquals(cartPage.getItemCount(), 1);
        Assert.assertTrue(
                cartPage.isProductPresent("Sauce Labs Backpack"),
                "Sauce Labs Backpack should be present in cart");
    }
}
