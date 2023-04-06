package org.example;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestPage {

    private final File html = new File("src/test/resources/htmls/QE-index.html");
    private final SelenideElement testPageHeader = $(byText("Test Page"));

    public SelenideElement testOneEmailField = $("#inputEmail");
    public SelenideElement testOnePasswordField = $("#inputPassword");
    public SelenideElement testOneSignInButton = $x("//button[text()='Sign in']");

    public ElementsCollection testTwoItemsList = $$x("//li[@class ='list-group-item justify-content-between']");
    public ElementsCollection testTwoBadgesList = $$x("//li[@class ='list-group-item " +
            "justify-content-between']/span");

    public SelenideElement testThreeButton = $("#dropdownMenuButton");

    public SelenideElement testFourFirstButton = $(byXpath("//div[@id='test-4-div']/button[1]"));
    public SelenideElement testFourSecondButton = $(byXpath("//div[@id='test-4-div']/button[2]"));

    public SelenideElement testFiveButton = $(By.id("test5-button"));
    public SelenideElement testFiveAlert = $(By.id("test5-alert"));

    public void openPage() {
        Selenide.open(html.getAbsolutePath());
    }

    public void assertEmailIsPresentAndEnter(String email) {
        testOneEmailField.shouldBe(visible).setValue(email);
    }

    public void assertPasswordIsPresentAndEnter(String password) {
        testOnePasswordField.shouldBe(visible).setValue(password);
    }

    public void assertIsOpened() {
        testPageHeader.shouldBe(visible);
    }

    public void clickOptionByText(String option) {
        String option1 = "//a[text()='" + option + "']";
        $x(option1).click();
    }

    public void assertButtonHasText (String text) {
        testThreeButton.has(ownText(text));
    }

    public SelenideElement getTableCellByCoordinates(int row, int column) {
        String xpath = String.format("//table/tbody/tr[%d]/td[%d]", ++row, ++column);
        return $x(xpath);
    }

    public void assertTestTwoListHasSize(int size) {
        testTwoItemsList.shouldHave(CollectionCondition.size(size));
    }

    public void assertTestTwoListHasValueByIndex(int index, String text) {
        testTwoItemsList.get(index).shouldHave(ownText(text));
    }

    public void assertTestTwoListHasBadgeValueByIndex(int index, String badgeValue) {
        testTwoBadgesList.get(index).shouldHave(ownText(badgeValue));
    }
}
