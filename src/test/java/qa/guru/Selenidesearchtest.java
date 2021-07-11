package qa.guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;


public class Selenidesearchtest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void FinAndAssertTest () {
        //Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");;
        $(byText("Wiki")).click();
        //Переход в раздел Wiki проекта
       $(byId("wiki-pages-filter")).setValue("SoftAssertions").pressEnter();
       // Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        //Откройте страницу SoftAssertions
        $(byText("SoftAssertions")).click();
        //проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));


    }
}
