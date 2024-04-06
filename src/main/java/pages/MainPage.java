package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public MainPage() {
        checkPage();
    }

    public MessagePage goToMessage() {
        SelenideElement messageButton = $(By.xpath(".//*[@data-l='t,messages']"));
        messageButton.shouldBe(visible).click();
        return new MessagePage();
    }

    public void logout() {
        SelenideElement profileSettingsButton = $(By.xpath(".//*[@aria-controls='user-dropdown-menu']"));
        SelenideElement logoutForm = $(By.xpath(".//a[@data-l='t,logout']"));
        SelenideElement logoutButton = $(By.xpath(".//input[@data-l='t,logout']"));

        profileSettingsButton.shouldBe(visible).click();
        logoutForm.shouldBe(visible).click();
        logoutButton.shouldBe(visible).click();
    }

    private void checkPage() {
        SelenideElement userButton = $(By.xpath(".//*[@data-l='t,userPage']"));
        SelenideElement feedButton = $(By.xpath(".//*[@data-l='t,userMain']"));
        SelenideElement hobbyButton = $(By.xpath(".//*[@data-l='t,hobby']"));

        userButton.shouldBe(visible);
        feedButton.shouldBe(visible);
        hobbyButton.shouldBe(visible);
    }
}
