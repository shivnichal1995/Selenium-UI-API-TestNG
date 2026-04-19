package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {
        String browser = ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--headless=new");   // REQUIRED in CI
            options.addArguments("--no-sandbox");     // REQUIRED in Linux
            options.addArguments("--disable-dev-shm-usage"); // fixes memory issue
            options.addArguments("--disable-gpu");
            driver.set(new ChromeDriver(options));
        }

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quit() {
        getDriver().quit();
        driver.remove();
    }
}