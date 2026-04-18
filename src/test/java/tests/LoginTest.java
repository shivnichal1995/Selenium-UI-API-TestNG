package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import pages.DashboardPage;
import pages.LoginPage;
import utils.DriverFactory;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());
        dashboardPage.clickOnLink("Form Authentication");
        LoginPage login = new LoginPage(DriverFactory.getDriver());
        login.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(true);
    }
}