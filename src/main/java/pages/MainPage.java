package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement PROFILE_SETTINGS_BUTTON =
            $(By.xpath(".//*[@aria-controls='user-dropdown-menu']"));
    private final SelenideElement LOGOUT_FORM = $(By.xpath(".//a[@data-l='t,logout']"));
    private final SelenideElement LOGOUT_BUTTON = $(By.xpath(".//input[@data-l='t,logout']"));
    private final SelenideElement MESSAGE_BUTTON = $(By.id("msg_toolbar_button"));
    private final SelenideElement USER_BUTTON = $(By.xpath(".//*[@data-l='t,userPage']"));
    private final SelenideElement FEED_BUTTON = $(By.xpath(".//*[@data-l='t,userMain']"));
    private final SelenideElement HOBBY_BUTTON = $(By.xpath(".//*[@data-l='t,hobby']"));

    public MainPage() {
        checkPage();
    }

    public MessagePage goToMessage() {
        MESSAGE_BUTTON.shouldBe(visible).click();
        return new MessagePage();
    }

    public void logout() {
        PROFILE_SETTINGS_BUTTON.shouldBe(visible).click();
        LOGOUT_FORM.shouldBe(visible).click();
        LOGOUT_BUTTON.shouldBe(visible).click();
    }

    private void checkPage() {
        USER_BUTTON.shouldBe(visible);
        FEED_BUTTON.shouldBe(visible);
        HOBBY_BUTTON.shouldBe(visible);
    }
}
