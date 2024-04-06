package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MessagePage {

    public MessagePage() {
        checkPage();
    }

    public void createChat(String name) {
        SelenideElement homeButton = $(By.xpath(".//*[@data-tsid='msg_settings_button']"));
        SelenideElement plusButton = $(By.xpath(".//*[@data-l='t, createMenu']"));
        SelenideElement createChatButton =
                $(By.xpath(".//msg-menu[@id='msg-new-menu']/slot/msg-menu-item"));
        SelenideElement chatInput = $(By.xpath(".//*[@data-tsid='chat-theme-input']"));
        SelenideElement createNewChatButton =
                $(By.xpath(".//*[@data-tsid='finish_create_chat_button']"));

        homeButton.shouldBe(visible).click();
        plusButton.shouldBe(visible).click();
        createChatButton.shouldBe(visible).click();
        chatInput.shouldBe(visible).setValue(name);
        createNewChatButton.shouldBe(visible).click();
    }

    public void searchChat(String searchLine) {
        SelenideElement chatSearchButton = $(By.xpath(".//*[@data-tsid='chat-search-input']"));
        chatSearchButton.shouldBe(visible).click();
        chatSearchButton.shouldBe(visible).setValue(searchLine);
    }

    public void removeChat() {
        SelenideElement chatInformationButton = $(By.xpath(".//*[@data-tsid='chat_info_button']"));
        SelenideElement removeChatButton = $(By.xpath(".//*[@data-tsid='remove-dialog-btn']"));
        SelenideElement removeButton = $(By.xpath(".//*[@data-tsid='confirm-primary']"));

        chatInformationButton.shouldBe(visible).click();
        removeChatButton.shouldBe(visible).click();
        removeButton.shouldBe(visible).click();
    }

    public void sendMessage(String message) {
        SelenideElement messageField = $(By.xpath(".//*[@data-tsid='write_msg_input-input']"));
        SelenideElement sendMessageButton = $(By.xpath(".//*[@data-tsid='button_send']"));

        messageField.shouldBe(visible).setValue(message);
        sendMessageButton.shouldBe(visible).click();
    }

    public void removeMessage() {
        SelenideElement removeButton = $(By.xpath(".//*[@data-tsid='confirm-primary']"));
        SelenideElement messageCheckBox = $(By.xpath(".//*[@data-l='t,selectMultiple']"));
        SelenideElement removeMessageButton = $(By.xpath(".//*[@data-tsid='control-remove']"));

        messageCheckBox.shouldBe(visible).click();
        removeMessageButton.shouldBe(visible).click();
        removeButton.shouldBe(visible).click();
    }

    private void checkPage() {
        SelenideElement homeButton = $(By.xpath(".//*[@data-tsid='msg_settings_button']"));
        SelenideElement plusButton = $(By.xpath(".//*[@data-l='t, createMenu']"));
        SelenideElement messageTitle = $(By.xpath(".//msg-l10n[text()='Сообщения']"));

        homeButton.shouldBe(visible);
        plusButton.shouldBe(visible);
        messageTitle.shouldBe(visible);
    }
}
