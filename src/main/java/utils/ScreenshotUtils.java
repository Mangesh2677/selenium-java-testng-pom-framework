package utils;

import driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static void capture(String fileName) {
        try {
            File source = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            Path destination = Path.of(
                    "target",
                    "screenshots",
                    fileName + ".png");

            Files.createDirectories(destination.getParent());
            Files.copy(source.toPath(), destination,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.err.println("Screenshot failed: " + e.getMessage());
        }
    }
}
