package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final String LOGIN = "technopol51";
    private static final String PASSWORD = "technopolisPassword";

    public LoginPage() {
        checkPage();
    }

    public MainPage login() {
        SelenideElement loginField = $(By.id("field_email"));
        SelenideElement passwordField = $(By.id("field_password"));
        SelenideElement singInButton = $(By.xpath(".//*[@data-l='t,sign_in']"));

        loginField.setValue(LOGIN);
        passwordField.setValue(PASSWORD);
        singInButton.shouldBe(visible).click();

        return new MainPage();
    }

    private void checkPage() {
        SelenideElement singInButton = $(By.xpath(".//*[@data-l='t,sign_in']"));
        SelenideElement restoreButton = $(By.xpath(".//*[@data-l='t,restore']"));
        SelenideElement qrButton = $(By.xpath(".//*[@data-l='t,get_qr']"));

        singInButton.shouldBe(visible);
        restoreButton.shouldBe(visible);
        qrButton.shouldBe(visible);
    }
}
