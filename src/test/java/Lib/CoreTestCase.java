package Lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";

    protected AppiumDriver appiumDriver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    @BeforeEach
    @Override
    protected void setUp() throws Exception {

        super.setUp();

        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();

        appiumDriver = new AppiumDriver(new URL(AppiumURL), capabilities);
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

        appiumDriver.quit();
    }

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equals(PLATFORM_ANDROID)) {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("app", "/Users/pliyevilya/Desktop/Projects/LearnQA_Lesson_2/apks/org.wikipedia.apk");
        } else if (platform.equals(PLATFORM_IOS)) {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "14.4");
            capabilities.setCapability("app", "/Users/pliyevilya/Desktop/Projects/LearnQA_Lesson_2/apks/Wikipedia.app");
        } else {
            throw new Exception("Cannot get platform from env variable. Platform value is " + platform);
        }
        return capabilities;
    }
}
