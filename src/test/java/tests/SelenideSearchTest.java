package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideSearchTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void selenideRepository() {
        //открыть Selenide
        open("/");
        //ввести в поле поиска Selenide
        //нажать enter
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        //кликнуть на первый репозиторий из списка найденных
        $("a[href*='selenide/selenide']").click();
        //$(byAttribute("href", "/selenide/selenide")).click();
        //проверка: selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}

//.classname, #id1, []атрибут, a[href=abc].red
//sleep(5000);