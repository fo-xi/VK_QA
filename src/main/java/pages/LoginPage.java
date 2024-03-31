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
    private final SelenideElement SING_IN_BUTTON = $(By.xpath(".//*[@data-l='t,sign_in']"));
    private SelenideElement QR_BUTTON = $(By.xpath(".//*[@data-l='t,get_qr']"));
    private SelenideElement RESTORE_BUTTON = $(By.xpath(".//*[@data-l='t,restore']"));

    public LoginPage() {
        checkPage();
    }

    public MainPage login() {
        LOGIN_FIELD.setValue(LOGIN);
        PASSWORD_FIELD.setValue(PASSWORD);
        SING_IN_BUTTON.shouldBe(visible).click();
        return new MainPage();
    }

    private void checkPage() {
        SING_IN_BUTTON.shouldBe(visible);
        RESTORE_BUTTON.shouldBe(visible);
        QR_BUTTON.shouldBe(visible);
    }
}
