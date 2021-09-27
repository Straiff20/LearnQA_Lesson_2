package iOS;

import Lib.CoreTestCase;
import Lib.ui.OnboardingPageObject;
import org.junit.jupiter.api.Test;

public class testOnboarding extends CoreTestCase {
    @Test
    public void onboardingPathTest() {
        OnboardingPageObject onboardingPageObject = new OnboardingPageObject(appiumDriver);

        onboardingPageObject.waitFistOnboardingPage();

        onboardingPageObject.tapToNextButton();
        onboardingPageObject.waitSecondOnboardingPage();

        onboardingPageObject.tapToNextButton();
        onboardingPageObject.waitThirdOnboardingPage();

        onboardingPageObject.tapToNextButton();
        onboardingPageObject.waitFourthdOnboardingPage();

        onboardingPageObject.tapToGetStartedButton();
        onboardingPageObject.waitSearchInput();
    }
}
