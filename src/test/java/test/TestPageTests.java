package test;

import com.codeborne.selenide.Selenide;
import org.example.TestPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class TestPageTests extends BaseTest {

    TestPage testPage = new TestPage();

    @BeforeMethod
    public void open() {
        testPage.openPage();
        testPage.assertIsOpened();
    }

    @AfterMethod
    public void closeBrowser () {
        Selenide.closeWebDriver();
    }

    @Test
    public void testOne() {
        testPage.assertEmailIsPresentAndEnter("email");
        testPage.assertPasswordIsPresentAndEnter("password");
        testPage.testOneSignInButton.shouldBe(visible);
    }

    @Test
    public void testTwo() {
        testPage.assertTestTwoListHasSize(3);
        testPage.assertTestTwoListHasValueByIndex(1, "List Item 2");
        testPage.assertTestTwoListHasBadgeValueByIndex(1, "6");
    }

    @Test
    public void testThree() {
        testPage.assertButtonHasText("Option 1");
        testPage.testThreeButton.click();
        testPage.clickOptionByText("Option 3");
        testPage.assertButtonHasText("Option 3");
    }

    @Test
    public void testFour() {
        testPage.testFourFirstButton.shouldBe(enabled);
        testPage.testFourSecondButton.shouldBe(disabled);
    }

    @Test
    public void testFive() {
        testPage.testFiveButton.shouldBe(visible, Duration.ofSeconds(11))  // white box testing - I checked JS :)
                               .click();
        testPage.testFiveAlert.should(appear);
        testPage.testFiveButton.shouldBe(disabled);
    }

    @Test
    public void testSix() {
        testPage.getTableCellByCoordinates(2, 2)
                .shouldHave(ownText("Ventosanzap"));
    }
}
