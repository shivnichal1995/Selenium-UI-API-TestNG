package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLink(String linkText) {
        By link = By.xpath("//a[text()='" + linkText + "']");
        driver.findElement(link).click();
    }
}
