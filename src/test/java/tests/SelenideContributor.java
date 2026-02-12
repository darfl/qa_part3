package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SelenideContributor {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/selenide/selenide";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void theFirstContributor() {
//подвести мышку к первому аватару из блока contributors
        $("div.Layout-sidebar").$(Selectors.byText("Contributors"))
            //.closest(".BorderGrid-cell").$$("ul li").first().hover();
            .closest("h2").sibling(0).$$("li").first().hover();
//проверка: в всплывающем окне есть текст Andrei Solntsev

        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
    }
}



//нажать во вкладке sources F8, чтобы заморозить окошко или SetTimeout(function () {debugger},5000);
//во вкладке console посмотреть $$(".Popover") проверить наличие селектора на элементах
//$$(".Popover").findBy(Condition.visible).shouldHave(text("Andrei Solntsev"));
//если селектор есть на двух элементах, но один из них не видимый, а нам нужен видимый(и он не первый)