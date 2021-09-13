package Lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {
    protected static AndroidDriver ad;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    @BeforeEach
    @Override
    protected void setUp() throws Exception {

        super.setUp();

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", "org.wikipedia");
        dc.setCapability("appActivity", ".main.MainActivity");
        dc.setCapability("app", "/Users/pliyevilya/Desktop/Projects/LearnQA_Lesson_2/apks/org.wikipedia.apk");

        ad = new AndroidDriver(new URL(AppiumURL), dc);
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

        ad.quit();
    }
}
