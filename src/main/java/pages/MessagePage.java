package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MessagePage {

    private final SelenideElement MESSAGE_TITLE = $(By.xpath(".//msg-l10n[text()='Сообщения']"));
    private final SelenideElement HOME_BUTTON = $(By.xpath(".//*[@data-tsid='msg_settings_button']"));
    private final SelenideElement PLUS_BUTTON = $(By.xpath(".//*[@data-l='t, createMenu']"));
    private final SelenideElement CREATE_CHAT_BUTTON = $(By.xpath(".//msg-menu[@id='msg-new-menu']" +
            "/slot/msg-menu-item"));
    private final SelenideElement CREATE_NEW_CHAT_BUTTON =
            $(By.xpath(".//*[@data-tsid='finish_create_chat_button']"));
    private final SelenideElement CHAT_INPUT = $(By.xpath(".//*[@data-tsid='chat-theme-input']"));
    private final SelenideElement CHAT_SEARCH_INPUT =
            $(By.xpath(".//*[@data-tsid='chat-search-input']"));
    private final SelenideElement  CHAT_INFORMATION_BUTTON =
            $(By.xpath(".//*[@data-tsid='chat_info_button']"));
    private final SelenideElement REMOVE_CHAT_BUTTON =
            $(By.xpath(".//*[@data-tsid='remove-dialog-btn']"));
    private final SelenideElement REMOVE_BUTTON = $(By.xpath(".//*[@data-tsid='confirm-primary']"));

    public MessagePage() {
        checkPage();
    }

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

    private void checkPage() {
        HOME_BUTTON.shouldBe(visible);
        PLUS_BUTTON.shouldBe(visible);
        MESSAGE_TITLE.shouldBe(visible);
    }
}
