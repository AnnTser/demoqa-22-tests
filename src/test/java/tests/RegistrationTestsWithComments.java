package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTestsWithComments {
    {
        Configuration.pageLoadStrategy = "eager";
    }
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;

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
//        $("#gender-radio-2").click(); //выбор пола //wrong
//        $("#gender-radio-2").parent().click(); //good
        $("#genterWrapper").$(byText("Other")).click(); //good for PageObject (best)
        $("#userNumber").setValue("0123456789");

        $("#dateOfBirthInput").click(); //устанавливаем дату в 4 клика по календарю
        $(".react-datepicker__month-select").selectOption("July"); //так можно сделать, если элемент имеет тег select, а элементы имеют теги option
//      $(".react-datepicker__month-select").selectOptionByValue("6"); //так менее читаемо
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
//        $("#uploadPicture").uploadFromClasspath("src/test/resources/img/1.png"); //метод работает только для type = file, путь копируем из корня папки; метод предплагет, что файл уже лежит загруженный
        $("#uploadPicture").uploadFile(new File ("src/test/resources/img/1.png"));
        $("#currentAddress").setValue("Moscow BC 11");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Tser"), text("ann@tser.com"), text("0123456789"));
    }
}