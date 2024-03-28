package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final String LOGIN = "technopol51";
    private static final String PASSWORD = "technopolisPassword";
    private final SelenideElement LOGIN_FIELD = $(By.id("field_email"));
    private final SelenideElement PASSWORD_FIELD = $(By.id("field_password"));
    private final SelenideElement SUBMIT_BUTTON = $(By.cssSelector("input[type='submit']"));

    public MainPage login() {
        LOGIN_FIELD.setValue(LOGIN);
        PASSWORD_FIELD.setValue(PASSWORD);
        SUBMIT_BUTTON.shouldBe(visible).click();
        return new MainPage();
    }
}
