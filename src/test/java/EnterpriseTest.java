import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class EnterpriseTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void enterpriseTest() {
        open("/");
        $x("//button[text()='Solutions']").hover();
        //$("a[href*='/enterprise']").click();
        $x("//span[text()='Enterprises']").click();
        $x("//h2[text()='Enterprise-grade by design']").shouldBe(visible);
        // на плэйрайте $("h2:text('Enterprise-grade by design')").shouldBe(visible);
    }

}


