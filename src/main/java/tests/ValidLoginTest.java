package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testing a valid login")
public class ValidLoginTest extends BaseTest {
    private MainPage mainPage;

    @Test
    @Tag("Login")
    @DisplayName("Login Test")
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        mainPage = loginPage.login();

        assertAll("Login Test",
                () -> assertTrue(loginPage.getMessageButton().exists(),
                        "Message button should be visible after login"),
                () -> assertTrue(loginPage.getNotificationsButton().exists(),
                        "Notifications button should be visible after login"),
                () -> assertTrue(loginPage.getGuestsButton().exists(),
                        "Guests button should be visible after login")
        );
    }

    @AfterEach
    public void setDown() {
        if (mainPage != null) {
            mainPage.logout();
        }
    }
}
