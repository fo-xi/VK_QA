package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MessageToolbar {
    private static final By HOME_BUTTON = By.xpath(".//*[@data-tsid='msg_settings_button']");
    private static final By PLUS_BUTTON = By.xpath(".//*[@data-l='t, createMenu']");
    private static final By SEARCH_CHAT_INPUT = By.xpath(".//*[@data-tsid='chat-search-input']");
    private static final By CREATE_CHAT_BUTTON
            = By.xpath(".//msg-menu[@id='msg-new-menu']/slot/msg-menu-item");
    public MessageToolbar() {
        checkMessageToolbar();
    }

    private void checkMessageToolbar() {
        $(HOME_BUTTON).shouldBe(visible.because("The home button should be visible"));
        $(PLUS_BUTTON).shouldBe(visible.because("The plus button should be visible"));
    }

    public SelenideElement getHomeButton() {
        return $(HOME_BUTTON);
    }

    public SelenideElement getPlusButton() {
        return $(PLUS_BUTTON);
    }

    public SelenideElement getSearchChatInput() {
        return $(SEARCH_CHAT_INPUT);
    }

    public SelenideElement getCreateChatButton() {
        return $(CREATE_CHAT_BUTTON);
    }
}
