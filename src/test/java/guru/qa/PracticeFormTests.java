package guru.qa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void FillPracticeForm() {
        open("/automation-practice-form");

        //Вводим значения в поля
        $("#firstName").setValue("Tolyan");
        $("#lastName").setValue("Tolyanov");
        $("#userEmail").setValue("tolyan@mail.ru");
        $(byText("Other")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--023").click();
        $("#subjectsInput").setValue("English").pressEnter().setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("photo.jpg");
        $("#currentAddress").setValue("Some address");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        //Проверяем открывшуюся форму
        $(".modal-body").shouldHave(text("Tolyan Tolyanov"))
        .shouldHave(text("tolyan@mail.ru"))
        .shouldHave(text("Other"))
        .shouldHave(text("1234567890"))
        .shouldHave(text("23 August,2022"))
        .shouldHave(text("English, Maths"))
        .shouldHave(text("Sports, Reading"))
        .shouldHave(text("photo.jpg"))
        .shouldHave(text("Some address"))
        .shouldHave(text("Haryana Karnal"));

    }
}
