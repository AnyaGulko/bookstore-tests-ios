package tests;

import com.codeborne.selenide.SelenideElement;
import data.CardDescriptionOnHomePage;
import io.qameta.allure.*;
import models.BookCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomeScreenPage;

import java.util.List;

@Tag("home_screen_tests")
public class HomeScreenTests extends TestBase {
    static HomeScreenPage homeScreenPage = new HomeScreenPage();

    @Test
    @Feature("HomeScreen Page")
    @Owner("Anna Gulko")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("smoke")
    @Tag("regress")
    @DisplayName("Проверка наличия элементов на главном экране")
    void elementsOnTheHomeScreenPageTest() {
        homeScreenPage.checkMainTitle()
                .checkTableIsNotEmpty()
                .checkTabBar();
    }

    @Test
    @Feature("HomeScreen Page")
    @Owner("Anna Gulko")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("smoke")
    @Tag("regress")
    @DisplayName("Отображения карточек книг на главном экране")
    void cardsOnTheHomeScreenPageTest() {
        List<SelenideElement> actualCards = homeScreenPage.getCards();
        for (int i = 0; i < CardDescriptionOnHomePage.cards.size(); i++) {
            SelenideElement actualCard = actualCards.get(i);
            BookCard expectedCard = CardDescriptionOnHomePage.cards.get(i);
            List<SelenideElement> textFields = homeScreenPage.getTextFields(actualCard);

            homeScreenPage.cardShouldHaveImg(actualCard)
                    .cardShouldHaveTitle(textFields.get(0), expectedCard.title())
                    .cardShouldHaveDescription(textFields.get(1), expectedCard.description())
                    .cardShouldHavePrice(textFields.get(2), expectedCard.price())
                    .cardShouldHaveSeries(textFields.get(3), expectedCard.series())
                    .cardShouldHaveNumber(textFields.get(4), expectedCard.number());

        }
    }
}
