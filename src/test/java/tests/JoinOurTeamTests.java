package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Tag("web")
public class JoinOurTeamTests extends TestBase{
    final String JOB = "Senior Cloud Network Engineer";

    @Test
    @DisplayName("Explore " + JOB +  " career opportunity")
    void QaRole() {
        open("");
        $("#menu-855-1").click();
        $("#menu-8771-1").click();
        switchTo().frame("jv_careersite_iframe_id");
        $(byText("Select a Location")).click();
        $(byText("All USA")).click();
        $("#jv-search-keyword").setValue(JOB);
        $(byText("Search")).click();
        $$(".jv-job-list.jv-search-list")
                .shouldHave(texts(JOB));
    }
}
