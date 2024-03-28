package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement PROFILE_SETTINGS_BUTTON = $(By.cssSelector(".ucard-mini.toolbar_ucard.js-toolbar-menu.__a11y"));
    private final SelenideElement TOOLBAR_LOGOUT_BUTTON = $(By.cssSelector(".toolbar_accounts-user-delete-button"));
    private final SelenideElement LOGOUT_FORM = $(By.id("hook_Form_PopLayerLogoffUserModalForm"));
    private final SelenideElement LOGOUT_BUTTON = $(By.id("hook_FormButton_logoff.confirm_not_decorate"));
    private final SelenideElement MESSAGE_BUTTON = $(By.id("msg_toolbar_button"));

    public MessagePage goToMessage() {
        MESSAGE_BUTTON.shouldBe(visible).click();
        return new MessagePage();
    }

    public void logout() {
        PROFILE_SETTINGS_BUTTON.shouldBe(visible).click();
        TOOLBAR_LOGOUT_BUTTON.shouldBe(visible).click();
        LOGOUT_FORM.shouldBe(visible).click();
        LOGOUT_BUTTON.shouldBe(visible).click();
    }
}
