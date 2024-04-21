package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private static final By MESSAGE_BUTTON = By.xpath(".//*[@data-l='t,messages']");
    private static final By PROFILE_SETTINGS_BUTTON =
            By.xpath(".//*[@aria-controls='user-dropdown-menu']");
    private static final By LOGOUT_FORM = By.xpath(".//a[@data-l='t,logout']");
    private static final By LOGOUT_BUTTON = By.xpath(".//input[@data-l='t,logout']");
    private static final By USER_BUTTON = By.xpath(".//*[@data-l='t,userPage']");
    private static final By FEED_BUTTON = By.xpath(".//*[@data-l='t,userMain']");
    private static final By HOBBY_BUTTON = By.xpath(".//*[@data-l='t,hobby']");

    public MainPage() {
        checkPage();
    }

    public MessagePage goToMessage() {
        $(MESSAGE_BUTTON).shouldBe(visible.because("The message button should be visible before clicking")).click();
        return new MessagePage();
    }

    public void logout() {
        $(PROFILE_SETTINGS_BUTTON).shouldBe(visible.
                because("The profile settings button should be visible before clicking")).click();
        $(LOGOUT_FORM).shouldBe(visible.because("The logout form should be visible before clicking")).click();
        $(LOGOUT_BUTTON).shouldBe(visible.because("The logout button should be visible before clicking")).click();
    }

    private void checkPage() {
        $(USER_BUTTON).shouldBe(visible.because("The user button should be visible"));
        $(FEED_BUTTON).shouldBe(visible.because("The feed button should be visible"));
        $(HOBBY_BUTTON).shouldBe(visible.because("The hobby button should be visible"));
    }
}
