package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage enterUsername(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username))
                .sendKeys(value);
        return this;
    }

    public LoginPage enterPassword(String value) {
        driver.findElement(password).sendKeys(value);
        return this;
    }

    public InventoryPage clickLogin() {
        driver.findElement(loginButton).click();
        return new InventoryPage();
    }

    public LoginPage loginExpectingError(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        driver.findElement(loginButton).click();
        return this;
    }

    public String getErrorMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage))
                .getText();
    }
}
