package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void beforeAllSetup() {
        Configuration.browserSize = "1920x1080";
        open("https://gnom59.ru/");
        Configuration.pageLoadStrategy = "eager";
    }


}
