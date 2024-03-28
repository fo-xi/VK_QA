package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ValidLoginTest extends BaseTest {
    private final SelenideElement MESSAGE_BUTTON = $(By.id("msg_toolbar_button"));
    private final LoginPage loginPage = new LoginPage();
    private MainPage mainPage;

    @BeforeEach
    public void setup() {
       start();
    }

    @Test
    public void testLogin() {
        mainPage = loginPage.login();
        MESSAGE_BUTTON.shouldBe(visible);
    }

    @AfterEach
    public void setDown() {
        mainPage.logout();
    }
}
