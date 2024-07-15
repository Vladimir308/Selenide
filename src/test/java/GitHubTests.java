import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

    public class GitHubTests {
        @BeforeAll
        static void setUp() {
            Configuration.browserSize = "1920x1080";
            Configuration.pageLoadStrategy = "eager";
        }
        @Test
        void findEnterprize() {
            open("https://github.com");
            $(".Header-old").$(byText("Solutions")).hover();
            $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
            $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
        }
    }

