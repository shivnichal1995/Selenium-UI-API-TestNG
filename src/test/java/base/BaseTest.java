package base;

import org.testng.annotations.*;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quit();
    }
}