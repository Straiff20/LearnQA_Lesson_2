package iOS;

import Lib.CoreTestCase;
import Lib.ui.OnboardingPageObject;
import org.junit.jupiter.api.Test;

public class testOnboarding extends CoreTestCase {
    @Test
    public void onboardingPathTest() {
        if (this.Platform.isAndroid()) {
            return;
        }

        OnboardingPageObject onboardingPageObject = new OnboardingPageObject(driver);

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
