package pages;

import com.codeborne.selenide.SelenideElement;
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
    public HomeScreenPage cardShouldHaveImg(SelenideElement card) {
        card.$(cardImg).should(exist);
        return this;
    }

    public HomeScreenPage cardShouldHaveTitle(SelenideElement card, String title) {
        card.$$(text).getFirst().shouldHave(text(title));
        return this;
    }

    public HomeScreenPage cardShouldHaveDescription(SelenideElement card, String description) {
        card.$$(text).get(1).shouldHave(exactText(description));
        return this;
    }

    public HomeScreenPage cardShouldHavePrice(SelenideElement card, String price) {
        card.$$(text).get(2).shouldHave(text(price));
        return this;
    }

    public HomeScreenPage cardShouldHaveSeries(SelenideElement card, String series) {
        card.$$(text).get(3).shouldHave(text(series));
        return this;
    }

    public HomeScreenPage cardShouldHaveNumber(SelenideElement card, String number) {
        card.$$(text).get(4).shouldHave(text(number));
        return this;
    }

    public HomeScreenPage cardShouldHaveImageUrl(SelenideElement card) {
        card.$(cardImg).should(exist);
        return this;
    }
}
