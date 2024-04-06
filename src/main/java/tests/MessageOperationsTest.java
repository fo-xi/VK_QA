package tests;

import java.util.UUID;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.MainPage;
import pages.MessagePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Message Operations Test")
public class MessageOperationsTest extends BaseTest {
    private final ElementsCollection CHAT_LIST = $$(By.xpath(".//msg-chats-list-item"));
    private final ElementsCollection RESULTS_LIST = $$(By.xpath(".//msg-search-results-item"));
    private final ElementsCollection MESSAGE_LIST = $$(By.xpath(".//msg-message-list"));
    private final String CHAT_NAME = UUID.randomUUID().toString();
    private final LoginPage loginPage = new LoginPage();
    private MainPage mainPage;
    private MessagePage messagePage;

    @BeforeEach
    public void setup() {
        start();
        mainPage = loginPage.login();
        messagePage = mainPage.goToMessage();
        messagePage.createChat(CHAT_NAME);
    }

    @Test
    @Tag("Chat")
    @DisplayName("Create Chat Test")
    public void createChatTest() {
        assertTrue(CHAT_LIST.findBy(Condition.text(CHAT_NAME)).shouldBe(Condition.exist).exists(),
                "Chat must exist after creation");
    }

    @Test
    @Tag("Chat")
    @DisplayName("Search Chat Test")
    public void searchChatTest() {
        messagePage.searchChat(CHAT_NAME);
        assertTrue(RESULTS_LIST.findBy(Condition.text(CHAT_NAME)).exists(),
                "Chat should be found after searching");
    }

    @Test
    @Tag("Chat")
    @DisplayName("Remove Chat Test")
    public void removeChatTest() {
        removeChat();
        Selenide.refresh();
        assertFalse(CHAT_LIST.findBy(Condition.text(CHAT_NAME)).exists(),
                "Chat should not exist after deletion");
    }

    @ParameterizedTest(name = "Sending a message with the text: {0}.")
    @ValueSource(strings = {"First Message", "Second Message", "Third Message"})
    @Tag("Message")
    @DisplayName("Send Message Test")
    public void SendMessagesTest(String messageText) {
        searchChat();
        messagePage.sendMessage(messageText);
        assertTrue(MESSAGE_LIST.findBy(Condition.text(messageText)).exists(),
                "Message must exist after sending");
    }

    @Test
    @Tag("Message")
    @DisplayName("Remove Message Test")
    public void removeMessageTest() {
        ElementsCollection message = $$(By.xpath(".//msg-message"));
        String firstMessage = UUID.randomUUID().toString();
        searchChat();
        messagePage.sendMessage(firstMessage);
        message.findBy(Condition.text(firstMessage)).shouldBe(visible).hover();
        messagePage.removeMessage();
        Selenide.refresh();
        assertFalse(MESSAGE_LIST.findBy(Condition.text(firstMessage)).exists(),
                "Message should not exist after deletion");
    }

    private void removeChat() {
        searchChat();
        messagePage.removeChat();
    }

    private void searchChat() {
        messagePage.searchChat(CHAT_NAME);
        RESULTS_LIST.findBy(Condition.text(CHAT_NAME)).shouldBe(visible).click();
    }

    @AfterEach
    public void setDown() {
        if (CHAT_LIST.findBy(Condition.text(CHAT_NAME)).exists()) {
            removeChat();
        }

        mainPage.logout();
    }
}
