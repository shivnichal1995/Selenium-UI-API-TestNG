package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Allure;
import utils.DriverFactory;

import java.io.ByteArrayInputStream;
import java.io.File;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File src = ts.getScreenshotAs(OutputType.FILE);
                // save screenshot
            } catch (Exception e) {
                System.out.println("Screenshot failed: " + e.getMessage());
            }
        } else {
            System.out.println("Driver is null. Screenshot skipped.");
        }
    }
}