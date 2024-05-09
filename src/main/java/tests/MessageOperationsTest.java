package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;
import pages.MainPage;
import pages.MessagePage;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Message Operations Test")
public class MessageOperationsTest extends BaseTest {
    private final static int NUMBER_CHATS = 3;
    private final String CHAT_NAME = UUID.randomUUID().toString();
    private MainPage mainPage;
    private MessagePage messagePage;
    private List<String> chatNames = new ArrayList<>();

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage(driver).get();
        mainPage = loginPage.login();
        messagePage = mainPage.goToMessage();
        messagePage.createChat(CHAT_NAME);
    }

    @Test
    @Tag("Chat")
    @DisplayName("Create Chat Test")
    public void createChatTest() {
        assertTrue(messagePage.getChatList().searchElement(CHAT_NAME).shouldBe(Condition.exist).exists(),
                "Chat must exist after creation");
    }

    @TestFactory
    @Tag("Chat")
    @DisplayName("Create Multiple Chats Test")
    Stream<DynamicTest> createMultipleChatsTest() {
        generateRandomChatNames(NUMBER_CHATS);
        return chatNames.stream().map(chatName ->
                DynamicTest.dynamicTest("Chat must exist after creation: " + chatName, () -> {
                    messagePage.createChat(chatName);
                    assertTrue(messagePage.getChatList().searchElement(chatName)
                            .shouldBe(Condition.exist).exists());
                })
        );
    }

    @Test
    @Tag("Chat")
    @DisplayName("Search Chat Test")
    public void searchChatTest() {
        messagePage.searchChat(CHAT_NAME);
        assertTrue(messagePage.getResultsList().searchElement(CHAT_NAME).exists(),
                "Chat should be found after searching");
    }

    @Test
    @Tag("Chat")
    @DisplayName("Remove Chat Test")
    public void removeChatTest() {
        removeChat();
        Selenide.refresh();
        assertFalse(messagePage.getChatList().searchElement(CHAT_NAME).exists(),
                "Chat should not exist after deletion");
    }

    @ParameterizedTest(name = "Sending a message with the text: {0}.")
    @ValueSource(strings = {"First Message", "Second Message", "Third Message"})
    @Tag("Message")
    @DisplayName("Send Message Test")
    public void SendMessagesTest(String messageText) {
        searchChat();
        messagePage.sendMessage(messageText);
        assertTrue(messagePage.getMessageList().searchElement(messageText).exists(),
                "Message must exist after sending");
    }

    @Test
    @Tag("Message")
    @DisplayName("Remove Message Test")
    public void removeMessageTest() {
        String firstMessage = UUID.randomUUID().toString();
        searchChat();
        messagePage.sendMessage(firstMessage);
        messagePage.getMessage().searchElement(firstMessage).shouldBe(visible).hover();
        messagePage.removeMessage();
        Selenide.refresh();
        assertFalse(messagePage.getMessageList().searchElement(firstMessage).exists(),
                "Message should not exist after deletion");
    }

    @Test
    @Tag("Message")
    @DisplayName("Close Message Window Test")
    public void closeMessageWindowTest() {
        removeChat();
        messagePage.closeMessageWindow();
        assertFalse(messagePage.getMessageWindow().exists(),
                "The message box should not exist after it is deleted");
    }

    private void removeChat() {
        searchChat();
        messagePage.removeChat();
    }

    private void searchChat() {
        messagePage.searchChat(CHAT_NAME);
        messagePage.getResultsList().searchElement(CHAT_NAME)
                .shouldBe(visible.because("The chat should be visible before clicking")).click();
    }

    private void generateRandomChatNames(int count) {
        for (int i = 0; i < count; i++) {
            chatNames.add(UUID.randomUUID().toString());
        }
    }

    private void removeMultipleChats() {
        for (String chatName : chatNames) {
            if (messagePage.getChatList().searchElement(chatName).exists()) {
                messagePage.searchChat(chatName);
                messagePage.getResultsList().searchElement(chatName)
                        .shouldBe(visible.because("The chat should be visible before clicking")).click();
                messagePage.removeChat();
            }
        }
    }

    @AfterEach
    public void setDown() {
        if (messagePage.getChatList().searchElement(CHAT_NAME).exists()) {
            removeChat();
        }

        removeMultipleChats();

        if (mainPage != null) {
            mainPage.logout();
        }
    }
}
