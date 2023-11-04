package examples;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class CssXpathExamples {

    void cssXpathExamples () {

        // <textarea name="q"
        //title="Поиск" type="search" aria-label="Найти"


        $("[name=q]");
        $("textarea[name=q]");//css-selector
        $x(("//textarea[name=q]"));//xpath-selector
        $(xpath("//textarea[name=q]"));//xpath-selector
        $(byName("q"));


        // <input type="email" class="inputtext login_form_input_box name="email" id="email" data-testid="email">
        $("[data-testid=email]");
        $(by ("data-testid","email"));
        $x("//*[@data-testid='email']");

        // <input type="email" class="inputtext login_form_input_box name="email" id="email">

        $("[id=email]");
        $("#id=email"); // работает только для id
        $(id("email"));


        // <input type="email" class="inputtext login_form_input_box name="email">
        $("[name=email]");
        $(byName("email"));

        // <input type="email" class="inputtext login_form_input_box">
        $("[class=login_form_input_box]");
        $(".login_form_input_box");
        $(".inputtext.login_form_input_box");
        $x("//input[@class='inputtext'] [@class='login_form_input_box']" );


        // <div class ="inputtext">
        //     <input type="email" class="login_form_input_box">
        // <div/>
        $(".inputtext .login_form_input_box"); //пробел означает, что найдет сначала элемент inputtext, а затем login_form_input_box
        $(".inputtext").$( ".login_form_input_box"); //аналогичная запись
        $("div.inputtext input.login_form_input_box"); //аналогичная запись
        $("div.inputtext").$("input.login_form_input_box"); //аналогичная запись


        // <div>Hello, qa.guru!</div>
        $(byText("Hello, qa.guru!")); //поиск по тексту
        $(withText("lo, qa.gu"));  //поиск по куску текста
        $x("//*[contains(text() 'Hello, qa.guru!')]");

    }




}
