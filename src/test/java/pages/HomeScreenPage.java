package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.attributes;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomeScreenPage {
    private final SelenideElement pageTitle = $(AppiumBy.cssSelector("[type=XCUIElementTypeStaticText]"));
    private final SelenideElement tabBar = $(AppiumBy.cssSelector("[type=XCUIElementTypeTabBar]"));
    private final ElementsCollection table = $$(AppiumBy.cssSelector("[type=XCUIElementTypeTable]"));

    @Step("Проверить наличие заголовка")
    public HomeScreenPage checkMainTitle() {
        String title = "What's New";
        pageTitle.shouldBe(visible).shouldHave(text(title));
        return this;
    }

    @Step("Проверить что блок с книгами не является пустым")
    public HomeScreenPage checkTableIsNotEmpty() {
        table.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    @Step("Проверить наличие элементов \"New\" и \"Search\" в таббаре")
    public HomeScreenPage checkTabBar() {
        String buttonOneName = "New";
        String buttonSecondName = "Search";
        tabBar.findAll("[type=XCUIElementTypeButton]")
                .shouldHave(attributes("name", buttonOneName, buttonSecondName));
        return this;
    }
}
