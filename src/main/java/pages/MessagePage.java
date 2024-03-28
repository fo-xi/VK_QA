package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MessagePage {

    private final SelenideElement HOME_BUTTON = $(By.cssSelector("[data-tsid='msg_settings_button']"));
    private final SelenideElement PLUS_BUTTON = $(By.cssSelector("[data-l='t, createMenu']"));
    private final SelenideElement CREATE_CHAT_BUTTON = $(By.xpath("//msg-menu[@id='msg-new-menu']" +
            "/slot/msg-menu-item"));
    private final SelenideElement CREATE_NEW_CHAT_BUTTON = $(By.cssSelector("[data-tsid='finish_create_chat_button']"));
    private final SelenideElement  CHAT_INPUT = $(By.cssSelector("[data-tsid='chat-theme-input']"));
    private final SelenideElement CHAT_SEARCH_INPUT = $(By.cssSelector("[data-tsid='chat-search-input']"));
    private final SelenideElement  CHAT_INFORMATION_BUTTON = $(By.cssSelector("[data-tsid='chat_info_button']"));
    private final SelenideElement REMOVE_CHAT_BUTTON = $(By.cssSelector("[data-tsid='remove-dialog-btn']"));
    private final SelenideElement REMOVE_BUTTON = $(By.cssSelector("[data-tsid='confirm-primary']"));
    public void createChat(String name) {
        HOME_BUTTON.shouldBe(visible).click();
        PLUS_BUTTON.shouldBe(visible).click();
        CREATE_CHAT_BUTTON.shouldBe(visible).click();
        CHAT_INPUT.setValue(name);
        CREATE_NEW_CHAT_BUTTON.click();
    }

    public void searchChat(String searchLine) {
        CHAT_SEARCH_INPUT.shouldBe(visible).click();
        CHAT_SEARCH_INPUT.setValue(searchLine);
    }

    public void removeChat() {
        CHAT_INFORMATION_BUTTON.shouldBe(visible).click();
        REMOVE_CHAT_BUTTON.shouldBe(visible).click();
        REMOVE_BUTTON.shouldBe(visible).click();
    }
}
