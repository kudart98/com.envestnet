package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Tag("web")
public class NewUserRegistrationTests extends TestBase {
    final String FIRM = "OOO TRII KOTE";
    final String CRD = "GH1234";
    final String BROKER = "Mister Broker";
    final String NAME = "Artem";
    final String LASTNAME = "Petrov";
    final String ADDRESS = "851 Lion Main 365";
    final String CITY = "Philadelphia";
    final String STATE = "PA";
    final String ZIP = "NO LETTERS";
    final String PHONE = "8213564231";
    final String LOGIN = "vestVulcano";
    final String PASSWORD = "GHJE-#@$%-trew";

    @Test
    @DisplayName("Negative. User register w/o email and postal. Bug here, email is required but no error")
    void registerNoEmail() {
        open("");
        $(By.cssSelector("a[class='menu-392']")).click();
        $(".page_intro").shouldHave(text("Advisor Registration"));
        $(By.name("branch_name")).setValue(FIRM);
        $(By.name("advisor_num")).setValue(CRD);
        $(By.name("info_bd")).setValue(BROKER);
        $(By.name("first_name")).setValue(NAME);
        $(By.name("last_name")).setValue(LASTNAME);
        $(By.name("primary_address_line1")).setValue(ADDRESS);
        $(By.name("primary_city")).setValue(CITY);
        $(By.name("primary_state")).setValue(STATE);
        $(By.name("primary_zip")).setValue(ZIP);
        $(By.name("primary_phone1")).setValue(PHONE);
        //$(By.name("user_name")).setValue(LOGIN);
        $(By.name("new_password")).setValue(PASSWORD);
        $(By.name("verify_password")).setValue(PASSWORD);
        $(By.name("submit_update")).click();
        //verification
        $$(".error_list").shouldHave(texts("Postal code is required"));
        $$(".error_list").shouldHave(texts("Email is required"));
    }

    @Test
    @DisplayName("Negative. User register w/o Login and ZIP")
    void registerWithoutData() {
        open("");
        $(By.cssSelector("a[class='menu-392']")).click();
        $(".page_intro").shouldHave(text("Advisor Registration"));
        $(By.name("branch_name")).setValue(FIRM);
        $(By.name("advisor_num")).setValue(CRD);
        $(By.name("info_bd")).setValue(BROKER);
        $(By.name("first_name")).setValue(NAME);
        $(By.name("last_name")).setValue(LASTNAME);
        $(By.name("primary_address_line1")).setValue(ADDRESS);
        $(By.name("primary_city")).setValue(CITY);
        $(By.name("primary_state")).setValue(STATE);
        //$(By.name("primary_zip")).setValue(ZIP);
        $(By.name("primary_phone1")).setValue(PHONE);
        //$(By.name("user_name")).setValue(LOGIN);
        $(By.name("new_password")).setValue(PASSWORD);
        $(By.name("verify_password")).setValue(PASSWORD);
        $(By.name("submit_update")).click();
        //verification
        $$(".error_list").shouldHave(texts("Login name is required"));
        $$(".error_list").shouldHave(texts("Postal code is required"));
    }
}
