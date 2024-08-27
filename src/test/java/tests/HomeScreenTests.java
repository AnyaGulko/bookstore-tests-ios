package tests;

import com.codeborne.selenide.SelenideElement;
import data.CardDescriptionOnHomePage;
import models.BookCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomeScreenPage;

import java.util.List;

public class HomeScreenTests extends TestBase {
    static HomeScreenPage homeScreenPage = new HomeScreenPage();

    @Test
    @DisplayName("Проверка наличия элементов на главном экране")
    void elementsOnTheHomeScreenPageTest() {
        homeScreenPage.checkMainTitle()
                .checkTableIsNotEmpty()
                .checkTabBar();
    }

    @Test
    @DisplayName("Проверка отображения карточек книг на главном экране")
    void cardsOnTheHomeScreenPageTest() {
        List<SelenideElement> actualCards = homeScreenPage.getCards();
        for (int i = 0; i < CardDescriptionOnHomePage.cards.size(); i++) {
            SelenideElement actualCard = actualCards.get(i);
            BookCard expectedCard = CardDescriptionOnHomePage.cards.get(i);

            homeScreenPage.cardShouldHaveImg(actualCard)
                    .cardShouldHaveTitle(actualCard, expectedCard.getTitle())
                    .cardShouldHaveDescription(actualCard, expectedCard.getDescription())
                    .cardShouldHavePrice(actualCard, expectedCard.getPrice())
                    .cardShouldHaveSeries(actualCard, expectedCard.getSeries())
                    .cardShouldHaveNumber(actualCard, expectedCard.getNumber());

        }
    }
}
