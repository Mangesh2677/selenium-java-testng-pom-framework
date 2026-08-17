package config;

public final class ConfigReader {

    private ConfigReader() {
    }

    public static String getBrowser() {
        return System.getProperty("browser", "chrome");
    }

    public static String getBaseUrl() {
        return System.getProperty("baseUrl", "https://www.saucedemo.com/");
    }
}
