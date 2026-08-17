package driver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void initDriver() {
        String browser = ConfigReader.getBrowser().toLowerCase();

        WebDriver driver = switch (browser) {
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            case "chrome" -> new ChromeDriver();
            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser);
        };

        DRIVER.set(driver);
        getDriver().manage().window().maximize();
        getDriver().get(ConfigReader.getBaseUrl());
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static void quitDriver() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
