package tests;

import com.codeborne.selenide.SelenideElement;
import data.CardDescriptionOnHomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.BookCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomeScreenPage;

import java.util.List;

@Tag("search_test")
public class SearchTest extends TestBase {
    static HomeScreenPage homeScreenPage = new HomeScreenPage();

    @Test
    @Feature("Search for books")
    @Owner("Anna Gulko")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Поиск книг")
    @Tag("smoke")
    @Tag("regress")
    void searchForBooksTest() {
        homeScreenPage.inputText("Java");

        List<SelenideElement> actualCards = homeScreenPage.getCards();
        for (int i = 0; i < CardDescriptionOnHomePage.bookInSearch.size(); i++) {
            SelenideElement actualCard = actualCards.get(i);
            BookCard expectedCard = CardDescriptionOnHomePage.bookInSearch.get(i);
            List<SelenideElement> textFields = homeScreenPage.getTextFields(actualCard);

            homeScreenPage.cardShouldHaveImg(actualCard)
                    .cardShouldHaveTitle(textFields.get(0), expectedCard.title())
                    .cardShouldHaveDescription(textFields.get(1), expectedCard.description())
                    .cardShouldHavePrice(textFields.get(2), expectedCard.price())
                    .cardShouldHaveSeries(textFields.get(3), expectedCard.series())
                    .cardShouldHaveNumber(textFields.get(4), expectedCard.number());

        }
    }

    @Test
    @Feature("Search for books")
    @Owner("Anna Gulko")
    @Severity(SeverityLevel.NORMAL)
    @Tag("regress")
    @DisplayName("Отображение экрана <Нет результатов>")
    void booksNotFoundTest() {
        homeScreenPage.inputText("f")
                .checkIsNoResult();
    }

    @Test
    @Feature("Search for books")
    @Owner("Anna Gulko")
    @Severity(SeverityLevel.NORMAL)
    @Tag("regress")
    @DisplayName("Очистка поля по нажатию на крестик")
    void clearingTheFieldTest() {
        homeScreenPage.inputText("Java")
                .pressClearButton()
                .checkEmptyField();
    }

}
