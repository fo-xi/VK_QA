package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainToolbar {
    private static final By MESSAGE_BUTTON = By.xpath(".//*[@data-l='t,messages']");
    private static final By PROFILE_SETTINGS_BUTTON =
            By.xpath(".//*[@aria-controls='user-dropdown-menu']");

    public MainToolbar() {
        checkMainToolbar();
    }

    private void checkMainToolbar() {
        $(MESSAGE_BUTTON).shouldBe(visible.because("The message button should be visible"));
        $(PROFILE_SETTINGS_BUTTON).shouldBe(visible.because("The profile settings button should be visible"));
    }

    public SelenideElement getMessageButton() {
        return $(MESSAGE_BUTTON);
    }

    public SelenideElement getProfileSettingsButton() {
        return $(PROFILE_SETTINGS_BUTTON);
    }
}
