package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class HerokuAppTest {

    @BeforeEach
    void preconditions() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browserSize = "1920x1280";
    }

    @AfterEach
    void afterEach() {
    Selenide.closeWebDriver();
    }

    @Test
    void checkActionsTest() {
        open("drag_and_drop");

        SelenideElement elemA = $("#column-a");
        SelenideElement elemB = $("#column-b");

        actions()
                .clickAndHold(elemA)
                .moveToElement(elemB)
                .release()
                .perform();

        elemA.$("header").shouldHave(text("B"));
        elemB.$("header").shouldHave(text("A"));
    }

    @Test
    void checkDragAndDropTest() {
        open("drag_and_drop");

        SelenideElement elemA = $("#column-a");
        SelenideElement elemB = $("#column-b");

        $(elemA).dragAndDrop(to(elemB));

        $(elemB).shouldHave(text("A"));
        $(elemA).shouldHave(text("B"));

    }
}

//$("#column-a").$(byTagAndText("header", "B")).shouldNotBe(exist);// В колонке А НЕТ заголовка "B"
//$("#column-b").$(byTagAndText("header", "A")).shouldNotBe(exist);
//$("#column-a").dragAndDrop(to("#column-b"));
//$("#column-a").$(byTagAndText("header", "B")).shouldBe(exist);// В колонке А ПОЯВИЛСЯ заголовок "B"
//$("#column-b").$(byTagAndText("header", "A")).shouldBe(exist);



// Более читаемый вариант
//$("#column-a header").shouldHave(text("A"));
//$("#column-b header").shouldHave(text("B"));
//$("#column-a").dragAndDrop(to("#column-b"));
//$("#column-a header").shouldHave(text("B"));
//$("#column-b header").shouldHave(text("A"));



// Запоминаем исходные заголовки
//String headerA = $("#column-a header").getText();
//String headerB = $("#column-b header").getText();
// Выполняем Drag&Drop
//$("#column-a").dragAndDrop(to("#column-b"));
// Проверяем, что заголовки поменялись
//$("#column-a header").shouldHave(text(headerB));  // В А теперь заголовок из В
//$("#column-b header").shouldHave(text(headerA));  // В В теперь заголовок из А


