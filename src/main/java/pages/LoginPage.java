package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends LoadableComponent<LoginPage> {
    private WebDriver driver;
    private static final String LOGIN = "technopol51";
    private static final String PASSWORD = "technopolisPassword";
    private static final By MESSAGE_BUTTON = By.xpath(".//*[@data-l='t,messages']");
    private static final By NOTIFICATIONS_BUTTON = By.xpath(".//*[@data-l='t,notifications']");
    private static final By GUESTS_BUTTON = By.xpath(".//*[@data-l='t,guests']");
    private static final By LOGIN_FIELD = By.id("field_email");
    private static final By PASSWORD_FIELD = By.id("field_password");
    private static final By SIGN_IN_BUTTON = By.xpath(".//*[@data-l='t,sign_in']");
    private static final By RESTORE_BUTTON = By.xpath(".//*[@data-l='t,restore']");
    private static final By QR_BUTTON = By.xpath(".//*[@data-l='t,get_qr']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage login() {
        $(LOGIN_FIELD).setValue(LOGIN);
        $(PASSWORD_FIELD).setValue(PASSWORD);
        $(SIGN_IN_BUTTON).shouldBe(visible.because("The sign in button should be visible before clicking")).click();
        return new MainPage();
    }

    public SelenideElement getMessageButton() {
        return $(MESSAGE_BUTTON);
    }

    public SelenideElement getNotificationsButton() {
        return $(NOTIFICATIONS_BUTTON);
    }

    public SelenideElement getGuestsButton() {
        return $(GUESTS_BUTTON);
    }

    @Override
    protected void load() {
        driver.get("https://ok.ru/");
    }

    @Override
    protected void isLoaded() throws Error {
        checkPage();
    }

    private void checkPage() {
        $(SIGN_IN_BUTTON).shouldBe(visible.because("The sign in button should be visible"));
        $(RESTORE_BUTTON).shouldBe(visible.because("The restore button should be visible"));
        $(QR_BUTTON).shouldBe(visible.because("The QR button should be visible"));
    }
}
