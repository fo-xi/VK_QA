package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    private static final String URL = "https://ok.ru/";

    @BeforeAll
    public static void start() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = URL;
        open("/");
    }
}
