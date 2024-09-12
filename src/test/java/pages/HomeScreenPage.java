package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.attributes;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HomeScreenPage {
    private final SelenideElement pageTitle = $(By.cssSelector("[type=XCUIElementTypeStaticText]"));
    private final SelenideElement tabBar = $(By.cssSelector("[type=XCUIElementTypeTabBar]"));
    private final SelenideElement table = $(By.cssSelector("[type=XCUIElementTypeTable]"));
    private final SelenideElement searchField = $(AppiumBy.iOSClassChain("**/XCUIElementTypeSearchField[`name == \"Search\"`]"));
    private final SelenideElement searchButtonInTabBar = $(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Search\"`]"));
    private final SelenideElement clearButton = $(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Clear text\"`]"));
    private final SelenideElement notResultMessage = $(AppiumBy.accessibilityId("Your search did not have any results."));
    private final SelenideElement cancelButton = $(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Cancel\"`]"));

    private final By cell = By.cssSelector("[type=XCUIElementTypeCell]"),
            text = By.cssSelector("[type=XCUIElementTypeStaticText]"),
            cardImg = By.cssSelector("[type=XCUIElementTypeImage]"),
            button = By.cssSelector("[type=XCUIElementTypeButton]");

    @Step("Проверить наличие заголовка")
    public HomeScreenPage checkMainTitle() {
        String title = "What's New";
        pageTitle.shouldBe(visible).shouldHave(text(title));
        return this;
    }

    @Step("Проверить что блок с книгами не является пустым")
    public HomeScreenPage checkTableIsNotEmpty() {
        table.$$(cell).should(sizeGreaterThan(0));
        return this;
    }

    @Step("Проверить наличие элементов \"New\" и \"Search\" в таббаре")
    public HomeScreenPage checkTabBar() {
        String buttonOneName = "New";
        String buttonSecondName = "Search";
        tabBar.$$(button)
                .shouldHave(attributes("name", buttonOneName, buttonSecondName));
        return this;
    }

    public List<SelenideElement> getCards() {
        return table.$$(cell);
    }

    @Step("Проверить отображение картинки")
    public HomeScreenPage cardShouldHaveImg(SelenideElement card) {
        card.$(cardImg).should(exist);
        return this;
    }

    public List<SelenideElement> getTextFields(SelenideElement card) {
        return card.$$(text);
    }

    @Step("Проверить отображение заголовка {title}")
    public HomeScreenPage cardShouldHaveTitle(SelenideElement textField, String title) {
        textField.shouldHave(text(title));
        return this;
    }

    @Step("Проверить отображение описания {description}")
    public HomeScreenPage cardShouldHaveDescription(SelenideElement textField, String description) {
        textField.shouldHave(exactText(description));
        return this;
    }

    @Step("Проверить отображение цены {price}")
    public HomeScreenPage cardShouldHavePrice(SelenideElement textField, String price) {
        textField.shouldHave(text(price));
        return this;
    }

    @Step("Проверить отображение серии книги {series}")
    public HomeScreenPage cardShouldHaveSeries(SelenideElement textField, String series) {
        textField.shouldHave(text(series));
        return this;
    }

    @Step("Проверить отображение номера книги {number}")
    public HomeScreenPage cardShouldHaveNumber(SelenideElement textField, String number) {
        textField.shouldHave(text(number));
        return this;
    }

    @Step("Ввести текст {text}")
    public HomeScreenPage inputText(String text) {
        searchButtonInTabBar.click();
        searchField.click();
        searchField.sendKeys(text);
        return this;
    }

    @Step("Нажать на крестик")
    public HomeScreenPage pressClearButton() {
        clearButton.click();
        return this;
    }

    @Step("Проверить, что поле пустое и отображается плейсхолдер Search")
    public HomeScreenPage checkEmptyField() {
        searchField.shouldHave(exactValue("Search"));
        return this;
    }

    @Step("Отображается экран <Нет результата>")
    public HomeScreenPage checkIsNoResult() {
        notResultMessage.shouldHave(text("Your search did not have any results."));
        return this;
    }
}
