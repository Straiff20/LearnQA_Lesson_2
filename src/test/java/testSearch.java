import Lib.Android_CoreTestCase;
import Lib.ui.SearchPageObject;
import org.junit.jupiter.api.Test;

public class testSearch extends Android_CoreTestCase {

    @Test
    public void searchWordAndCheckAnswerTest() {
        SearchPageObject searchPageObject = new SearchPageObject(ad);

        searchPageObject.findAndTapSearchInput();
        searchPageObject.sendKeysToSearchInput("Java");
        searchPageObject.waitForSearchResult("JavaScript");
    }

    @Test
    public void searchWordCheckAndClearTest() {
        SearchPageObject searchPageObject = new SearchPageObject(ad);

        searchPageObject.findAndTapSearchInput();
        searchPageObject.sendKeysToSearchInput("Appium");
        searchPageObject.waitForCloseSearchButtonToAppear();
        searchPageObject.tapToCloseSearchInputButton();
        searchPageObject.waitForCloseSearchButtonToDisappear();
    }
}