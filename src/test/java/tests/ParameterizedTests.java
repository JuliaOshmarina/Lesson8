package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("SMOKE")
public class ParameterizedTests extends TestBase{

    @ValueSource(strings =  {"О магазине", "Новости", "Контакты"})
    @ParameterizedTest(name = "Проверка наличия главных кнопок меню")
    public void parameterMenuTest(String menu) {
        $("[id=top-menu]").$((byText(menu))).click();
        $("div#workarea h2").shouldHave(Condition.text(menu));
    }


    @CsvFileSource(resources = "/test_data/searchCategoryMenu.csv" )
    @ParameterizedTest(name = "Проверка наличия категорий на странице")
    public void parameterCategoryTest(String category) {
        $("[id=left-menu]").$((byText(category))).click();
        $("div#workarea h2").shouldHave(Condition.text(category));
    }


    static Stream<String> menuCategoryTest() {
        return Stream.of("О магазине", "Новости", "Контакты");
    }

    @MethodSource("menuCategoryTest")
    @ParameterizedTest(name = "Проверка наличия главных кнопок меню stream")
    public void menuCategoryTest(String menuStream) {
        $("[id=top-menu]").$((byText(menuStream))).click();
        $("div#workarea h2").shouldHave(Condition.text(menuStream));
    }


}
