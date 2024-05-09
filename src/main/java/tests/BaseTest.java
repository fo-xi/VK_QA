package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.html.HTMLUListElement;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void start() {
        System.setProperty("selenide.browser", "Chrome");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }
}
