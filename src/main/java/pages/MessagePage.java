package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.MessageToolbar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MessagePage {

    private static final By CHAT_LIST = By.xpath(".//msg-chats-list-item");
    private static final By RESULTS_LIST = By.xpath(".//msg-search-results-item");
    private static final By MESSAGE_LIST = By.xpath(".//msg-message-list");
    private static final By MESSAGE = By.xpath(".//msg-message");
    private static final By CHAT_INPUT = By.xpath(".//*[@data-tsid='chat-theme-input']");
    private static final By CREATE_NEW_CHAT_BUTTON
            = By.xpath(".//*[@data-tsid='finish_create_chat_button']");
    private static final By CHAT_INFORMATION_BUTTON = By.xpath(".//*[@data-tsid='chat_info_button']");
    private static final By REMOVE_CHAT_BUTTON = By.xpath(".//*[@data-tsid='remove-dialog-btn']");
    private static final By REMOVE_BUTTON = By.xpath(".//*[@data-tsid='confirm-primary']");
    private static final By MESSAGE_FIELD = By.xpath(".//*[@data-tsid='write_msg_input-input']");
    private static final By SEND_MESSAGE_BUTTON = By.xpath(".//*[@data-tsid='button_send']");
    private static final By MESSAGE_CHECKBOX = By.xpath(".//*[@data-l='t,selectMultiple']");
    private static final By REMOVE_MESSAGE_BUTTON = By.xpath(".//*[@data-tsid='control-remove']");
    private static final By MESSAGE_TITLE = By.xpath(".//*[text()='Сообщения']");
    private static final By CLOSE_MESSAGE_WINDOW_BUTTON = By.xpath(".//*[@data-l='t,closeLayer']");
    private static final By MESSAGE_WINDOW = By.xpath(".//*[@data-l='msg_layer']");
    private final MessageToolbar messageToolbar = new MessageToolbar();

    public MessagePage() {
        checkPage();
    }

    public void createChat(String name) {

        messageToolbar.getHomeButton().
                shouldBe(visible.because("The home button should be visible before clicking")).click();
        messageToolbar.getPlusButton().
                shouldBe(visible.because("The plus button should be visible before clicking")).click();
        messageToolbar.getCreateChatButton().shouldBe(visible
                .because("The create chat button should be visible before clicking")).click();
        $(CHAT_INPUT).shouldBe(visible
                .because("The chat input should be visible before setting value")).setValue(name);
        $(CREATE_NEW_CHAT_BUTTON).shouldBe(visible
                .because("The create new chat button should be visible before clicking")).click();
    }

    public void searchChat(String searchLine) {
        messageToolbar.getSearchChatInput().shouldBe(visible
                .because("The search chat button should be visible before clicking")).click();
        messageToolbar.getSearchChatInput().shouldBe(visible
                .because("The search chat button should be visible before setting value")).setValue(searchLine);
    }

    public void removeChat() {
        $(CHAT_INFORMATION_BUTTON).shouldBe(visible
                .because("The chat information button should be visible before clicking")).click();
        $(REMOVE_CHAT_BUTTON).shouldBe(visible
                .because("The remove chat button should be visible before clicking")).click();
        $(REMOVE_BUTTON).shouldBe(visible
                .because("The remove button should be visible before clicking")).click();
    }

    public void sendMessage(String message) {
        $(MESSAGE_FIELD).shouldBe(visible
                .because("The message field should be visible before setting value")).setValue(message);
        $(SEND_MESSAGE_BUTTON).shouldBe(visible
                .because("The send message button should be visible before clicking")).click();
    }

    public void removeMessage() {
        $(MESSAGE_CHECKBOX).shouldBe(visible
                .because("The message checkbox should be visible before clicking")).click();
        $(REMOVE_MESSAGE_BUTTON).shouldBe(visible
                .because("The remove message button should be visible before clicking")).click();
        $(REMOVE_BUTTON).shouldBe(visible
                .because("The remove button should be visible before clicking")).click();
    }

    public void closeMessageWindow() {
        $(CLOSE_MESSAGE_WINDOW_BUTTON).shouldBe(visible
                .because("The close message box button must be visible before clicking")).click();
    }

    private void checkPage() {
        messageToolbar.getHomeButton().shouldBe(visible
                .because("The home button should be visible"));
        messageToolbar.getPlusButton().shouldBe(visible
                .because("The plus button should be visible"));
        $(MESSAGE_TITLE).shouldBe(visible
                .because("The message title should be visible"));
    }

    public ElementsCollection getChatList() {
        return $$(CHAT_LIST);
    }

    public ElementsCollection getResultsList() {
        return $$(RESULTS_LIST);
    }

    public ElementsCollection getMessageList() {
        return $$(MESSAGE_LIST);
    }

    public ElementsCollection getMessage() {
        return $$(MESSAGE);
    }

    public SelenideElement getMessageWindow() {
        return $(MESSAGE_WINDOW);
    }
}
