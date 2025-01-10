package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ParameterizedTests extends TestBase{

    @Test
    @ValueSource(strings =  {"О магазине", "Новости", "Контакты"})
    @Tag("SMOKE")
    @ParameterizedTest(name = "Проверка наличия главных кнопок меню")
    public void parameterMenuTest(String Menu) {
        $("[id=top-menu]").$((byText(Menu))).click();
        $("div#workarea h2").shouldHave(Condition.text(Menu));
    }


    @CsvFileSource(resources = "/test_data/searchCategoryMenu.csv" )
    @Tag("SMOKE")
    @ParameterizedTest(name = "Проверка наличия категорий на странице")
    public void parameterCategoryTest(String Category) {
        $("[id=left-menu]").$((byText(Category))).click();
        $("div#workarea h2").shouldHave(Condition.text(Category));
    }


    static Stream<String> menuCategoryTest() {
        return Stream.of("О магазине", "Новости", "Контакты");
    }

    @MethodSource("menuCategoryTest")
    @Tag("SMOKE")
    @ParameterizedTest(name = "Проверка наличия главных кнопок меню stream")
    public void menuCategoryTest(String MenuStream) {
        $("[id=top-menu]").$((byText(MenuStream))).click();
        $("div#workarea h2").shouldHave(Condition.text(MenuStream));
    }


}
