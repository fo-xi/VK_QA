package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testing a valid login")
public class ValidLoginTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private MainPage mainPage;

    @BeforeEach
    public void setup() {
       start();
    }

    @Test
    @Tag("Login")
    @DisplayName("Login Test")
    public void loginTest() {
        SelenideElement messageButton = $(By.xpath(".//*[@data-l='t,messages']"));
        SelenideElement notificationsButton = $(By.xpath(".//*[@data-l='t,notifications']"));
        SelenideElement guestsButton = $(By.xpath(".//*[@data-l='t,guests']"));
        mainPage = loginPage.login();

        assertAll("Login Test",
                () -> assertTrue(messageButton.exists(),
                        "Message button should be visible after login"),
                () -> assertTrue(notificationsButton.exists(),
                        "Notifications button should be visible after login"),
                () -> assertTrue(guestsButton.exists(),
                        "Guests button should be visible after login")
        );
    }

    @AfterEach
    public void setDown() {
        mainPage.logout();
    }
}
