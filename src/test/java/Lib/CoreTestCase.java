package Lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.ScreenOrientation;

public class CoreTestCase extends TestCase {

    protected Platform Platform;
    protected AppiumDriver driver;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {

        super.setUp();
        this.Platform = new Platform();
        driver = this.Platform.getDriver();
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {

        super.tearDown();
        driver.quit();
    }
}
