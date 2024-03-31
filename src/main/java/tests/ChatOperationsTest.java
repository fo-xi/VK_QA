package tests;

import java.util.UUID;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.MessagePage;

import static com.codeborne.selenide.Selenide.$$;

public class ChatOperationsTest extends BaseTest {
    private final ElementsCollection CHAT_LIST = $$(By.xpath(".//msg-chats-list-item"));
    private final ElementsCollection RESULTS_LIST = $$(By.xpath(".//msg-search-results-item"));
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
    public void testCreateChat() {
        CHAT_LIST.findBy(Condition.text(CHAT_NAME)).should(Condition.exist);
    }

    @Test
    public void testSearchChat() {
        messagePage.searchChat(CHAT_NAME);
        RESULTS_LIST.findBy(Condition.text(CHAT_NAME)).should(Condition.exist);
    }

    @Test
    public void testRemoveChat() {
        removeChat();
        CHAT_LIST.findBy(Condition.text(CHAT_NAME)).shouldNot(Condition.exist);
    }

    private void removeChat() {
        messagePage.searchChat(CHAT_NAME);
        RESULTS_LIST.findBy(Condition.text(CHAT_NAME)).click();
        messagePage.removeChat();
    }

    @AfterEach
    public void setDown() {
        if (CHAT_LIST.findBy(Condition.text(CHAT_NAME)).exists()) {
            removeChat();
        }

        mainPage.logout();
    }
}
