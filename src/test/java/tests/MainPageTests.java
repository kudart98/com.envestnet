package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Tag("web")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Footer contain copyright")
    void footerExist() {
        open("");
        $(By.id("block-envestnet-global-blocks-copyright-info"))
                .scrollIntoView(true)
                .shouldHave(text("© 2008 - 2021 Envestnet. All rights reserved."));
    }

    @Test
    @DisplayName("Base header buttons was loaded - test should fail")
    void headerButtonsLoadedFail() {
        open("");
        $(By.id("menu-2188-1"))
                .should(exist)
                .shouldHave(text("Our Platform"));
        $(By.id("menu-8681-1"))
                .should(exist)
                .shouldHave(text("Our Platform"));

    }

    @Test
    @DisplayName("Base header buttons was loaded")
    void headerButtonsLoaded(){
        open("");
        $(By.id("menu-2188-1"))
                .should(visible)
                .shouldHave(text("Our Platform"));
        $(By.id("menu-8681-1"))
                .should(visible)
                .shouldHave(text("Our Vision"));
        $(By.id("menu-8686-1"))
                .should(visible)
                .shouldHave(text("Our Clients"));
        $(By.id("menu-1092-1"))
                .should(visible)
                .shouldHave(text("Resources"));
        $(By.id("menu-855-1"))
                .should(visible)
                .shouldHave(text("About"));
    }

    @Test
    @DisplayName("Main page has text 'The Power of Unified Advice'")
    void mainPageHasSomeText(){
        open("");
        $(By.className("heroLine2"))
                .shouldHave(text("The Power of Unified Advice"));
    }

}
