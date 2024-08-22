package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomeScreenPage;

public class HomeScreenTests extends TestBase {
    HomeScreenPage homeScreenPage = new HomeScreenPage();

    @Test
    @DisplayName("Проверка наличия элементов на главном экране")
    void elementsOnTheHomeScreenPageTest() {
        homeScreenPage.checkMainTitle()
                .checkTableIsNotEmpty()
                .checkTabBar();
    }
}
