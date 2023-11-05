package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void succesfulRegistrationTest() {
        open("/automation-practice-form");
        String userName = "Ann";
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("userName");
        $("#lastName").setValue("Tser");
        $("#userEmail").setValue("ann@tser.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Moscow BC 11");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName));
        $(".table-responsive").shouldHave(text("Tser"));
        $(".table-responsive").shouldHave(text("ann@tser.com"));
        $(".table-responsive").shouldHave(text("0123456789"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("30 July,1990"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("1.png"));
        $(".table-responsive").shouldHave(text("Moscow BC 11"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
    }
}