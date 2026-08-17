package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "Verify user can login with valid credentials")
    public void validLoginTest() {
        InventoryPage inventoryPage = new LoginPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        Assert.assertEquals(
                inventoryPage.getPageTitle(),
                "Products",
                "User should land on Products page");
    }

    @Test(description = "Verify error is displayed for invalid credentials")
    public void invalidLoginTest() {
        String error = new LoginPage()
                .loginExpectingError("invalid_user", "wrong_password")
                .getErrorMessage();

        Assert.assertTrue(
                error.contains("Username and password do not match"),
                "Expected invalid-login error was not displayed");
    }
}
