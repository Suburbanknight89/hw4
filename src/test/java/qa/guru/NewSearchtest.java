package qa.guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;


public class NewSearchtest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        //Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");;
        $(byText("Wiki")).parent().click();
        //Переход в раздел Wiki проекта
       $(byId("wiki-pages-filter")).setValue("SoftAssertions").pressEnter();
       // Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        //Откройте страницу SoftAssertions
        $(byText("SoftAssertions")).click();
        //проверьте что внутри есть пример кода для JUnit5
        $(byText("Using JUnit5 extend test class:")).shouldBe(visible);
    }
}
