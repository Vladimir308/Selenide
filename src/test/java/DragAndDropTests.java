import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
        import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests{

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void dragAndDrop() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $$(".column").get(1).shouldHave(text("A"));
    }

    @Test
    void anotherDragAndDrop() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().moveToElement($("#column-a")).clickAndHold()
                .moveToElement($("#column-b")).release().perform();
        $$(".column").get(1).shouldHave(text("A"));
    }
}